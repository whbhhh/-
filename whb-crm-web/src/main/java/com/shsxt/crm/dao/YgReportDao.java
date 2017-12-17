package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgCustomerServer;
import com.shsxt.crm.model.YgReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YgReportDao {
    public List<YgReport> queryCustomersContribution(@Param("name")String name);
    public List<YgReport> queryCustomersGc();
    public List<YgCustomerServer> queryCustomersServerAnalysis();
}
