package cn.mx.db.entity.menu.dto;


import cn.mx.utils.tree.DataTree;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MenuDTO  implements DataTree<MenuDTO>, Serializable {

    private Long id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;
    /**
     * 权限标识
     */
    private String perms;

    /**
     * 父级编号
     */
    private Long parentId;

    /**
     * 菜单图标
     */
    private String icon;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    /**
     * 是否删除（0未删除 1已删除）
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String remark;

    private List<MenuDTO> children;
}