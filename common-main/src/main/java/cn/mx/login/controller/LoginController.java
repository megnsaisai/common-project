package cn.mx.login.controller;


import cn.mx.db.entity.response.ResponseResult;
import cn.mx.db.entity.user.User;
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
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }


    @PostMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}