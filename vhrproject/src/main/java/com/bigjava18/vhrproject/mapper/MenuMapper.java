package com.bigjava18.vhrproject.mapper;

import com.bigjava18.vhrproject.model.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 通过用户的id判单用户的角色并显示左边的菜单
     * @param hrId
     * @return
     */
    public List<Menu> getMenusById(Integer hrId);

    /**
     * 获取所有的菜单角色
     * @return
     */
    public List<Menu> getAllMenusWithRole();
}