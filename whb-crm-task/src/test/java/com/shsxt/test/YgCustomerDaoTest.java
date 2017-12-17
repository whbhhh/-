package com.shsxt.test;

import com.shsxt.crm.dao.YgCustomerDao;
import com.shsxt.crm.dao.YgCustomerOrderDao;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgCustomerOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class YgCustomerDaoTest {
    @Autowired
    private YgCustomerDao ygCustomerDao;

    @Autowired
    private YgCustomerOrderDao ygCustomerOrderDao;

    @Test
    public void test() {
        List<YgCustomer> queryCustomerBeforeSixMonth = ygCustomerDao.queryCustomerBeforeSixMonth();
        for (YgCustomer ygCustomer : queryCustomerBeforeSixMonth) {
            System.out.println(ygCustomer.getName());
        }

    }

    @Test
    public void test01() {
        List<YgCustomerOrder> recentSixMonth = ygCustomerOrderDao.queryCusomterOderRecentSixMonth(2);
        for (YgCustomerOrder ygCustomerOrder : recentSixMonth) {
            System.out.println(ygCustomerOrder.getOrderNo());
        }

    }
}
