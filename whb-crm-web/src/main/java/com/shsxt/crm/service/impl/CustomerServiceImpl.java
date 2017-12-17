package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.MathUtil;
import com.shsxt.common.util.Result;
import com.shsxt.common.util.StringUtil;
import com.shsxt.crm.dao.YgCustomerDao;
import com.shsxt.crm.dao.YgDataDicDao;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgDataDic;
import com.shsxt.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private YgCustomerDao ygCustomerDao;
    @Autowired
    private YgDataDicDao ygDataDicDao;
    @Override
    public List<YgCustomer> queryAllCustomer() {
        Map<String,Object> map = new HashMap<>();
        map.put("isValid",1);
        List<YgCustomer> list = ygCustomerDao.find(map);
        return list;
    }

    /**
     * 查询客户
     * @param ygCustomer
     * @return
     */
    @Override
    public Map<String,Object> queryCustomersByParams(YgCustomer ygCustomer) {
        PageHelper.startPage(ygCustomer.getPage(),ygCustomer.getRows());
        Map<String,Object> params = new HashMap<>();
        if (StringUtil.isNotEmpty(ygCustomer.getKhno())){
            params.put("khno",ygCustomer.getKhno());
        }
        if (StringUtil.isNotEmpty(ygCustomer.getName())){
            params.put("name",ygCustomer.getName());
        }
        params.put("isValid",1);
        List<YgCustomer> info = ygCustomerDao.find(params);
        PageInfo<YgCustomer> pageInfo = new PageInfo<>(info);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 查询客户等级
     * @return
     */
    @Override
    public List<YgDataDic> queryDataDicValueByDataDicName(String dataDicName) {
        Map<String,Object> params = new HashMap<>();
        params.put("dataDicName",dataDicName);
        return ygDataDicDao.find(params);
    }

    /**
     * 添加客户
     * @param ygCustomer
     * @return
     */
    @Override
    @Transactional
    public Result insertCustomerInfo(YgCustomer ygCustomer) {
        ygCustomer.setCreateDate(new Date());
        ygCustomer.setUpdateDate(new Date());
        ygCustomer.setIsValid(1);
        ygCustomer.setState(0);
        ygCustomer.setKhno(MathUtil.genereateKhCode());
        long str = ygCustomerDao.saveSte(ygCustomer);
        if (str == 1){
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 修改客户
     * @param ygCustomer
     * @return
     */
    @Override
    @Transactional
    public Result updateCustomerInfo(YgCustomer ygCustomer) {
        ygCustomer.setUpdateDate(new Date());
        long ste = ygCustomerDao.updateSte(ygCustomer);
        if (ste == 1){
            return Result.success("修改成功");
        }
        return Result.fail("修改失败");
    }

    /**
     * 删除客户
     * @param ygCustomer
     * @return
     */
    @Override
    @Transactional
    public Result deleteCustomerInfo(Integer[] ids) {
        int s = ygCustomerDao.batchUpdate(ids);
        return Result.success("删除成功");
    }

    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    @Override
    public YgCustomer findCustomerById(Integer id) {
        return ygCustomerDao.get(id);
    }


}
