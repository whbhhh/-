package com.shsxt.crm.controller.user;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCustomer;
import com.shsxt.crm.model.YgUser;
import com.shsxt.crm.service.IUserService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    @PostMapping("/userLogin")
    @ResponseBody
    public Result userLogin(@RequestParam(defaultValue = "")String userName,@RequestParam(defaultValue = "")String userPwd){
        return userService.userLogin(userName,userPwd);
    }

    /**
     * 查询用户经理
     */
    @PostMapping("/queryAllCustomerManager")
    @ResponseBody
    public List<YgUser> queryAllCustomerManager(){
        return userService.queryAllCustomerManager();
    }

}
