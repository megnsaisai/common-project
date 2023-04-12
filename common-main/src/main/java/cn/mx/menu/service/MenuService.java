package cn.mx.menu.service;

import cn.mx.db.entity.sysmenu.dto.SysMenuDTO;

import java.util.List;

public interface MenuService {

    /**
     * 查询菜单集合
     * @return
     */
    List<SysMenuDTO> findMenuList();
}
