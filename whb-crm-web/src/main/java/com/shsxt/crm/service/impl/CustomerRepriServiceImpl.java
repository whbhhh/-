package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.YgCusReprieveDao;
import com.shsxt.crm.model.YgCusReprieve;
import com.shsxt.crm.service.ICustomerRepriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerRepriServiceImpl implements ICustomerRepriService {
    @Autowired
    private YgCusReprieveDao ygCusReprieveDao;

    @Override
    public Map<String, Object> customerReprievesByLossId(Integer page,Integer rows,Integer lossId) {
        PageHelper.startPage(page,rows);
        Map<String,Object> params = new HashMap<>();
        params.put("lossId",lossId);
        List<YgCusReprieve> info = ygCusReprieveDao.find(params);
        PageInfo<YgCusReprieve> pageInfo = new PageInfo<>(info);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
