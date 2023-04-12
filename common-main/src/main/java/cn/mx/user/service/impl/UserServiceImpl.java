package cn.mx.user.service.impl;


import cn.mx.db.entity.SysUser.LoginUser;
import cn.mx.db.entity.SysUser.SysUser;
import cn.mx.mapper.sysuser.SysUserMapper;
import cn.mx.security.config.SecurityUtils;
import cn.mx.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {

    private SysUserMapper sysUserMapper;

    @Autowired
    public void setUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
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
        result.put("user", loginUser.getSysUser());
        result.put("permissions", loginUser.getPermissions());
        return result;
    }
}