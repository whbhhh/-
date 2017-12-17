package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgRole;
import com.shsxt.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

public interface YgRoleDao extends BaseDao<Integer,YgRole>{
    public int delUserRoleByRid(@Param("rid") Integer rid);
}