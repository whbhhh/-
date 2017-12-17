package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.shsxt.common.util.Result;
import com.shsxt.crm.dao.YgModuleDao;
import com.shsxt.crm.model.YgModule;
import com.shsxt.crm.model.YgSystemMenuModel;
import com.shsxt.crm.service.ISystemModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SystemModuleServiceImpl implements ISystemModuleService {

    @Autowired
    private YgModuleDao ygModuleDao;
    @Override
    public Map<String, Object> queryModulesByParams(YgModule ygModule) {
        PageHelper.startPage(ygModule.getPage(), ygModule.getRows());
        Map<String, Object> params = new HashMap<>();
        if (StringUtil.isNotEmpty(ygModule.getModuleName())) {
            params.put("moduleName", ygModule.getModuleName());
        }
        if (StringUtil.isNotEmpty(ygModule.getOptValue())) {
            params.put("optValue", ygModule.getOptValue());
        }
        if (StringUtil.isNotEmpty(ygModule.getParentModuleName())) {
            params.put("parentModuleName", ygModule.getParentModuleName());
        }
        List<YgModule> list = ygModuleDao.findAll(params);
        PageInfo<YgModule> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    /**
     * 系统菜单
     *
     * @return
     */
    @Override
    public List<YgSystemMenuModel> querySystemMenu(String rid) {
        List<YgSystemMenuModel> menu = ygModuleDao.querySystemMenu();
        if (StringUtil.isNotEmpty(rid)) {
            List<String> acl = ygModuleDao.queryRoleAclValueByRid(rid);
            setModuleNoteMenu(menu,acl);
        }
        return menu;
    }

    @Override
    public Result insertSystemModule(YgModule ygModule) {
        ygModule.setIsValid((byte) 1);
        ygModule.setUpdateDate(new Date());
        ygModule.setCreateDate(new Date());
        long s = ygModuleDao.saveSte(ygModule);
        if (s == 1){
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 设置菜单节点 是否默认选中
     * @param menu
     * @param acl
     */
    private void setModuleNoteMenu(List<YgSystemMenuModel> menu, List<String> acl) {
        Iterator<YgSystemMenuModel> iterator = menu.iterator();
        while (iterator.hasNext()) {
            YgSystemMenuModel ygSystemMenuModel = iterator.next();
            if (acl.contains(ygSystemMenuModel.getOptValue())) {
                ygSystemMenuModel.setChecked(true);
            }
        }
    }
    public YgSystemMenuModel queryMenuModelByMid(Integer mid){
        return ygModuleDao.queryMenuModelByMid(mid);
    }

}
