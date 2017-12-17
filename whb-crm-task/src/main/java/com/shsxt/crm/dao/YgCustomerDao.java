package com.shsxt.crm.dao;

import java.util.List;

import com.shsxt.crm.model.YgCustomer;

public interface YgCustomerDao  {
	
	public List<YgCustomer>  queryCustomerBeforeSixMonth() ;
}