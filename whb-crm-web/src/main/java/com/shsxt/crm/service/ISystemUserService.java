package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgUser;

import java.util.Map;

public interface ISystemUserService {
    /**
     * 查询系统用户
     * @param ygUser
     * @return
     */
    public Map<String,Object> queryUsersByParams(YgUser ygUser);

    /**
     * 增加系统用户
     */
    public Result insertSystemUser(YgUser ygUser);

    /**
     * 删除系统用户
     * @param ids
     * @return
     */
    public Result delSystemUser(Integer[] ids);
}
