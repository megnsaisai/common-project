package cn.mx.user.service.impl;

import cn.mx.db.entity.SysUser.LoginUser;
import cn.mx.db.entity.SysUser.SysUser;
import cn.mx.mapper.sysmenu.SysMenuMapper;
import cn.mx.mapper.sysuser.SysUserMapper;

import cn.mx.utils.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    /**
     * 用户
     */
    private SysUserMapper sysUserMapper;

    @Autowired
    public void setUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 菜单
     */
    private SysMenuMapper sysMenuMapper;

    @Autowired
    public void setMenuMapper(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName,username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        //如果查询不到数据就通过抛出异常来给出提示
        if(Objects.isNull(sysUser)){
            throw new UsernameNotFoundException("账号不存在");
        }
        Set<String> permissionKeyList =  sysMenuMapper.selectPermsByUserId(sysUser.getId());
        //封装成UserDetails对象返回
        return new LoginUser(sysUser, permissionKeyList, DateUtils.getTime(), sysUser.getId());
    }
}