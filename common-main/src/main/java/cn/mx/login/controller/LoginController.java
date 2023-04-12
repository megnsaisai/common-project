package cn.mx.login.controller;


import cn.mx.db.entity.response.ResponseResult;
import cn.mx.db.entity.SysUser.SysUser;
import cn.mx.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    /**
     * 登录服务
     */
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SysUser sysUser){
        return loginService.login(sysUser);
    }


    @PostMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}