package com.bigjava18.vhrproject.controller;

import com.bigjava18.vhrproject.model.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zgp
 * @Since 2020 -11 -11 17 :05
 * @Description 用户登录Controller
 */
//@Controller
@RestController
//@CrossOrigin：前后端分离跨域问题
//@CrossOrigin
public class LoginController {

    @GetMapping("/login")
    //@RequestMapping(path = "/login")
    //@CrossOrigin("*"):当用户没有认证/登录的时候，提示用户（尚未登录，请登录!），这是一种解决办法,在security中还有另一种配置
    public RespBean login(){

        //System.out.println("你已进入login测试方法！");
        //return RespBean.error("尚未登录，请登录!!!!");
        return RespBean.error("尚未登录，请登录!");
    }
}
