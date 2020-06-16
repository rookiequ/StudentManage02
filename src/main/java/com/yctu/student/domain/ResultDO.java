package com.yctu.student.domain;

/**
 * @ClassName ResultDO
 * @Description 返回值封装类
 * @Author qlq
 * @Date 2020-06-16 21:49
 */
public class ResultDO<T> {

    /** 是否被调用 */
    private boolean success;
    /** 业务code */
    private int code;
    /** 业务消息 */
    private String msg;
    /** 返回值 */
    private T module;

    public ResultDO() {
    }

    public ResultDO(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }


    public ResultDO(boolean success, int code, String msg, T module) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.module = module;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public void set(boolean success, int code, String msg){
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public void set(boolean success, int code, String msg, T module){
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.module = module;
    }


    @Override
    public String toString() {
        return "ResultDO{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", module=" + module +
                '}';
    }
}
