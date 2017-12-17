package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.Md5Util;
import com.shsxt.common.util.Result;
import com.shsxt.crm.dao.YgUserDao;
import com.shsxt.crm.dao.YgUserRoleDao;
import com.shsxt.crm.model.YgUser;
import com.shsxt.crm.model.YgUserRole;
import com.shsxt.crm.service.ISystemUserService;
import com.shsxt.crm.service.IUserService;
import com.shsxt.framework.exception.YgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private YgUserDao ygUserDao;
    @Autowired
    private YgUserRoleDao ygUserRoleDao;
    /**
     * 查询系统用户
     * @param ygUser
     * @return
     */
    @Override
    public Map<String, Object> queryUsersByParams(YgUser ygUser) {
        PageInfo<YgUser> info = iUserService.querySysUser(ygUser);
        Map<String,Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    /**
     * 增加系统用户
     * @param ygUser
     * @return
     */
    @Override
    @Transactional
    public Result insertSystemUser(YgUser ygUser) {
        Map<String,Object> params = new HashMap<>();
        params.put("isValid",1);
        params.put("userName",ygUser.getUserName());
        YgUser ygUser1 = ygUserDao.findOne(params);
        if (ygUser1 != null){
            throw new YgException("500","该用户已存在");
        }
        ygUser.setCreateDate(new Date());
        ygUser.setUpdateDate(new Date());
        ygUser.setUserPwd(Md5Util.encode(ygUser.getUserPwd()));
        long s = ygUserDao.saveSte(ygUser);
        if (s != 1){
            throw new YgException("500","添加用户失败");
        }
        ygUser1 = ygUserDao.findOne(params);
        YgUserRole ygUserRole = new YgUserRole();
        ygUserRole.setUserId(ygUser1.getId());
        ygUserRole.setRoleId(ygUser.getRoleIds());
        ygUserRole.setUpdateDate(new Date());
        ygUserRole.setCreateDate(new Date());
        long ste = ygUserRoleDao.saveSte(ygUserRole);
        if (ste != 1){
            throw new YgException("500","添加角色绑定失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 删除系统用户
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public Result delSystemUser(Integer[] ids) {
        for (Integer id : ids) {
            YgUser ygUser = new YgUser();
            ygUser.setId(id);
            ygUser.setIsValid(0);
            long s = ygUserDao.updateSte(ygUser);
            int i = ygUserRoleDao.delUserRoleByUid(id);
            if (s != 1 || i != 1){
                throw new YgException("500","删除失败");
            }
        }
        return Result.success("删除成功");
    }
}
