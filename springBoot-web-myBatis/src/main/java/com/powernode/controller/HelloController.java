package com.powernode.controller;

import com.powernode.entity.TUser;
import com.powernode.result.CodeEnum;
import com.powernode.result.R;
import com.powernode.service.HelloService;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

@Validated
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
    public R addUser(/*@RequestBody */@Valid TUser user) {
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

    @PostMapping(value = "/web/user/login")
    public R login(
            @RequestParam(value = "username")
            @NotBlank(message = "用户名不能为空")
            @Size(min = 4, max = 20, message = "用户名长度需4-20字符")
            String username,

            @RequestParam(value = "password")
            @NotBlank(message = "密码不能为空")
            @Size(min = 6, max = 180, message = "密码长度需6-180字符")
            String password) {

        // 实际业务逻辑示例（需替换为真实校验逻辑）
        boolean loginSuccess = helloService.validateLogin(username, password);
        if (!loginSuccess) {
            return R.FAIL(CodeEnum.UNAUTHORIZED, "用户名或密码错误");
        }

        // 生成模拟token（需根据实际安全方案实现）
        String token = UUID.randomUUID().toString();
        return R.OK(CodeEnum.OK)
                .putData("token", token)
                .putData("userInfo", userService.getUserByUsername(username));
    }
}
