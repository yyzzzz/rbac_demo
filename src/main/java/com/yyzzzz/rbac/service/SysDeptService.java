package com.yyzzzz.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.yyzzzz.rbac.entity.dto.SysDeptDTO;
import com.yyzzzz.rbac.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 部门表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDept(SysDeptDTO deptDTO);

    List<SysDeptDTO> deptTree();

    void updateDept(SysDeptDTO deptDTO);
}

