package com.shsxt.common.util;

import com.shsxt.framework.constant.CrmConstant;

public class BaseQuery {
	
	private Integer page=CrmConstant.PAGE;
	private Integer rows=CrmConstant.ROWS;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
