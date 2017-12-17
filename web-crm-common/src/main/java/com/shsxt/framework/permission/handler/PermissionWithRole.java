package com.shsxt.framework.permission.handler;

import com.shsxt.common.util.VerificationLoginUtil;
import com.shsxt.framework.constant.CrmConstant;
import com.shsxt.framework.constant.VerifyType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PermissionWithRole extends PermissionAbstractHandlerChain {
    @Override
    public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType,String[] verifyValue) {
        if (verifyType == VerifyType.ROLE){
            boolean isLogin = VerificationLoginUtil.isLogin(request);
            if (!isLogin){
                return false;
            }
            //用户操作权限
            List<String> permissionAcl = (List<String>) request.getSession().getAttribute(CrmConstant.USER_PERMISSIONS);
            for (String value : verifyValue) {
                if (!permissionAcl.contains(value)){
                    return false;
                }
            }
        }
        return true;
    }
}
