package com.bigjava18.vhrproject.service;

import com.bigjava18.vhrproject.mapper.HrMapper;
import com.bigjava18.vhrproject.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author zgp
 * @Since 2020 -11 -08 21 :52
 * @Description 用户业务逻辑层
 */
@Service
public class HrService implements UserDetailsService {

    /**
     * 注入HrMapper
     */
    @Autowired
    HrMapper hrMapper;

    /**
     * 根据用户名加载User对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(username);
        //判断用户是否为空
        if (hr == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        //如果登录成功，设置用户角色
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }
}
