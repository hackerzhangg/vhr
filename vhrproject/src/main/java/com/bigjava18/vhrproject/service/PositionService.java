package com.bigjava18.vhrproject.service;

import com.bigjava18.vhrproject.mapper.PositionMapper;
import com.bigjava18.vhrproject.model.Position;
import com.bigjava18.vhrproject.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -01 -11 10 :32
 * @Description
 */
@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    /**
     * 查询所有职位
     * @return
     */
    public List<Position> getAllPositions() {

        return positionMapper.getAllPositions();
    }

    /**
     * 添加职位
     * @param position
     * @return
     */
    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());

        return positionMapper.insertSelective(position);
    }

    /**
     * 更新职位
     * @param position
     * @return
     */
    public int updatePositions(Position position) {
        //position.setEnabled(true);
        //position.setCreateDate(new Date());

        return positionMapper.updateByPrimaryKeySelective(position);
    }

    /**
     * 删除职位
     * @param id
     * @return
     */
    public Integer deletePositionById(Integer id) {

        return  positionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加职位
     * @param position
     * @return
     */
    /*public RespBean addPosition(Position position) {

        return positionMapper.addPosition();
    }*/

}
