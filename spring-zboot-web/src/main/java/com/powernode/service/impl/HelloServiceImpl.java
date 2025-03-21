package com.powernode.service.impl;

import com.powernode.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello() {
        //调用底层的Mapper查询数据库(下午去开发，先省略一下)
        return "Hello, Spring MVC.";
    }
}