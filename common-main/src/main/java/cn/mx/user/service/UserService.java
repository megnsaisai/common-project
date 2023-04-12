package cn.mx.user.service;


import cn.mx.db.entity.SysUser.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<SysUser> {


    /**
     * 获取用户信息
     * @return
     */
    Map<String, Object> getUserInfo();
}
