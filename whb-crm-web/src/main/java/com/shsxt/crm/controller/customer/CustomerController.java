package com.shsxt.crm.controller.customer;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgDataDic;
import com.shsxt.crm.service.ICustomerService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.RelationSupport;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/queryAllCustomers")
    @ResponseBody
    public List<YgCustomer> queryAllCustomer(){
        return iCustomerService.queryAllCustomer();
    }

    @GetMapping("/index.shtml")
    public String index(){
        return "customer";
    }

    /**
     * 查询客户信息
     * @param ygCustomer
     * @return
     */
    @PostMapping("/queryCustomersByParams")
    @ResponseBody
    public Map<String,Object> queryCustomersByParams(YgCustomer ygCustomer){
        return iCustomerService.queryCustomersByParams(ygCustomer);
    }

    /**
     * 查询客户等级
     */
    @PostMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<YgDataDic> queryDataDicValueByDataDicName(@RequestParam("dataDicName") String dataDicName){
        return iCustomerService.queryDataDicValueByDataDicName(dataDicName);
    }

    /**
     * 添加客户
     * @param ygCustomer
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertCustomerInfo(YgCustomer ygCustomer){
        return iCustomerService.insertCustomerInfo(ygCustomer);
    }

    /**
     * 修改客户
     * @param ygCustomer
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result updateCustomerInfo(YgCustomer ygCustomer){
        return iCustomerService.updateCustomerInfo(ygCustomer);
    }


    /**
     * 删除客户
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result deleteCustomerInfo(@RequestParam("ids") Integer[] ids){
        return iCustomerService.deleteCustomerInfo(ids);
    }

    @GetMapping("/toOtherPage/{type}/{id}")
    public ModelAndView openCustomerOtherInfo(@PathVariable("type") Integer type, @PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        if (type == 1){
            modelAndView.setViewName("customer_linkman");
            return modelAndView;
        }else if (type == 2){
            modelAndView.setViewName("customer_contact");
            return modelAndView;
        }else if(type == 3){
            YgCustomer ygCustomer = iCustomerService.findCustomerById(id);
            modelAndView.setViewName("customer_order");
            modelAndView.addObject("customer",ygCustomer);
            return modelAndView;
        }else {
            modelAndView.setViewName("500");
            return modelAndView;
        }

    }
}
