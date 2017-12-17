package com.shsxt.crm.controller.sys;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgModule;
import com.shsxt.crm.model.YgSystemMenuModel;
import com.shsxt.crm.service.ISystemModuleService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysmodule")
public class SystemModuleController extends BaseController {

    @Autowired
    private ISystemModuleService iSystemModuleService;
    @RequestMapping("/index.html")
    public String index(){
        return "module";
    }

    @PostMapping("/queryModulesByParams")
    @ResponseBody
    public Map<String,Object> queryModulesByParams(YgModule ygModule){
        return iSystemModuleService.queryModulesByParams(ygModule);
    }

    @GetMapping("/querySystemMenu")
    @ResponseBody
    public List<YgSystemMenuModel> querySystemMenu(String rid){
        return iSystemModuleService.querySystemMenu(rid);
    }

    @PostMapping("/insert")
    @ResponseBody
    public Result insertSystemModule(YgModule ygModule){
        return iSystemModuleService.insertSystemModule(ygModule);
    }
}
