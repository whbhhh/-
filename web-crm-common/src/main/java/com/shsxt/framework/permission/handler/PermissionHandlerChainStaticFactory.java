package com.shsxt.framework.permission.handler;

/**
 * 责任链对象工厂
 */
public class PermissionHandlerChainStaticFactory {
    public static PermissionAbstractHandlerChain createPermissionWithNone(){
        return new PermissionWithNone();
    }
    public static PermissionAbstractHandlerChain createPermissionWithLogin(){
        return new PermissionWithLogin();
    }
    public static PermissionAbstractHandlerChain createPermissionWithRole(){
        return new PermissionWithRole();
    }
}
