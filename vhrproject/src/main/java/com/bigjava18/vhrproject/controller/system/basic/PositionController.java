package com.bigjava18.vhrproject.controller.system.basic;

import com.bigjava18.vhrproject.model.Position;
import com.bigjava18.vhrproject.model.RespBean;
import com.bigjava18.vhrproject.service.PositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -01 -11 10 :24
 * @Description 职位管理Controller
 */
@RestController
@RequestMapping(value = "/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    /**
     * 查询所用用户职位
     * @return
     */
    @GetMapping("/")
    public List<Position> getAllPositions(){

        return positionService.getAllPositions();
    }

    /**
     * 添加职位
     * @RequestBody：以json的数据返回
     * @param position
     * @return
     */
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){

        //return positionService.addPosition(position);
        if(positionService.addPosition(position)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 更新职位
     * @param position
     * @return
     */
    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Position position){
        if (positionService.updatePositions(position)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * 删除职位
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){

        if (positionService.deletePositionById(id)==1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.ok("删除失败!");
    }

}
