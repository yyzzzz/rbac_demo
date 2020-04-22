package com.yyzzzz.rbac.entity.mapstruct;

import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.yyzzzz.rbac.entity.dto.SysDeptDTO;
import org.mapstruct.Mapper;

/**
 * @author yyzzzz
 * @Date 2020/4/22 21:57
 */
@Mapper(componentModel = "spring")
public interface SysDeptMapStruct extends EntityMapStruct<SysDeptDTO, SysDeptEntity>{

//    @Mapping(source = "xxx", target = "xxx")
    SysDeptDTO toDto(SysDeptEntity sysDeptEntity);

    SysDeptEntity toEntity(SysDeptDTO sysDeptDTO);

    default SysDeptEntity fromId(Integer id) {
        if (id == null) {
            return null;
        }
        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        sysDeptEntity.setId(id);
        return sysDeptEntity;
    }
}
