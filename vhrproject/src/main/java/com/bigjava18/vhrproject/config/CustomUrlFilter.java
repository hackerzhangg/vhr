package com.bigjava18.vhrproject.config;

import com.bigjava18.vhrproject.model.Menu;
import com.bigjava18.vhrproject.model.Role;
import com.bigjava18.vhrproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -01 -06 14 :28
 * @Description 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 * @Component:组件
 */
@Component
public class CustomUrlFilter implements FilterInvocationSecurityMetadataSource {

    /**
     * 注入menuService
     */
    @Autowired
    MenuService menuService;

    /**
     * 比对工具
     */
    AntPathMatcher antPathMatcher=new AntPathMatcher();

    /**
     * Collection：当前请求需要的角色
     * 根据用户的请求地址判断用户所拥有/需要的角色
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取当前请求的地址
        String requestUrl=((FilterInvocation) object).getRequestUrl();
        //获取所有的请求地址
        List<Menu> menus=menuService.getAllMenusWithRole();
        //对比当前的请求地址和数据库中获取的请求地址是否一致
        for(Menu menu : menus){
            //使用对比工具
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                //获取角色
                List<Role> roles=menu.getRoles();
                String[] str=new String[roles.size()];
                for (int i = 0; i < str.length; i++){
                    str[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        //return null;
        //如果没有匹配成功，登录后可以访问，ROLE_LOGIN：标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        //return false;
        return true;
    }
}
