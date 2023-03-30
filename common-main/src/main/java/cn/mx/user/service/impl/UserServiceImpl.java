package cn.mx.user.service.impl;


import cn.mx.db.entity.user.LoginUser;
import cn.mx.db.entity.user.User;
import cn.mx.mapper.user.UserMapper;
import cn.mx.security.config.SecurityUtils;
import cn.mx.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public Map<String, Object> getUserInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Map<String, Object> result = new HashMap<>();
        result.put("user", loginUser.getUser());
        result.put("permissions", loginUser.getPermissions());
        return result;
    }
}