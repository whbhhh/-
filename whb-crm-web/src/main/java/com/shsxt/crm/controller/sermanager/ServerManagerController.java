package com.shsxt.crm.controller.sermanager;

import com.shsxt.common.util.Result;
import com.shsxt.crm.model.YgCustomerServe;
import com.shsxt.crm.model.YgDataDic;
import com.shsxt.crm.service.IServerManagerService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer_serve")
public class ServerManagerController extends BaseController{

    @Autowired
    private IServerManagerService iServerManagerService;
    @GetMapping("/{page}/index.html")
    public String index(@PathVariable("page")Integer page){
        if (page == 1){
            return "customer_serve_create";
        }else if (page == 2){
            return "customer_serve_assign";
        }else if (page == 3){
            return "customer_serve_proceed";
        }else if (page == 4){
            return "customer_serve_feed_back";
        }else if (page == 5){
            return "customer_serve_archive";
        }else {
            return "500";
        }
    }

    /**
     * 查询客户服务类型
     * @param dataDicName
     * @return
     */
    @PostMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<YgDataDic> queryDataDicValueByDataDicName(@RequestParam("dataDicName") String dataDicName){
        return iServerManagerService.queryDataDicValueByDataDicName(dataDicName);
    }

    /**
     * 添加服务管理
     * @param ygCustomerServe
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertYgCustomerServer(YgCustomerServe ygCustomerServe){
        return iServerManagerService.insertYgCustomerServer(ygCustomerServe);
    }

    @PostMapping("/queryCustomerServesByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerServesByParams(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows,@RequestParam("state") Integer state){
        return iServerManagerService.queryCustomerServesByParams(page,rows,state);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result addCustomerServeAssign(YgCustomerServe ygCustomerServe){
        return iServerManagerService.addCustomerServeAssign(ygCustomerServe);
    }

}
