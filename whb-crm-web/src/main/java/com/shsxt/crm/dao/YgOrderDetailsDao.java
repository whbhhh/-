package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgOrderDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YgOrderDetailsDao {
    public List<YgOrderDetails> queryOrderDetailsByOrderId(@Param("orderId") Integer orderId);
}