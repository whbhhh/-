package com.shsxt.crm.controller.sys;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgRole;
import com.shsxt.crm.service.ISystemRoleService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysrole")
public class SystemRoleController extends BaseController {

    @Autowired
    private ISystemRoleService iSystemRoleService;

    @RequestMapping("/index.html")
    public String index() {
        return "role";
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @PostMapping("/queryAllRoles")
    @ResponseBody
    public List<YgRole> queryAllRoles() {
        return iSystemRoleService.queryAllRoles(null);
    }

    @PostMapping("/queryAllRolesByParams")
    @ResponseBody
    public Map<String, Object> queryAllRolesByParams(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, String roleName) {
        return iSystemRoleService.queryAllRolesByParams(page, rows, roleName);
    }


    @PostMapping("/insert")
    @ResponseBody
    public Result insertSysRole(YgRole ygRole){
        return iSystemRoleService.insertSysRole(ygRole);
    }
    @PostMapping("/update")
    @ResponseBody
    public Result updateSysRole(YgRole ygRole){
        return iSystemRoleService.updateSysRole(ygRole);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result deleteSysRole(Integer[] ids){
        return iSystemRoleService.deleteSysRole(ids);
    }

    /**
     * 角色授权
     * @param rid
     * @param moduleIds
     * @return
     */
    @PostMapping("/addPermission")
    @ResponseBody
    public Result addPermission(Integer rid,Integer[] moduleIds){
        return null;
    }
}
