package com.shsxt.crm.controller.customer;

import com.shsxt.common.util.Result;
import com.shsxt.crm.service.ICustomerOrderService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/customer_order")
public class CustomerOrderController extends BaseController {
    @Autowired
    private ICustomerOrderService iCustomerOrderService;

    @PostMapping("/queryOrdersByCid")
    @ResponseBody
    public Map<String,Object> queryOrdersByCid(Integer cid, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows){
        return iCustomerOrderService.queryOrdersByCid(cid,page,rows);
    }

    /**
     * 查询客户订单
     * @param orderId
     * @return
     */
    @PostMapping("/queryCustoemrOrderByOrderId")
    @ResponseBody
    public Result queryCustoemrOrderByOrderId(@RequestParam("orderId") Integer orderId){
        return iCustomerOrderService.queryCustoemrOrderByOrderId(orderId);
    }

    /**
     * 查询客户订单详情
     * @param orderId
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value =  "/queryOrderDetailsByOrderId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  queryOrderDetailsByOrderId(@RequestParam("orderId") Integer orderId,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
        return iCustomerOrderService.queryOrderDetailsByOrderId(orderId,page,rows);
    }
}
