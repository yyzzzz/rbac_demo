package com.yyzzzz.rbac.service.impl;

import com.yyzzzz.rbac.entity.dto.SysDeptDTO;
import com.yyzzzz.rbac.entity.mapstruct.SysDeptMapStruct;
import com.yyzzzz.rbac.utils.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.utils.Query;

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
                new QueryWrapper<SysDeptEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDept(SysDeptDTO deptDTO) {
        SysDeptEntity parent;
        if(checkExist(deptDTO.getParentId(), deptDTO.getName(), deptDTO.getId())){
            throw new RuntimeException("同一层级下已存在该部门名称！");
        }
        SysDeptEntity deptEntity = sysDeptMapStruct.toEntity(deptDTO);
        String level = (parent = deptDao.selectById(deptDTO.getParentId())) == null ? null : parent.getLevel();
        deptEntity.setLevel(calculateLevel(level, deptDTO.getParentId()));
        save(deptEntity);
    }

    private boolean checkExist(Integer parentId, String name, Integer id) {
        return false;
    }

    private String calculateLevel(String parentLevel, int parentId){
        if(StringUtils.isBlank(parentLevel)){
            return Constant.ROOT;
        } else {
            return StringUtils.join(parentLevel, Constant.SEPARATOR, parentId);
        }
    }

}