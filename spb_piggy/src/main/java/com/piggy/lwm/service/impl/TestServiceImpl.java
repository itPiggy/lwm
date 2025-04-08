package com.piggy.lwm.service.impl;

import com.piggy.lwm.mapper.TestMapper;
import com.piggy.lwm.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public String testSelect() {
        return testMapper.testSelect();
    }
}
