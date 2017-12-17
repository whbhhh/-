package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCustomerServe;
import com.shsxt.crm.model.YgDataDic;

import java.util.List;
import java.util.Map;

public interface IServerManagerService {
    /**
     * 查询客户服务类型
     * @param dataDicName
     * @return
     */
    public List<YgDataDic> queryDataDicValueByDataDicName(String dataDicName);

    /**
     * 添加客户管理
     * @param ygCustomerServe
     * @return
     */
    public Result insertYgCustomerServer(YgCustomerServe ygCustomerServe);

    public Map<String,Object> queryCustomerServesByParams(Integer page,Integer rows,Integer state);


    public Result addCustomerServeAssign(YgCustomerServe ygCustomerServe);

}
