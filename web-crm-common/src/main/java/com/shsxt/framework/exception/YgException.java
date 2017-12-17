package com.shsxt.framework.exception;

import org.apache.log4j.Logger;

public class YgException extends RuntimeException {
    private static final Logger LOGGER = Logger.getLogger(YgException.class);
    private static final long serialVersionUID = -548900335265676688L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public YgException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public YgException() {
        super();
    }
}
