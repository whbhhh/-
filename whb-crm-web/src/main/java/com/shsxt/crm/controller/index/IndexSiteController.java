package com.shsxt.crm.controller.index;

import com.shsxt.framework.constant.VerifyType;
import com.shsxt.framework.context.BaseController;
import com.shsxt.framework.permission.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 */
@Controller
public class IndexSiteController extends BaseController {

    @GetMapping("/index.shtml")
    public String userLogin(){
        return "index";
    }

    @GetMapping("/main.shtml")
    public String main(){
        return "main";
    }
}
