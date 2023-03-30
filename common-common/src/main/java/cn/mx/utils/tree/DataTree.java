package cn.mx.utils.tree;

import java.util.List;

/**
 * 树接口
 */
public interface DataTree<T> {
    Long getId();

    Long getParentId();

    String getName();

    void setChildren(List<T> childList);

    List<T> getChildren();

}
