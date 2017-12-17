package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.Result;
import com.shsxt.common.util.StringUtil;
import com.shsxt.crm.dao.YgSaleChanceDao;
import com.shsxt.crm.model.YgSaleChance;
import com.shsxt.crm.service.IMarketingService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MarketingServiceImpl implements IMarketingService {
    @Autowired
    private YgSaleChanceDao ygSaleChanceDao;
    @Override
    public Map<String, Object> querySaleChancesByParams(YgSaleChance ygSaleChance) {
        //分页
        PageHelper.startPage(ygSaleChance.getPage(),ygSaleChance.getRows());
        //查询list
        Map<String,Object> params = new HashMap<>();
        if (StringUtil.isNotEmpty(ygSaleChance.getCreateMan())){
            params.put("createMan",ygSaleChance.getCreateMan());
        }
        if (StringUtil.isNotEmpty(ygSaleChance.getCustomerName())){
            params.put("customerName",ygSaleChance.getCustomerName());
        }
        if (ygSaleChance.getCreateDate() != null){
            params.put("createDate",ygSaleChance.getCreateDate());
        }
        if (ygSaleChance.getState() != null){
            params.put("state",ygSaleChance.getState());
        }
        params.put("orderByStr",ygSaleChance.getUpdateDate());
        params.put("isValid",1);
        List<YgSaleChance> list = ygSaleChanceDao.find(params);
        PageInfo<YgSaleChance> info = new PageInfo<>(list);
        // 返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    /**
     * 删除记录
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public Result delMarketingChance(Integer[] ids) {
        if (ids.length <= 0){
            return Result.success("未选中记录");
        }
        //逻辑删除记录
        YgSaleChance ygSaleChance = new YgSaleChance();
        ygSaleChance.setId(ids[0]);
        ygSaleChance.setIsValid(0);
        //更新时间
        ygSaleChance.setUpdateDate(new Date(System.currentTimeMillis()));
        long ste = ygSaleChanceDao.updateSte(ygSaleChance);
        if (ste == 1){
            return Result.success("删除成功");
        }
        return Result.success("删除失败");
    }

    /**
     * 添加营销机会
     * @param ygSaleChance
     * @return
     */
    @Override
    @Transactional
    public Result insertMarketingChance(YgSaleChance ygSaleChance) {
        ygSaleChance.setUpdateDate(new Date());
        ygSaleChance.setCreateDate(new Date());
        ygSaleChance.setIsValid(1);
        ygSaleChance.setState(1);
        ygSaleChance.setAssignTime(new Date());
        ygSaleChance.setDevResult(0);
        long ste = ygSaleChanceDao.saveSte(ygSaleChance);
        if (ste == 1){
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 修改营销机会
     */
    @Override
    @Transactional
    public Result updateMarketingChance(YgSaleChance ygSaleChance) {
        ygSaleChance.setUpdateDate(new Date());
        long ste = ygSaleChanceDao.updateSte(ygSaleChance);
        if (ste == 1){
            return Result.success("修改成功");
        }
        return Result.fail("修改失败");
    }

    /**
     * 根据sid查询营销机会
     * @param sid
     * @return
     */
    @Override
    public YgSaleChance queryYgSaleChanceBySid(Integer sid) {
        return ygSaleChanceDao.get(sid);
    }


    /**
     * 修改   修改 改营销机会 开发结果
     * @param devResult
     * @param sid
     * @return
     */
    @Override
    @Transactional
    public Result updateSaleChanceDevResult(Integer devResult, Integer sid) {
        YgSaleChance ygSaleChance = new YgSaleChance();
        ygSaleChance.setDevResult(devResult);
        ygSaleChance.setId(sid);
        ygSaleChance.setUpdateDate(new Date());
        long ste = ygSaleChanceDao.updateSte(ygSaleChance);
        if (ste == 1){
            return Result.success("修改成功");
        }
        return Result.fail("修改失败");
    }
}
