package com.yunos.killproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 文件controlLer
 * @Author: Qin HaiJiang
 * @Date: 2019/3/25 15:43
 */
@Controller
public class FileController extends BaseController{
//
//    private static final String uploadPicturePath = "E://upload/";
//    @javax.annotation.Resource
//    private Resource resourceLoader;
//
//    @RequestMapping("/{fileName:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> show(@PathVariable String fileName){
//        try
//        {
//            //resourceLoader.getResource("file:" + uploadPicturePath + fileName) 返回指定路径的资源句柄，这里返回的就是URL [file:D:/springboot/upload/test.png]
//            //ResponseEntity.ok(T) 返回指定内容主体
//
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPicturePath + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
