package com.shsxt.crm.controller.customer;

import com.shsxt.crm.service.ICustomerRepriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/customer_repri")
public class CustomerRepriController {

    @Autowired
    private ICustomerRepriService iCustomerRepriService;
    @PostMapping("/customerReprievesByLossId")
    @ResponseBody
    public Map<String, Object> customerReprievesByLossId(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows,@RequestParam("lossId") Integer lossId) {
        return iCustomerRepriService.customerReprievesByLossId(page,rows,lossId);
    }
}
