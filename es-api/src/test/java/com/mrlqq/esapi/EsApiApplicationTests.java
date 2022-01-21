package com.mrlqq.esapi;

import com.alibaba.fastjson.JSON;
import com.mrlqq.esapi.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * es7.11.2 高级客户端测试API
 */
@SpringBootTest
class EsApiApplicationTests {

    @Resource
    private RestHighLevelClient client;

    // 测试索引的创建 Request
    @Test
    void TestCreateIndex() throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("mrlqq_index");
        // 2、客户端执行请求 IndicesClient ，请求后获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        System.out.println("createIndexResponse = " + createIndexResponse);

    }

    // 测试获得索引，判断其是否存在
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("mrlqq_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("exists = " + exists);
    }

    // 测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("mrlqq_index");
        // 删除
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("delete = " + delete.isAcknowledged());
    }

    // 测试添加文档
    @Test
    void testAddDocument() throws IOException {
        // 创建对象
        User user = new User("钢铁侠", 22);
        // 创建请求
        IndexRequest request = new IndexRequest("mrlqq_index");

        // 规则 put/mrlqq_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");

        // 将我们的数据放入请求 json
        request.source(JSON.toJSONString(user), XContentType.JSON);

        // 客户端发送请求
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status()); // 对应我们命令的返回状态 CREATED


    }

    // 获取文档，判断是否存在
    @Test
    void testIsExists() throws IOException {
        GetRequest getRequest = new GetRequest("mrlqq_index","1");
        // 不获取返回的_source的上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 获取文档信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("mrlqq_index", "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        // 打印文档内容
        System.out.println("getResponse.getSourceAsString() = " + getResponse.getSourceAsString());
        System.out.println("getResponse = " + getResponse);
    }

    // 更新文档信息
    @Test
    void testUpdateRequest() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("mrlqq_index", "1");
        updateRequest.timeout("1s");

        User user = new User("钢铁侠123", 28);
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println("updateResponse.status() = " + updateResponse.status());
    }

    // 删除文档记录
    @Test
    void testDeleteRequest() throws IOException{
        DeleteRequest Request = new DeleteRequest("mrlqq_index", "1");
        Request.timeout("1s");

        DeleteResponse deleteResponse = client.delete(Request, RequestOptions.DEFAULT);
        System.out.println("deleteResponse.status() = " + deleteResponse.status());
    }

    // 批量插入数据
    @Test
    void testBulkRequest() throws IOException{
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("20s");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));

        // 批量处理请求
        for (int i = 0; i < userList.size(); i++) {
            // 批量更新和批量和删除，就在这里修改对应的请求就可以
            bulkRequest.add(new IndexRequest("mrlqq_index")
                    .id(String.valueOf(i+1))
                    .source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        // 是否失败，false：表示成功没有失败
        System.out.println("bulkResponse.hasFailures() = " + bulkResponse.hasFailures());

    }

    // 查询
    // SearchRequest 搜索请求
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 构建高亮
    //
    //   QueryBuilders 搜索条件构建器
    //          termQueryBuilder 构建精确查询
    //          matchQueryBuilder 构建匹配查询
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mrlqq_index");
        // 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询条件，我们可以使用QueryBuilders工具来实现
        // QueryBuilders.termQuery 精确查询
        // QueryBuilders.matchAllQuery 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "钢铁侠1");
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "钢铁");
        //MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

        sourceBuilder.query(matchQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        System.out.println("++++++++++++++++++++++++++++");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println("documentFields.getSourceAsMap() = " + documentFields.getSourceAsMap());
        }
    }
}
