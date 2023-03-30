package cn.mx.user.service;


import cn.mx.db.entity.user.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<User> {


    /**
     * 获取用户信息
     * @return
     */
    Map<String, Object> getUserInfo();
}
