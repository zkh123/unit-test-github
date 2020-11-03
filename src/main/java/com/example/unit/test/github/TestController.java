package com.example.unit.test.github;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingzhidematong
 * @date 2020/10/28
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @GetMapping(value = "/1")
    public Object test1(){
        System.out.println("hello world!");
        return "ok";
    }
}