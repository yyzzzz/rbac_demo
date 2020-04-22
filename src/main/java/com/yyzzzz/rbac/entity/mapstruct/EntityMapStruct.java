package com.yyzzzz.rbac.entity.mapstruct;

import java.util.List;

/**
 * @author yyzzzz
 * @Date 2020/4/22 21:56
 */
public interface EntityMapStruct <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
