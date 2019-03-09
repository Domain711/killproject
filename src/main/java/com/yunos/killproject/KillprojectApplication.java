package com.yunos.killproject;

import com.yunos.killproject.dao.UserDOMapper;
import com.yunos.killproject.dao.UserPasswordDOMapper;
import com.yunos.killproject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//scanBasePackages = {"com.yunos.killproject"} 配置默认扫码路径，扫描到controller ,service
@SpringBootApplication(scanBasePackages = {"com.yunos.killproject"})
@RestController
//@MapperScan(basePackages = {"com.yunos.killproject.dao"}) 配置mybatis dao扫描路径
@MapperScan("com.yunos.killproject.dao")
public class KillprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillprojectApplication.class, args);
    }

}
