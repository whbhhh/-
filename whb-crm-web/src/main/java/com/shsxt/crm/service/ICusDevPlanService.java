package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCusDevPlan;

import java.util.Map;

public interface ICusDevPlanService {
    /**
     * 查询开发计划
     * @param ygCusDevPlan
     * @return
     */
    public Map<String,Object> queryCusDevPlansByParams(YgCusDevPlan ygCusDevPlan);

    /**
     * 增加开发计划
     */
    public Result insertCusDevPlans(YgCusDevPlan ygCusDevPlan);

    /**
     * 删除开发计划
     * @param id
     * @return
     */
    public Result delCusDevPlans(Integer id);
}
