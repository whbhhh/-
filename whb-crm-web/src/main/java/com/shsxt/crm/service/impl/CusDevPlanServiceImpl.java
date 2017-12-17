package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.Result;
import com.shsxt.crm.dao.YgCusDevPlanDao;
import com.shsxt.crm.model.YgCusDevPlan;
import com.shsxt.crm.service.ICusDevPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CusDevPlanServiceImpl implements ICusDevPlanService {
    @Autowired
    private YgCusDevPlanDao ygCusDevPlanDao;

    /**
     * 查询开发计划
     *
     * @param ygCusDevPlan
     * @return
     */
    @Override
    public Map<String, Object> queryCusDevPlansByParams(YgCusDevPlan ygCusDevPlan) {
        PageHelper.startPage(ygCusDevPlan.getPage(), ygCusDevPlan.getRows());
        Map<String, Object> params = new HashMap<>();
        params.put("isValid", 1);
        params.put("saleChanceId", ygCusDevPlan.getSaleChanceId());
        List<YgCusDevPlan> info = ygCusDevPlanDao.find(params);
        PageInfo<YgCusDevPlan> pageInfo = new PageInfo<>(info);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    /**
     * 增加开发计划
     *
     * @param ygCusDevPlan
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Result insertCusDevPlans(YgCusDevPlan ygCusDevPlan) {
        ygCusDevPlan.setCreateDate(new Date());
        ygCusDevPlan.setUpdateDate(new Date());
        ygCusDevPlan.setIsValid(1);
        long ste = ygCusDevPlanDao.saveSte(ygCusDevPlan);
        if (ste == 1) {
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 删除开发计划
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Result delCusDevPlans(Integer id) {
        YgCusDevPlan ygCusDevPlan = new YgCusDevPlan();
        ygCusDevPlan.setId(id);
        ygCusDevPlan.setIsValid(0);
        ygCusDevPlan.setUpdateDate(new Date());
        long str = ygCusDevPlanDao.updateSte(ygCusDevPlan);
        if (str == 1) {
            return Result.success("删除成功");
        }
        return Result.fail("删除失败");
    }
}
