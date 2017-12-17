package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shsxt.crm.model.YgCustomerOrder;

public interface YgCustomerOrderDao {

	public List<YgCustomerOrder> queryCusomterOderRecentSixMonth(@Param("cid") Integer cid);

}