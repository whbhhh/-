package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.*;
import com.shsxt.crm.dao.YgUserDao;
import com.shsxt.crm.dao.YgUserPermissionDao;
import com.shsxt.crm.dao.YgUserRoleDao;
import com.shsxt.crm.model.YgUser;
import com.shsxt.crm.model.YgUserPermission;
import com.shsxt.crm.model.YgUserRole;
import com.shsxt.crm.service.IUserService;
import com.shsxt.framework.constant.CrmConstant;
import com.shsxt.framework.constant.ExceptionConstant;
import com.shsxt.framework.exception.YgException;
import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private YgUserDao userDao;
    @Autowired(required = false)
    private HttpSession session;
    @Autowired(required = false)
    private HttpServletResponse response;
    @Autowired
    private YgUserPermissionDao ygUserPermissionDao;
    @Autowired
    private YgUserRoleDao ygUserRoleDao;
    @Override
    public Result userLogin(String userName, String userPwd) {
        if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(userPwd)){
            throw new YgException(ExceptionConstant.CODEEXU001,ExceptionConstant.EXU001);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        YgUser user = userDao.findOne(params);
        if (null != user && Md5Util.encode(userPwd).equals(user.getUserPwd())){
            VerificationLoginUtil.ULoginTools(response,session, JsonUtil.parseObjectToString(user));
            queryUserPermission(user.getId());
            return Result.success("登录成功");
        }
        return Result.fail("登录失败");

    }

    /**
     * 查询用户经理
     * @return
     */

    @Override
    public List<YgUser> queryAllCustomerManager() {
        return userDao.queryAllCustomerManager();
    }

    /**
     * 查询系统用户
     * @param ygUser
     * @return
     */
    @Override
    public PageInfo<YgUser> querySysUser(YgUser ygUser) {
        PageHelper.startPage(ygUser.getPage(),ygUser.getRows());
        Map<String,Object> params = new HashMap<>();
        if (StringUtil.isNotEmpty(ygUser.getUserName())){
            params.put("userName",ygUser.getUserName());
        }
        if (StringUtil.isNotEmpty(ygUser.getTrueName())){
            params.put("trueName",ygUser.getTrueName());
        }
        if (StringUtil.isNotEmpty(ygUser.getPhone())){
            params.put("phone",ygUser.getPhone());
        }
        if (StringUtil.isNotEmpty(ygUser.getEmail())){
            params.put("email", ygUser.getEmail());
        }
        params.put("isValid",1);
        List<YgUser> list = userDao.findAll(params);
        List<YgUser> list1 = new ArrayList<>();
        for (YgUser user : list) {
            user.setRoleName(userDao.queryRoleName(user.getId()));
            list1.add(user);
        }
        PageInfo<YgUser> info = new PageInfo<>(list1);
        return info;
    }

    /**
     * 查询用户权限
     */
    public void queryUserPermission(Integer uid){
        Map<String,Object> params= new HashMap<>();
        params.put("userId",uid);
        //获取用户角色
        YgUserRole ygUserRole = ygUserRoleDao.findOne(params);
        //查询权限
        Map<String,Object> paramsPermission = new HashMap<>();
        paramsPermission.put("roleId",ygUserRole.getRoleId());
        List<YgUserPermission> permissions = ygUserPermissionDao.find(paramsPermission);
        //取出用户权限值
        Iterator<YgUserPermission> iterator = permissions.iterator();
        List<String> permissionList = new ArrayList<>();
        while (iterator.hasNext()){
            YgUserPermission ygUserPermission = iterator.next();
            permissionList.add(ygUserPermission.getAclValue());
        }
        session.setAttribute(CrmConstant.USER_PERMISSIONS,permissionList);
    }
}
