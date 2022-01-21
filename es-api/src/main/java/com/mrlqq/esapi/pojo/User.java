package com.mrlqq.esapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/1/21 16:08
 * @Created by LQQ
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
}
