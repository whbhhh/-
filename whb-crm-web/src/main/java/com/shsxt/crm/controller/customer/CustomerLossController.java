package com.shsxt.crm.controller.customer;

import com.shsxt.crm.model.YgCustomerLoss;
import com.shsxt.crm.service.ICustomerLossService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/customer_loss")
public class CustomerLossController extends BaseController {

    @Autowired
    private ICustomerLossService iCustomerLossService;

    @GetMapping("index.shtml")
    public String index(){
        return "customer_loss";
    }

    /**
     * 查询流失客户
     * @param ygCustomerLoss
     * @return
     */
    @PostMapping("/queryCustomerLossesByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerLossesByParams(YgCustomerLoss ygCustomerLoss){
        return iCustomerLossService.queryCustomerLossesByParams(ygCustomerLoss);
    }

    @GetMapping("/{lossId}/customerRepriPage")
    public ModelAndView  customerRepriPage(@PathVariable("lossId") Integer lossId){
        ModelAndView modelAndView = new ModelAndView("customer_repri");
        YgCustomerLoss ygCustomerLoss = iCustomerLossService.queryCustomerLossById(lossId);
        modelAndView.addObject("customerLoss",ygCustomerLoss);
        return modelAndView;
    }
}
