package cn.mx.menu.service.impl;


import cn.mx.constants.Constants;
import cn.mx.db.entity.menu.Menu;
import cn.mx.db.entity.menu.dto.MenuDTO;
import cn.mx.mapper.menu.MenuMapper;
import cn.mx.menu.service.MenuService;
import cn.mx.utils.bean.BeanUtils;
import cn.mx.utils.tree.TreeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    /**
     * 菜单服务
     */
    private MenuMapper menuMapper;

    @Autowired
    public void setMenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    /**
     * 查询菜单集合
     *
     * @return
     */
    @Override
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuMapper.selectList(null);
        if (CollectionUtils.isEmpty(menuList)){
            return null;
        }
        List<MenuDTO> menuDTOList = BeanUtils.copyObjects(menuList, Menu.class, MenuDTO.class);
        //返回树型结构
        return TreeUtils.getTreeList(Constants.Number.ZERO, menuDTOList);
    }
}
