package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.Result;
import com.shsxt.crm.dao.YgCustomerOrderDao;
import com.shsxt.crm.dao.YgOrderDetailsDao;
import com.shsxt.crm.model.YgCustomerOrder;
import com.shsxt.crm.model.YgOrderDetails;
import com.shsxt.crm.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService {
    @Autowired
    private YgCustomerOrderDao ygCustomerOrderDao;
    @Autowired
    private YgOrderDetailsDao ygOrderDetailsDao;
    @Override
    public Map<String, Object> queryOrdersByCid(Integer cid,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<YgCustomerOrder> info = ygCustomerOrderDao.queryOrdersByCid(cid);
        PageInfo<YgCustomerOrder> pageInfo = new PageInfo<>(info);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     *  查询客户订单
     * @param orderId
     * @return
     */
    @Override
    public Result<YgCustomerOrder> queryCustoemrOrderByOrderId(Integer orderId) {
        YgCustomerOrder ygCustomerOrder = ygCustomerOrderDao.queryCustoemrOrderByOrderId(orderId);
        return Result.success("查询成功",ygCustomerOrder);
    }

    /**
     *  查询客户订单详情
     * @param orderId
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Map<String, Object> queryOrderDetailsByOrderId(Integer orderId, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<YgOrderDetails> info = ygOrderDetailsDao.queryOrderDetailsByOrderId(orderId);
        PageInfo<YgOrderDetails> pageInfo = new PageInfo<>(info);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
