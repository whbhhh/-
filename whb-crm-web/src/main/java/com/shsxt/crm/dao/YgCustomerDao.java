package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgCustomer;
import com.shsxt.framework.dao.BaseDao;

public interface YgCustomerDao extends BaseDao<Integer,YgCustomer>{
    int batchUpdate(Integer[] ids);
}