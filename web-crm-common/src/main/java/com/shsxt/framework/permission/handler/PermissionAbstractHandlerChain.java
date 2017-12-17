package com.shsxt.framework.permission.handler;

import com.shsxt.framework.constant.VerifyType;

import javax.servlet.http.HttpServletRequest;

public abstract class PermissionAbstractHandlerChain {
    protected PermissionAbstractHandlerChain successor;

    /**
     * 设置处理链对象
     * @param successor
     */
    public void setSuccessor(PermissionAbstractHandlerChain successor) {
        this.successor = successor;
    }

    /**
     * 权限校验链
     * @param request
     * @param verifyType
     */
    public abstract boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType,String[] verifyValue);
}
