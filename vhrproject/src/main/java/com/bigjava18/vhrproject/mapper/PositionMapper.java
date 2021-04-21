package com.bigjava18.vhrproject.mapper;

import com.bigjava18.vhrproject.model.Position;
import com.bigjava18.vhrproject.model.RespBean;

import java.util.List;

public interface PositionMapper {

    /**
     * 删除职位
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    /**
     * 逆向工程生成的添加职位方法
     * 其中：insert和insertSelective的比较，insert是全部插入，insertSelective是通过判断插入字段
     * @param record
     * @return
     */
    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    /**
     * 更新职位
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    /**
     * 查询所有职位
     * @return
     */
    public List<Position> getAllPositions();

    /**
     * 添加职位
     * @param position
     * @return
     */
    /*public Integer addPosition(Position position);*/

    /**
     * 添加职位
     * @return
     */
    //public RespBean addPosition();
}