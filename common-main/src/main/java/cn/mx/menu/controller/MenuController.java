package cn.mx.menu.controller;



import cn.mx.db.entity.menu.dto.MenuDTO;
import cn.mx.db.entity.response.ResponseResult;
import cn.mx.menu.service.MenuService;
import cn.mx.security.page.BaseController;
import cn.mx.utils.constants.http.HTTPConstantsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuController extends BaseController {

    /**
     * 菜单服务
     */
    private MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 查询菜单集合
     * @return
     */
    @RequestMapping("list")
    public ResponseResult findMenuList(){
        List<MenuDTO> menuList = menuService.findMenuList();
        if (CollectionUtils.isEmpty(menuList)) {
            return ResponseResult.error(HTTPConstantsEnum.ERROR.getCode(), HTTPConstantsEnum.ERROR.getEnglishDesc());
        }
        return ResponseResult.success(HTTPConstantsEnum.SUSSES.getChineseDesc(), menuList);
    }
}
