package cn.mx.login.service;


import cn.mx.db.entity.response.ResponseResult;
import cn.mx.db.entity.SysUser.SysUser;

public interface LoginService {

    /**
     * 登录
     * @param sysUser
     * @return
     */
    public ResponseResult login(SysUser sysUser);

    /**
     * 退出
     * @return
     */
    public ResponseResult logout();
}
