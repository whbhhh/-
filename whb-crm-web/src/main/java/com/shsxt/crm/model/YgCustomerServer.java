package com.shsxt.crm.model;

/**
 * 客户服务分析 
 * @author Mr.YongGan.Zhang
 *
 */
public class YgCustomerServer {
	
	// 服务类别
	private String name;
	
	// 服务数量
	private Integer  value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
