package com.bigjava18.vhrproject.service;

import com.bigjava18.vhrproject.mapper.MenuMapper;
import com.bigjava18.vhrproject.model.Hr;
import com.bigjava18.vhrproject.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zgp
 * @Since 2020 -11 -25 10 :13
 * @Description 系统左边菜单业务逻辑层
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusById() {
        //用户登录成功的信息保存到security中
        //((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId():获取用户的id
        return menuMapper.getMenusById(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    /**
     * 获取所有的菜单角色
     * @return
     */
    //@Cacheable
    public List<Menu> getAllMenusWithRole(){

        return menuMapper.getAllMenusWithRole();
    }
}
