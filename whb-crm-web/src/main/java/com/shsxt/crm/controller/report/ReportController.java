package com.shsxt.crm.controller.report;

import com.shsxt.crm.service.IReportService;
import com.shsxt.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {
    @Autowired
    private IReportService iReportService;
    @GetMapping("/{type}")
    public String index(@PathVariable("type") Integer type){
        if (type == 0){
            return "customer_contribution";
        }else if (type == 1){
            return "customer_gc";
        }else if (type == 2){
            return "customer_serve";
        }else {
            return "500";
        }
    }
    @PostMapping("/queryCustomersContribution")
    @ResponseBody
    public Map<String,Object> queryCustomersContribution(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows,@RequestParam(value = "name",defaultValue = "")String name){
        return iReportService.queryCustomersContribution(page,rows,name);
    }

    @GetMapping("/queryCustomersGc")
    @ResponseBody
    public Map<String,Object> queryCustomersGc(){
        return iReportService.queryCustomersGc();
    }

    @GetMapping("/queryCustomersServe")
    @ResponseBody
    public Map<String,Object> queryCustomersServerAnalysis(){
        return iReportService.queryCustomersServerAnalysis();
    }

}
