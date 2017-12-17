package com.shsxt.crm.service;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgModule;
import com.shsxt.crm.model.YgSystemMenuModel;

import java.util.List;
import java.util.Map;

public interface ISystemModuleService {
    public Map<String,Object> queryModulesByParams(YgModule ygModule);

    /**
     * 系统菜单
     * @return
     */
    public List<YgSystemMenuModel> querySystemMenu(String rid);

    public Result insertSystemModule(YgModule ygModule);
    public YgSystemMenuModel queryMenuModelByMid(Integer mid);
}
