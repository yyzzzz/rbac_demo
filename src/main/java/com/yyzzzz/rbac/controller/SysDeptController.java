package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.yyzzzz.rbac.service.SysDeptService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public R save(@RequestBody SysDeptEntity sysDept){
		sysDeptService.save(sysDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:sysdept:update")
    public R update(@RequestBody SysDeptEntity sysDept){
		sysDeptService.updateById(sysDept);

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