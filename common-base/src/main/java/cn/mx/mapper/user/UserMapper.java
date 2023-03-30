package cn.mx.mapper.user;

import cn.mx.db.entity.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author SSS
 * @create 2023/3/7
 */

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
