package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.StringUtil;
import com.shsxt.crm.dao.YgCustomerLossDao;
import com.shsxt.crm.model.YgCustomerLoss;
import com.shsxt.crm.service.ICustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerLossServiceImpl implements ICustomerLossService {

    @Autowired
    private YgCustomerLossDao ygCustomerLossDao;
    /**
     * 查询流失客户
     * @param ygCustomerLoss
     * @return
     */
    @Override
    public Map<String, Object> queryCustomerLossesByParams(YgCustomerLoss ygCustomerLoss) {
        Map<String,Object> params = new HashMap<>();
        if (StringUtil.isNotEmpty(ygCustomerLoss.getCusName())){
            params.put("cusName",ygCustomerLoss.getCusName());
        }
        if (StringUtil.isNotEmpty(ygCustomerLoss.getCusNo())){
            params.put("cusNo",ygCustomerLoss.getCusNo());
        }
        if (StringUtil.isNotEmpty(ygCustomerLoss.getCusManager())){
            params.put("cusMamager",ygCustomerLoss.getCusManager());
        }
        if (null != ygCustomerLoss.getCreateDate()){
            params.put("createDate",ygCustomerLoss.getCreateDate());
        }
        params.put("isValid",1);
        List<YgCustomerLoss> info = ygCustomerLossDao.find(params);
        PageInfo<YgCustomerLoss> pageInfo = new PageInfo<>(info);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 查询流失客户详情
     * @param lossId
     * @return
     */
    @Override
    public YgCustomerLoss queryCustomerLossById(Integer lossId) {
        return ygCustomerLossDao.get(lossId);
    }
}
