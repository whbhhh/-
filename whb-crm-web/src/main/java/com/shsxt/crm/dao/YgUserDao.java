package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgUser;
import com.shsxt.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YgUserDao extends BaseDao<Integer,YgUser>{
    /**
     * 查询用户经理
     * @return
     */
    public List<YgUser> queryAllCustomerManager();

    public String queryRoleName(@Param("id") Integer id);

    public List<YgUser> findAll(Map<String, Object> param);
}