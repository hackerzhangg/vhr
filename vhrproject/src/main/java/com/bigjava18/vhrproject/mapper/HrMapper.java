package com.bigjava18.vhrproject.mapper;

import com.bigjava18.vhrproject.model.Hr;
import com.bigjava18.vhrproject.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    public Hr loadUserByUsername(String username);

    /**
     * 通过用户的id获取用户的角色
     * @param id
     * @return
     */
    public List<Role> getHrRolesById(Integer id);
}