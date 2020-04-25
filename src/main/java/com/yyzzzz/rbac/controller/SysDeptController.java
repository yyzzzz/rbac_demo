package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.yyzzzz.rbac.entity.dto.SysDeptDTO;
import com.yyzzzz.rbac.service.SysDeptService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 部门表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@RestController
@RequestMapping("rbac/sysdept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("rbac:sysdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDeptService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表树
     */
    @RequestMapping("/tree")
//    @RequiresPermissions("rbac:sysdept:list")
    public R tree(){
        List<SysDeptDTO> deptDTOS = sysDeptService.deptTree();

        return R.ok().put("tree", deptDTOS);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rbac:sysdept:info")
    public R info(@PathVariable("id") Integer id){
		SysDeptEntity sysDept = sysDeptService.getById(id);

        return R.ok().put("sysDept", sysDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("rbac:sysdept:save")
    public R save(@Valid @RequestBody SysDeptDTO deptDTO){
		sysDeptService.saveDept(deptDTO);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:sysdept:update")
    public R update(@Valid @RequestBody SysDeptDTO deptDTO){
		sysDeptService.updateDept(deptDTO);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("rbac:sysdept:delete")
    public R delete(@RequestBody Integer[] ids){
		sysDeptService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
