package com.nuctech.haomibo.backgroundservice.common.vo;

import com.nuctech.haomibo.backgroundservice.common.constants.CommonConstant;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success = true;
    private String msg = "操作成功！";
    private Integer code = 0;
    private T result;
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    public void error500(String msg) {
        this.msg = msg;
        this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
    }

    public void errorLogic(String msg) {
        this.msg = msg;
        this.code = CommonConstant.SC_LOGIC_ERROR;
        this.success = false;
    }

    public void success(String msg) {
        this.msg = msg;
        this.code = CommonConstant.SC_OK_200;
        this.success = true;
    }

    public static Result<Object> error(String msg) {
        return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMsg(msg);
        r.setSuccess(false);
        return r;
    }

    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMsg(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setResult(data);
        return r;
    }

}
