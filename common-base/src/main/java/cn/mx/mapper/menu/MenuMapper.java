package cn.mx.mapper.menu;

import cn.mx.db.entity.menu.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id查询权限
     * @param id
     * @return
     */
    Set<String> selectPermsByUserId(Long id);
}
