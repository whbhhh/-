package com.shsxt.crm.controller.marketing;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgSaleChance;
import com.shsxt.crm.service.IMarketingService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 营销管理
 */
@Controller
@RequestMapping("/marketing")
public class MarketingController extends BaseController {
    @Autowired
    private IMarketingService iMarketingService;

    /**
     * 营销机会管理 客户开发计划 页面的跳转
     * @param state
     * @return
     */
    @RequestMapping("/{state}/index.shtml")
    public String index(@PathVariable("state") Integer state){
        if (state == 1){
            return "sale_chance";
        }else if (state == 2){
            return "cus_dev_plan";
        }else {
            return "500";
        }
    }
    /**
     *  查询 营销机会
     * @param ygSaleChance 提供  全部查询   创建人 客户名称 创建时间 分配状态  参数查询
     * @return
     */
    @PostMapping("/querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> querySaleChancesByParams(YgSaleChance ygSaleChance) {
        return iMarketingService.querySaleChancesByParams(ygSaleChance);
    }

    /**
     * 删除记录
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delMarketingChance(Integer[] ids){
        return iMarketingService.delMarketingChance(ids);
    }

    /**
     * 添加记录
     * @param ygSaleChance
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertMarketingChance(YgSaleChance ygSaleChance){
        return iMarketingService.insertMarketingChance(ygSaleChance);
    }

    /**
     * 修改记录
     * @param ygSaleChance
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result updateMarketingChance(YgSaleChance ygSaleChance){
        return iMarketingService.updateMarketingChance(ygSaleChance);
    }

    /**
     * 修改   修改 改营销机会 开发结果
     * @param devResult
     * @param sid
     * @return
     */
    @PostMapping("/updateSaleChanceDevResult")
    @ResponseBody
    public Result updateSaleChanceDevResult(@RequestParam("devResult") Integer devResult,@RequestParam("sid") Integer sid){
        return  iMarketingService.updateSaleChanceDevResult(devResult,sid);
    }
}
