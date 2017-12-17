package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ICustomerOrderService {
    /**
     * 查询客户订单
     * @param cid
     * @param page
     * @param rows
     * @return
     */
    public Map<String,Object> queryOrdersByCid(Integer cid,Integer page,Integer rows);

    /**
     * 查询客户订单
     * @param orderId
     * @return
     */
    public Result queryCustoemrOrderByOrderId(Integer orderId);

    /**
     * 查询客户订单详情
     * @param orderId
     * @param page
     * @param rows
     * @return
     */

    public Map<String,Object>  queryOrderDetailsByOrderId(Integer orderId,Integer page,Integer rows);
}
