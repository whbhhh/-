package com.shsxt.crm.controller.sys;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgUser;
import com.shsxt.crm.service.ISystemUserService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sysuser")
public class SystemUserController extends BaseController {

    @Autowired
    private ISystemUserService iSystemUserService;
    @RequestMapping("/index.html")
    public String index(){
        return "user";
    }

    /**
     * 查询系统用户
     * @param ygUser
     * @return
     */
    @PostMapping("/queryUsersByParams")
    @ResponseBody
    public Map<String,Object> queryUsersByParams(YgUser ygUser){
        return iSystemUserService.queryUsersByParams(ygUser);
    }

    /**
     * 增加系统用户
     * @param ygUser
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertSystemUser(YgUser ygUser){
        return iSystemUserService.insertSystemUser(ygUser);
    }

    /**
     * 删除系统用户
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delSystemUser(Integer[] ids){
        return iSystemUserService.delSystemUser(ids);
    }
}
