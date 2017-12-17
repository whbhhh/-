package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgRole;

import java.util.List;
import java.util.Map;

public interface ISystemRoleService {
    /**
     * 查询所有角色
     * @return
     */
    public List<YgRole> queryAllRoles(String roleName);

    public Map<String,Object> queryAllRolesByParams(Integer page,Integer rows,String roleName);

    public Result insertSysRole(YgRole ygRole);

    public Result updateSysRole(YgRole ygRole);
    public Result deleteSysRole(Integer[] ids);
    public Result addPermission(Integer rid,Integer[] moduleIds);
}
