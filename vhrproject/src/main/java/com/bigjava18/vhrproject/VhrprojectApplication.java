package com.bigjava18.vhrproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//MapperScan:意思是扫描com.bigjava18.vhrproject.mapper下的所有mapper类作为Mapper映射文件
@MapperScan(basePackages = "com.bigjava18.vhrproject.mapper")
//@CrossOrigin
public class VhrprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrprojectApplication.class, args);
    }

}
