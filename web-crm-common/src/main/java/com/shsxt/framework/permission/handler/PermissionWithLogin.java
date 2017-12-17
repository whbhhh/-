package com.shsxt.framework.permission.handler;

import com.shsxt.common.util.VerificationLoginUtil;
import com.shsxt.framework.constant.VerifyType;

import javax.servlet.http.HttpServletRequest;

public class PermissionWithLogin extends PermissionAbstractHandlerChain{
    @Override
    public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType,String[] verifyValue ) {
        if (verifyType == VerifyType.LOGIN){
            return VerificationLoginUtil.isLogin(request);
        }
        setSuccessor(PermissionHandlerChainStaticFactory.createPermissionWithRole());
        return successor.cherkPermissionHandleChain(request,verifyType,verifyValue);
    }
}
