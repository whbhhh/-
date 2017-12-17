package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgDataDic;

import java.util.List;
import java.util.Map;

/**
 * 客户管理服务
 */
public interface ICustomerService {

    public List<YgCustomer> queryAllCustomer();

    /**
     * 查询客户
     */
    public Map<String,Object> queryCustomersByParams(YgCustomer ygCustomer);

    /**
     * 查询客户等级
     * @return
     */
    public List<YgDataDic> queryDataDicValueByDataDicName(String dataDicName);

    /**
     * 增加客户
     * @param ygCustomer
     * @return
     */
    public Result insertCustomerInfo(YgCustomer ygCustomer);

    /**
     * 修改客户
     * @param ygCustomer
     * @return
     */
    public Result updateCustomerInfo(YgCustomer ygCustomer);

    /**
     * 删除客户
     * @param ygCustomer
     * @return
     */
    public Result deleteCustomerInfo(Integer[] ids);

    /**
     * 根据id查询客户名称
     */

    public YgCustomer findCustomerById(Integer id);
}

