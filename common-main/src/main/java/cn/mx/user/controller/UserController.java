package cn.mx.user.controller;


import cn.mx.db.entity.response.ResponseResult;
import cn.mx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询用户信息权限
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ResponseResult getUserInfo(){
        Map<String, Object> result = userService.getUserInfo();
        return ResponseResult.error("查询成功", result);
    }


}


