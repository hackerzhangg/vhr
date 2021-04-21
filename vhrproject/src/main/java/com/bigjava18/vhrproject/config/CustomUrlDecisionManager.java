package com.bigjava18.vhrproject.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import java.util.Collection;

/**
 * @Author zgp
 * @Since 2021 -01 -06 15 :26
 * @Description 去判断当前用户是否具备这样的角色
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    //Authentication:当前用户登录的信息，包含用户角色
    //Collection<ConfigAttribute> collection):就是MyFilter中Collection方法的返回值
    //collection：需要的角色
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //遍历所需要的角色
        for (ConfigAttribute configAttribute : collection){
            //需要的角色
            String needRole = configAttribute.getAttribute();
            //用户登录之后就可以访问
            if (needRole.equals("ROLE_LOGIN")){
                //判断用户是否登录
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录！");
                }else{
                    return;
                }
            }
            //获取当前用户登录的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            //authorities中的角色是否包含collection角色中的任意一项
            for (GrantedAuthority authority : authorities) {
                //如果相等，表示现在具备你需要角色中的一个
                if (authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {

        return true;
        //return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {

        return true;
        //return false;
    }
}
