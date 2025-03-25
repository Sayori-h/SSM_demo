package com.powernode.controller;

import com.powernode.entity.TUser;
import com.powernode.result.CodeEnum;
import com.powernode.result.R;
import com.powernode.service.HelloService;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

@Slf4j
@RestController //这个类是一个控制器类（类似于servlet）
public class HelloController {

    @Resource
    private HelloService helloService;

    @Resource  // 新增依赖注入
    private UserService userService;  // 需要创建该Service类

    @GetMapping(value = "/web/hello") //映射请求的路径
    public String hello() {
        //调用service
        return helloService.hello();  //前缀 + “return的值” + 后缀，就可以找到页面 （/admin/main.jsp）
    }

    @GetMapping(value = "/web/page/{current}")
    public R page(
            @PathVariable(value="current") Integer current) {
        // 调用UserService获取用户数据（例如用户列表）
        return R.OK(CodeEnum.OK, userService.getUserByPage(current));
    }

    @GetMapping(value = "/web/trans")
    public R trans() {
        // 调用UserService获取用户数据（例如用户列表）
        return userService.upDateUser()>=1?R.OK(CodeEnum.OK):R.FAIL(CodeEnum.FAIL);
    }

    //CURD  demo
    //如果前端请求路径在controller方法中找不到，那报404，比如访问/api/user就是404
    @GetMapping(value = "/web/user/{id}")
    public R describeUser(@PathVariable(value="id") Long fId) {
        System.out.println(Thread.currentThread().threadId()+"--"+Thread.currentThread().getName());//主线程
        // 调用UserService获取用户数据（例如用户列表）
        var userCompletableFuture = userService.getUserById(fId);//新线程执行,因为加了@Async注解
        System.out.println(Thread.currentThread().threadId()+"--"+Thread.currentThread().getName());//主线程
        TUser user= null;
        try {
            user = userCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return R.OK(CodeEnum.OK, user);
    }

    @PostMapping(value = "/web/user")
    public R addUser(@RequestBody TUser user) {
        //log.info("用户创建请求参数：{}", new Gson().toJson(user)); // 调试级别日志
        // 新增业务校验（重要！）
        if (user.getFPassword() == null
                &&user.getFId()==null
                &&user.getFNickname()==null
                &&user.getFUserId()==null) {
            log.warn("非法参数：用户创建请求缺少必要字段");  // 警告级别日志
            return R.FAIL(CodeEnum.INVALID_PARAM);
        }
        int res = userService.addUser(user);
        log.info("用户创建结果：{}", res>0?"成功":"失败"); // 信息级别日志
        return R.OK(CodeEnum.OK);
    }

    @PutMapping(value = "/web/user")
    public R modifyUser(/*@RequestBody */TUser user) {
        // 调用UserService获取用户数据（例如用户列表）
        int res = userService.modifyUser(user);
        return res>=1?R.OK(CodeEnum.OK):R.FAIL(CodeEnum.FAIL);
    }

    @DeleteMapping(value = "/web/user/{id}")
    public R deleteUser(@PathVariable(value="id") Long fId) {
        // 调用UserService获取用户数据（例如用户列表）
        int res = userService.DeleteUserById(fId);
        return res>=1?R.OK(CodeEnum.OK):R.FAIL(CodeEnum.FAIL);
    }
}
