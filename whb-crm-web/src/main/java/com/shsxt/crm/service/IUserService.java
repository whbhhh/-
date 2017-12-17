package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    public Result userLogin(String userName, String userPwd);

    /**
     * 查询经理
     */

    public List<YgUser> queryAllCustomerManager();

    /**
     * 查询系统用户
     */

    public PageInfo<YgUser> querySysUser(YgUser ygUser);



}
