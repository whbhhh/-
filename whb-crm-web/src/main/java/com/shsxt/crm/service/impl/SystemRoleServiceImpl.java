package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.shsxt.common.util.Result;
import com.shsxt.crm.dao.YgRoleDao;
import com.shsxt.crm.dao.YgUserPermissionDao;
import com.shsxt.crm.model.YgRole;
import com.shsxt.crm.model.YgSystemMenuModel;
import com.shsxt.crm.model.YgUserPermission;
import com.shsxt.crm.service.ISystemModuleService;
import com.shsxt.crm.service.ISystemRoleService;
import com.shsxt.framework.exception.YgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemRoleServiceImpl implements ISystemRoleService {
    @Autowired
    private YgRoleDao ygRoleDao;
    @Autowired
    private ISystemModuleService iSystemModuleService;
    @Autowired
    private YgUserPermissionDao ygUserPermissionDao;
    /**
     * 查询所有角色
     *
     * @return
     */
    @Override
    public List<YgRole> queryAllRoles(String roleName) {
        Map<String, Object> params = new HashMap();
        if (StringUtil.isNotEmpty(roleName)) {
            params.put("roleName", roleName);
        }
        params.put("isValid", 1);
        List<YgRole> list = ygRoleDao.find(params);
        return list;
    }

    @Override
    public Map<String, Object> queryAllRolesByParams(Integer page, Integer rows, String roleName) {
        PageHelper.startPage(page, rows);
        List<YgRole> ygRoles = queryAllRoles(roleName);
        PageInfo<YgRole> pageInfo = new PageInfo<>(ygRoles);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    @Transactional
    public Result insertSysRole(YgRole ygRole) {
        ygRole.setIsValid(1);
        ygRole.setCreateDate(new Date());
        ygRole.setUpdateDate(new Date());
        long s = ygRoleDao.saveSte(ygRole);
        if (s == 1) {
            return Result.success("添加角色成功");
        }
        return Result.fail("添加角色失败");
    }

    @Override
    @Transactional
    public Result updateSysRole(YgRole ygRole) {
        ygRole.setUpdateDate(new Date());
        long s = ygRoleDao.updateSte(ygRole);
        if (s == 1) {
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");
    }

    @Override
    @Transactional
    public Result deleteSysRole(Integer[] ids) {
        for (Integer id : ids) {
            YgRole ygRole = new YgRole();
            ygRole.setId(id);
            ygRole.setIsValid(0);
            ygRole.setUpdateDate(new Date());
            long i = ygRoleDao.updateSte(ygRole);
            if (i != 1) {
                throw new YgException("500", "删除失败");
            }
        }
        return Result.success("删除成功");

    }

    /**
     * 角色授权
     *
     * @param rid
     * @param moduleIds
     * @return
     */
    @Override
    @Transactional
    public Result addPermission(Integer rid, Integer[] moduleIds) {
        if (rid == null) {
            throw new YgException("500", "角色ID不能为空");
        }
        ygRoleDao.delUserRoleByRid(rid);
        for (Integer moduleId : moduleIds) {
            YgSystemMenuModel ygSystemMenuModel = iSystemModuleService.queryMenuModelByMid(moduleId);
            YgUserPermission ygUserPermission = new YgUserPermission();
            ygUserPermission.setRoleId(rid);
            ygUserPermission.setModuleId(moduleId);
            ygUserPermission.setAclValue(ygSystemMenuModel.getOptValue());
            ygUserPermission.setUpdateDate(new Date());
            ygUserPermission.setCreateDate(new Date());
            //授权
            ygUserPermissionDao.save(ygUserPermission);
        }
        return Result.success("授权成功");
    }
}
