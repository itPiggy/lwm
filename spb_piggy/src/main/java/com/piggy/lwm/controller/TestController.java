package com.piggy.lwm.controller;

import com.piggy.lwm.service.TestService;
import com.piggy.lwm.util.PasswordUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    /**
     * 测试控制器
     */
    @RequestMapping("test")
    public String test(){
        return testService.testSelect() + ": " + PasswordUtil.degistPwd("123");
    }
}
