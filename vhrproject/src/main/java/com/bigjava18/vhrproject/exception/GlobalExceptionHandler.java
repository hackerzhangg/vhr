package com.bigjava18.vhrproject.exception;

import com.bigjava18.vhrproject.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @Author zgp
 * @Since 2021 -01 -11 15 :11
 * @Description 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理slq异常
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        //删除职位时，因外键关联导致的异常
        if(e instanceof MySQLIntegrityConstraintViolationException){

            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库操作异常，操作失败！");
    }
}
