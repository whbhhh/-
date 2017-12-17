package com.shsxt.crm.service;

import com.shsxt.crm.model.YgCustomerLoss;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public interface ICustomerLossService {
    /**
     * 查询流失客户
     * @param ygCustomerLoss
     * @return
     */
    public Map<String,Object> queryCustomerLossesByParams(YgCustomerLoss ygCustomerLoss);

    /**
     * 查询流失客户详情
     * @param lossId
     * @return
     */
    public YgCustomerLoss queryCustomerLossById(Integer lossId);
}
