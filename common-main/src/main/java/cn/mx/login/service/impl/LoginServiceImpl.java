package cn.mx.login.service.impl;

import cn.mx.constants.Constants;
import cn.mx.db.entity.response.ResponseResult;
import cn.mx.db.entity.SysUser.LoginUser;
import cn.mx.db.entity.SysUser.SysUser;
import cn.mx.login.service.LoginService;

import cn.mx.redis.RedisCache;
import cn.mx.security.JwtUtil;
import cn.mx.security.config.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {


    private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private RedisCache redisCache;

    @Autowired
    public void setRedisCache(RedisCache redisCache) {
        this.redisCache = redisCache;
    }


    /**
     * 登录
     *
     * @param sysUser
     * @return
     */
    @Override
    public ResponseResult login(SysUser sysUser) {
        //AuthenticationManager authenticate进行用户认证
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sysUser.getUserName(), sysUser.getPassword()));

        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getSysUser().getId().toString();
        //authenticate存入redis
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(Constants.Redis.LOGIN_USER_ID + jwt,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200L,"登陆成功",map);
    }

    /**
     * 退出
     *
     * @return
     */
    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long userid = loginUser.getSysUser().getId();
        redisCache.deleteObject(Constants.Redis.LOGIN_USER_ID + loginUser.getToken());
        return new ResponseResult(200L,"退出成功");
    }
}
