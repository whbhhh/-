package com.shsxt.crm.controller.customer;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCusDevPlan;
import com.shsxt.crm.model.YgSaleChance;
import com.shsxt.crm.service.ICusDevPlanService;
import com.shsxt.crm.service.IMarketingService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/cus_dev_plan")
public class CusDevPlanController extends BaseController {
    @Autowired
    private IMarketingService iMarketingService;
    @Autowired
    private ICusDevPlanService iCusDevPlanService;
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam("sid") Integer sid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cus_dev_plan_detail");
        //根据id查询营销机会
        YgSaleChance ygSaleChance = iMarketingService.queryYgSaleChanceBySid(sid);
        modelAndView.addObject("saleChance",ygSaleChance);
        return modelAndView;
    }

    /**
     * 查看开发计划
     * @param ygCusDevPlan
     * @return
     */
    @PostMapping("/queryCusDevPlansByParams")
    @ResponseBody
    public Map<String,Object> queryCusDevPlansByParams(YgCusDevPlan ygCusDevPlan){
        return iCusDevPlanService.queryCusDevPlansByParams(ygCusDevPlan);
    }

    /**
     * 增加计划
     * @param ygCusDevPlan
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertCusDevPlans(YgCusDevPlan ygCusDevPlan){
        return iCusDevPlanService.insertCusDevPlans(ygCusDevPlan);
    }

    /**
     * 删除计划
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delCusDevPlans(Integer id){
        return iCusDevPlanService.delCusDevPlans(id);
    }
}
