package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgDataDic;
import com.shsxt.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YgDataDicDao extends BaseDao<Integer,YgDataDic>{
    List<YgDataDic> queryDataDicValueByDataDicName (@Param("dataDicName") String dataDicName);
}