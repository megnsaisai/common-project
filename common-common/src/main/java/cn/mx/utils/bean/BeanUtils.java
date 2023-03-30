package cn.mx.utils.bean;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author SSS
 * @create 2023/3/9
 */

public class BeanUtils {
    /**
     * 单个对象属性拷贝
     *
     * @param source 源对象
     * @param clazz  目标对象Class
     * @return 目标对象
     */
    public static <M, T> T copyProperties(M source, Class<T> clazz) {
        if (Objects.isNull(source) || Objects.isNull(clazz)) {
            throw new IllegalArgumentException();
        }
        return copyProperties(source, clazz, null);
    }

    /**
     * 单个对象属性拷贝
     *
     * @param source      源对象
     * @param targetClazz 目标对象Class
     * @param copier      copier
     * @return 目标对象
     */
    private static <M, T> T copyProperties(M source, Class<T> targetClazz, BeanCopier copier) {
        if (null == copier) {
            copier = BeanCopier.create(source.getClass(), targetClazz, false);
        }
        T t = null;
        try {
            t = targetClazz.getDeclaredConstructor().newInstance();
            copier.copy(source, t, null);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 列表对象拷贝
     *
     * @param sources      源列表
     * @param sourcesClazz 源对象class
     * @param targetClazz  目标对象class
     * @return 目标列表
     */
    public static <M, S, T> List<T> copyObjects(List<M> sources, Class<S> sourcesClazz, Class<T> targetClazz) {
        if (Objects.isNull(sourcesClazz) || Objects.isNull(targetClazz)) {
            throw new IllegalArgumentException();
        }
        BeanCopier copier = BeanCopier.create(sourcesClazz, targetClazz, false);
        return Optional.of(sources)
                .orElse(new ArrayList<>())
                .stream().map(m -> copyProperties(m, targetClazz, copier))
                .collect(Collectors.toList());
    }

    /**
     * 分页对象拷贝
     *
     * @param sources      源列表
     * @param sourcesClazz 源列表对象Class
     * @param targetClazz  源列表对象Class
     * @return 目标分页
     */
    public static <M, S, T> Page<T> copyObjects(Page<M> sources, Class<S> sourcesClazz, Class<T> targetClazz, Pageable pageable) {
        if (Objects.isNull(sourcesClazz) || Objects.isNull(targetClazz)) {
            throw new IllegalArgumentException();
        }
        return new PageImpl<>(copyObjects(sources.getContent(), sourcesClazz, targetClazz), pageable, sources.getTotalElements());
    }
}
