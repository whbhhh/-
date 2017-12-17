package com.shsxt.crm.service;


import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgSaleChance;

import java.util.Map;

public interface IMarketingService {
    /**
     * 参数查询 营销机会
     * @param ygSaleChance
     * @return
     */
    public Map<String,Object> querySaleChancesByParams(YgSaleChance ygSaleChance);

    /**
     * 删除营销机会记录
     * @param ids
     * @return
     */
    public Result delMarketingChance(Integer[] ids);

    /**
     * 添加营销记录
     */
    public Result insertMarketingChance(YgSaleChance ygSaleChance);

    /**
     * 修改营销记录
     */
    public Result updateMarketingChance(YgSaleChance ygSaleChance);

    /**
     * 根据id查询营销机会
     */
    public YgSaleChance queryYgSaleChanceBySid(Integer sid);

    /**
     * 修改   修改 改营销机会 开发结果
     * @param devResult
     * @param sid
     * @return
     */
    public Result updateSaleChanceDevResult(Integer devResult,Integer sid);
}
