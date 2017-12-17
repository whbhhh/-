package com.shsxt.crm.task;

import com.shsxt.crm.service.SystemJudgeCustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class SystemJudgeCustomerTaskSchedule {
    @Autowired
    private SystemJudgeCustomerLossService systemJudgeCustomerLossService;
    public void systemJudgeCustomerjobTask(){
        systemJudgeCustomerLossService.systemJudgeCustomerLoss();
    }
}
