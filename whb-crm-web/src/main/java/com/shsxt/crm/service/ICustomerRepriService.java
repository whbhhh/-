package com.shsxt.crm.service;



import java.util.Map;

public interface ICustomerRepriService {
    public Map<String, Object> customerReprievesByLossId(Integer page,Integer rows,Integer lossId);
}
