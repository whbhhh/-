package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.YgReportDao;
import com.shsxt.crm.model.YgCustomerServer;
import com.shsxt.crm.model.YgReport;
import com.shsxt.crm.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private YgReportDao ygReportDao;

    @Override
    public Map<String, Object> queryCustomersContribution(Integer page, Integer rows, String name) {
        PageHelper.startPage(page, rows);
        List<YgReport> info = ygReportDao.queryCustomersContribution(name);
        PageInfo<YgReport> pageInfo = new PageInfo<>(info);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public Map<String, Object> queryCustomersGc() {
        List<YgReport> list = ygReportDao.queryCustomersGc();
        List<String> level = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (YgReport ygReport : list) {
            level.add(ygReport.getLevel());
            count.add(ygReport.getCount());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("level", level);
        map.put("count", count);
        return map;
    }

    @Override
    public Map<String, Object> queryCustomersServerAnalysis() {
        List<YgCustomerServer> list = ygReportDao.queryCustomersServerAnalysis();
        List<String> name = new ArrayList<>();
        for (YgCustomerServer ygCustomerServer : list) {
            name.add(ygCustomerServer.getName());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("name", name);
        map.put("list", list);
        return map;
    }
}
