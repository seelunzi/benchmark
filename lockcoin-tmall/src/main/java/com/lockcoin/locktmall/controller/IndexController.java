package com.lockcoin.locktmall.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangwenbo
 * @date 2018/2/1
 * @since JDK1.8
 */
@RestController
public class IndexController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/index")
    @ApiOperation("测试用例")
    public ResponseEntity index() {
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
