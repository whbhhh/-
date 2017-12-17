package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgUserRole;
import com.shsxt.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

public interface YgUserRoleDao extends BaseDao<Integer,YgUserRole>{
    public int delUserRoleByUid(@Param("uid") Integer id);
}