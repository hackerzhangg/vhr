package com.bigjava18.vhrproject.controller.config;

import com.bigjava18.vhrproject.model.Menu;
import com.bigjava18.vhrproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zgp
 * @Since 2020 -11 -25 10 :10
 * @Description 系统配置config
 */
@RestController
@RequestMapping(path = "system/config")
public class SystemConfigController {

    /**
     * 注入menuService
     */
    @Autowired
    MenuService menuService;

    /**
     * 获取不同角色的系统左菜单栏
     * @return
     */
    @GetMapping(path = "/menu")
    public List<Menu> getMenusById(){

        //System.out.println("!!!!!!!!!!!!");
        return menuService.getMenusById();
    }
}
