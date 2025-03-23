package com.powernode.controller;

import com.github.pagehelper.PageHelper;
import com.powernode.constant.Constants;
import com.powernode.entity.TUser;
import com.powernode.result.CodeEnum;
import com.powernode.result.R;
import com.powernode.service.HelloService;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //这个类是一个控制器类（类似于servlet）
public class HelloController {

    @Resource
    private HelloService helloService;

    @Resource  // 新增依赖注入
    private UserService userService;  // 需要创建该Service类

    @RequestMapping(value = "/web/hello") //映射请求的路径
    public @ResponseBody String hello() {
        //调用service
        return helloService.hello();  //前缀 + “return的值” + 后缀，就可以找到页面 （/admin/main.jsp）
    }

    //如果前端请求路径在controller方法中找不到，那报404，比如访问/api/user就是404
    @RequestMapping(value = "/web/user")
    public @ResponseBody R user() {
        // 调用UserService获取用户数据（例如用户列表）
        TUser userById = userService.getUserById(10001L);
        return R.OK(CodeEnum.OK, userById);
    }

    @RequestMapping(value = "/web/page")
    public @ResponseBody R page(
            @RequestParam(value="current") Integer current) {
        // 调用UserService获取用户数据（例如用户列表）
        return R.OK(CodeEnum.OK, userService.getUserByPage(current));
    }

    @RequestMapping(value = "/web/trans")
    public @ResponseBody R trans() {
        // 调用UserService获取用户数据（例如用户列表）
        return userService.upDateUser()>=1?R.OK(CodeEnum.OK):R.FAIL(CodeEnum.FAIL);
    }
}
