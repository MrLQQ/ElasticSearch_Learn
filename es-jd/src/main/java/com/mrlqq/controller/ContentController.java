package com.mrlqq.controller;

import com.mrlqq.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Classname ContentController
 * @Description TODO
 * @Date 2022/1/21 20:05
 * @Created by LQQ
 */

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/parse/{keywords}")
    public boolean parse(@PathVariable("keywords") String keywords) throws IOException {
        return  contentService.parseContent(keywords);
    }

    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keywords") String keywords,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws IOException {
        if (pageNo<=0){
            pageNo = 1;
        }

        // 高亮搜索
        return contentService.searchPageHighlight(keywords,pageNo,pageSize);
    }
}
