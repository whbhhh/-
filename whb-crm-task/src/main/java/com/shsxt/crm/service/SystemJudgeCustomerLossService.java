package com.shsxt.crm.service;

import com.shsxt.crm.dao.YgCustomerDao;
import com.shsxt.crm.dao.YgCustomerLossDao;
import com.shsxt.crm.dao.YgCustomerOrderDao;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgCustomerLoss;
import com.shsxt.crm.model.YgCustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class SystemJudgeCustomerLossService {
    private static final String SYSTEM_JUDGE_CUSTOMERLOSS_REASON="六个月 他都没下单";
    @Autowired
    private YgCustomerDao ygCustomerDao;
    @Autowired
    private YgCustomerLossDao ygCustomerLossDao;
    @Autowired
    private YgCustomerOrderDao ygCustomerOrderDao;
    @Transactional
    public void systemJudgeCustomerLoss(){
        //获取6个月前注册账户
        List<YgCustomer> beforeSixMonthCustomer = ygCustomerDao.queryCustomerBeforeSixMonth();
        if (beforeSixMonthCustomer != null || beforeSixMonthCustomer.size() >0){
            Iterator<YgCustomer> iterator = beforeSixMonthCustomer.iterator();
            while (iterator.hasNext()){
                //获取客户
                YgCustomer ygCustomer = iterator.next();
                //查询客户最近6个月的订单
                List<YgCustomerOrder> list = ygCustomerOrderDao.queryCusomterOderRecentSixMonth(ygCustomer.getId());
                boolean flag = isConformCustomerLoss(list);
                if (flag){
                    YgCustomerLoss ygCustomerLoss = new YgCustomerLoss();
                    ygCustomerLoss.setCusNo(ygCustomer.getKhno());
                    ygCustomerLoss.setCusName(ygCustomer.getName());
                    ygCustomerLoss.setCusManager(ygCustomer.getCusManager());
                    ygCustomerLoss.setState(1);
                    ygCustomerLoss.setIsValid(1);
                    ygCustomerLoss.setLossReason(SYSTEM_JUDGE_CUSTOMERLOSS_REASON);
                    ygCustomerLoss.setCreateDate(new Date());
                    ygCustomer.setUpdateDate(new Date());
                    ygCustomerLossDao.saveSte(ygCustomerLoss);
                }
            }
        }
    }

    /**
     * 判断是否符合流失客户
     */
    public boolean isConformCustomerLoss(List<YgCustomerOrder> list){
        if (list == null || list.size() <= 0){
            return true;
        }
        return false;
    }

}
