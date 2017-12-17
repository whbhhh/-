package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgCustomerOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YgCustomerOrderDao{
    List<YgCustomerOrder> queryOrdersByCid(@Param("cid") Integer cid);
    YgCustomerOrder queryCustoemrOrderByOrderId(@Param("orderId") Integer orderId);
}