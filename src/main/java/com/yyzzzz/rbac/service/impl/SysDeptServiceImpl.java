package com.yyzzzz.rbac.service.impl;

import com.yyzzzz.rbac.entity.dto.SysDeptDTO;
import com.yyzzzz.rbac.entity.mapstruct.SysDeptMapStruct;
import com.yyzzzz.rbac.common.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.common.Query;

import com.yyzzzz.rbac.dao.SysDeptDao;
import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.yyzzzz.rbac.service.SysDeptService;


@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Autowired
    private SysDeptMapStruct sysDeptMapStruct;

    @Autowired
    private SysDeptDao deptDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDeptEntity> page = this.page(
                new Query<SysDeptEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDept(SysDeptDTO deptDTO) {
        SysDeptEntity parent;
        if (checkExist(deptDTO.getParentId(), deptDTO.getName(), deptDTO.getId())) {
            throw new RuntimeException("同一层级下已存在该部门名称！");
        }
        SysDeptEntity deptEntity = sysDeptMapStruct.toEntity(deptDTO);
        String level = (parent = deptDao.selectById(deptDTO.getParentId())) == null ? null : parent.getLevel();
        deptEntity.setLevel(calculateLevel(level, deptDTO.getParentId()));
        deptDao.insert(deptEntity);
    }

    @Override
    public List<SysDeptDTO> deptTree() {
        List<SysDeptEntity> deptList = deptDao.selectList(null);
        List<SysDeptDTO> list = deptList.stream().
                filter(dept -> Constant.ROOT.equals(dept.getLevel())).
                map(sysDeptMapStruct::toDto).
                map(item -> {
                    item.setDeptList(deptListToTree(item, deptList));
                    return item;
                })
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void updateDept(SysDeptDTO deptDTO) {
        if (checkExist(deptDTO.getParentId(), deptDTO.getName(), deptDTO.getId())) {
            throw new RuntimeException("同一层级下已存在该部门名称！");
        }
        SysDeptEntity parent;
        SysDeptEntity deptEntity = sysDeptMapStruct.toEntity(deptDTO);
        String level = (parent = deptDao.selectById(deptDTO.getParentId())) == null ? null : parent.getLevel();
        deptEntity.setLevel(calculateLevel(level, deptDTO.getParentId()));
        deptDao.updateById(deptEntity);
    }

    private List<SysDeptDTO> deptListToTree(SysDeptDTO item, List<SysDeptEntity> deptList) {
        String level = calculateLevel(item.getLevel(), item.getId());
        return deptList.stream().
                filter(dept -> level.equals(dept.getLevel()))
                .map(sysDeptMapStruct::toDto)
                .map(child -> {
                    child.setDeptList(deptListToTree(child, deptList));
                    return child;
                })
                .sorted(Comparator.comparing(SysDeptDTO::getSeq))
                .collect(Collectors.toList());
    }

    private boolean checkExist(Integer parentId, String name, Integer id) {
        return false;
    }

    private String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return Constant.ROOT;
        } else {
            return StringUtils.join(parentLevel, Constant.SEPARATOR, parentId);
        }
    }

}