package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.common.util.JsonUtil;
import com.shsxt.common.util.Result;
import com.shsxt.common.util.StringUtil;
import com.shsxt.common.util.VerificationLoginUtil;
import com.shsxt.crm.dao.YgCustomerServeDao;
import com.shsxt.crm.dao.YgDataDicDao;
import com.shsxt.crm.model.YgCustomerServe;
import com.shsxt.crm.model.YgDataDic;
import com.shsxt.crm.model.YgUser;
import com.shsxt.crm.service.IServerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServerManagerServiceImpl implements IServerManagerService{
    @Autowired
    private YgDataDicDao ygDataDicDao;
    @Autowired
    private YgCustomerServeDao ygCustomerServeDao;
    @Autowired
    private HttpServletRequest request;
    /**
     * 查询服务类别
     * @param dataDicName
     * @return
     */
    @Override
    public List<YgDataDic> queryDataDicValueByDataDicName(String dataDicName) {
        if (StringUtil.isNotEmpty(dataDicName)) {
            return ygDataDicDao.queryDataDicValueByDataDicName(dataDicName);
        }
        return null;
    }

    /**
     * 添加服务管理
     * @param ygCustomerServe
     * @return
     */
    @Override
    @Transactional
    public Result insertYgCustomerServer(YgCustomerServe ygCustomerServe) {
        ygCustomerServe.setState("1");
        ygCustomerServe.setCreateDate(new Date());
        ygCustomerServe.setUpdateDate(new Date());
        ygCustomerServe.setIsValid(1);
        String json = VerificationLoginUtil.checkLoginUser(request);
        YgUser ygUser = JsonUtil.parseJsonWithGson(json,YgUser.class);
        ygCustomerServe.setCreatePeople(ygUser.getUserName());
        long i =  ygCustomerServeDao.saveSte(ygCustomerServe);
        if (i == 1){
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    @Override
    public Map<String, Object> queryCustomerServesByParams(Integer page,Integer rows,Integer state) {
        PageHelper.startPage(page,rows);
        Map<String,Object> params = new HashMap<>();
        params.put("state",state);
        params.put("isValid",1);
        List<YgCustomerServe> list = ygCustomerServeDao.find(params);
        PageInfo<YgCustomerServe> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @Override
    @Transactional
    public Result addCustomerServeAssign(YgCustomerServe ygCustomerServe) {
        if (ygCustomerServe.getState().equals("2")){
            ygCustomerServe.setAssignTime(new Date());
        }
        if (ygCustomerServe.getState().equals("3")){
            ygCustomerServe.setServiceProceTime(new Date());
        }
        ygCustomerServe.setUpdateDate(new Date());
        long i = ygCustomerServeDao.updateSte(ygCustomerServe);
        if (i == 1){
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");
    }

}
