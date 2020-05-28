package com.xiaoxin.spring.base.controller;

import com.xiaoxin.spring.base.service.TestService;
import com.xiaoxin.spring.common.message.ResponseCode;
import com.xiaoxin.spring.common.message.ResponseEntity;
import com.xiaoxin.spring.common.message.ResponseHead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name){
        log.info("请求参数:{}",name);
        ResponseEntity<String> entity = new ResponseEntity<>(new ResponseHead(ResponseCode.SUCCESS),name);
        log.info("响应结果:{}",entity);
        return entity;
    }

    @PostMapping("/userReg")
    public ResponseEntity<String> userReg(@PathVariable("name") String name){
        log.info("请求参数:{}",name);
        ResponseEntity<String> entity = new ResponseEntity<>(new ResponseHead(ResponseCode.SUCCESS),name);
        log.info("响应结果:{}",entity);
        return entity;
    }

    @GetMapping("/removefile")
    public ResponseEntity<String> removeFile(){
        String fileName = "pycharm-professional-2019.3.4.exe";
        String oldPath = "G:\\DATA";
        String newPath = "G:\\DATABAK";
        testService.removeFile(fileName,oldPath,newPath);
        return new ResponseEntity<>(new ResponseHead(ResponseCode.SUCCESS),testService.getFileName());
    }
}
