package cn.mx.menu.service.impl;


import cn.mx.constants.Constants;
import cn.mx.db.entity.sysmenu.SysMenu;
import cn.mx.db.entity.sysmenu.dto.SysMenuDTO;
import cn.mx.mapper.sysmenu.SysMenuMapper;
import cn.mx.menu.service.MenuService;
import cn.mx.utils.bean.BeanUtils;
import cn.mx.utils.tree.TreeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements MenuService {

    /**
     * 菜单服务
     */
    private SysMenuMapper sysMenuMapper;

    @Autowired
    public void setMenuMapper(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }


    /**
     * 查询菜单集合
     *
     * @return
     */
    @Override
    public List<SysMenuDTO> findMenuList() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(null);
        if (CollectionUtils.isEmpty(sysMenuList)){
            return null;
        }
        List<SysMenuDTO> sysMenuDTOList = BeanUtils.copyObjects(sysMenuList, SysMenu.class, SysMenuDTO.class);
        //返回树型结构
        return TreeUtils.getTreeList(Constants.Number.ZERO, sysMenuDTOList);
    }
}
