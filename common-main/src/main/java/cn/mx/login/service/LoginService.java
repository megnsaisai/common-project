package cn.mx.login.service;


import cn.mx.db.entity.response.ResponseResult;
import cn.mx.db.entity.user.User;

public interface LoginService {

    /**
     * 登录
     * @param user
     * @return
     */
    public ResponseResult login(User user);

    /**
     * 退出
     * @return
     */
    public ResponseResult logout();
}
