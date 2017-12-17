package com.shsxt.framework.permission.handler;

import com.shsxt.framework.constant.VerifyType;

import javax.servlet.http.HttpServletRequest;

public class PermissionWithNone extends PermissionAbstractHandlerChain {

    @Override
    public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType,String[] verifyValue ) {
        if (verifyType == VerifyType.NONE){
            return true;
        }
        setSuccessor(PermissionHandlerChainStaticFactory.createPermissionWithLogin());
        return successor.cherkPermissionHandleChain(request,verifyType,verifyValue);
    }
}
