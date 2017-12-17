package com.shsxt.crm.dao;

import com.shsxt.crm.model.YgModule;
import com.shsxt.crm.model.YgSystemMenuModel;
import com.shsxt.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YgModuleDao extends BaseDao<String,YgModule> {


    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<YgModule> findAll(Map<String,Object> map);



    public List<YgSystemMenuModel> querySystemMenu();

    public List<String> queryRoleAclValueByRid(@Param("rid") String rid);

    public YgSystemMenuModel queryMenuModelByMid(@Param("mid") Integer mid);
}