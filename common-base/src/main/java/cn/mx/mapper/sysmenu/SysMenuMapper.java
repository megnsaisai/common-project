package cn.mx.mapper.sysmenu;

import cn.mx.db.entity.sysmenu.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过用户id查询权限
     * @param id
     * @return
     */
    Set<String> selectPermsByUserId(Long id);
}
