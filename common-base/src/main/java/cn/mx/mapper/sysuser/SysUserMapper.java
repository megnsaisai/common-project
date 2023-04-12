package cn.mx.mapper.sysuser;

import cn.mx.db.entity.SysUser.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author SSS
 * @create 2023/3/7
 */

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
}
