package com.mrlqq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Classname Content
 * @Description TODO
 * @Date 2022/1/21 19:48
 * @Created by LQQ
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;
}
