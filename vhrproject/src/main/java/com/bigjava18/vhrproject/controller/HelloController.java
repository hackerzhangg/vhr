package com.bigjava18.vhrproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zgp
 * @Since 2020 -11 -08 22 :13
 * @Description 测试Controller
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "欢迎来到测试页面，你已测试成功！";
    }

    /**
     * 基本资料的测试
     * @return
     */
    @GetMapping("/employee/basic/hello")
    public String hello2(){

        return "/employee/basic/hello";
    }

    /**
     * 高级资料的测试
     * @return
     */
    @GetMapping("/employee/advanced/hello")
    public String hello3(){

        return "/employee/advanced/hello";
    }
}
