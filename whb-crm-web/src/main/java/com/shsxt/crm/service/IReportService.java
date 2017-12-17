package com.shsxt.crm.service;
import java.util.Map;

public interface IReportService {
    public Map<String,Object> queryCustomersContribution(Integer page,Integer rows,String name);
    public Map<String,Object> queryCustomersGc();
    public Map<String,Object> queryCustomersServerAnalysis();
}
