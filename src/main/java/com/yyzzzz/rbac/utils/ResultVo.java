package com.yyzzzz.rbac.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 200：表示成功
 * 500：表示错误，错误信息在msg字段中
 * 501：bean验证错误，不管多少个错误都以map形式返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 * 556: 用户qq校验异常
 * *
 */
public class ResultVo {

    private Integer status;

    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;    // 不使用

    public static ResultVo build(Integer status, String msg, Object data) {
        return new ResultVo(status, msg, data);
    }

    public static ResultVo build(Integer status, String msg, Object data, String ok) {
        return new ResultVo(status, msg, data, ok);
    }

    public static ResultVo ok(Object data) {
        return new ResultVo(data);
    }

    public static ResultVo ok() {
        return new ResultVo(null);
    }

    public static ResultVo errorMsg(String msg) {
        return new ResultVo(500, msg, null);
    }

    public static ResultVo errorMap(Object data) {
        return new ResultVo(501, "error", data);
    }

    public static ResultVo errorTokenMsg(String msg) {
        return new ResultVo(502, msg, null);
    }

    public static ResultVo errorException(String msg) {
        return new ResultVo(555, msg, null);
    }

    public static ResultVo errorUserQQ(String msg) {
        return new ResultVo(556, msg, null);
    }

    public ResultVo() {

    }

    public ResultVo(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public ResultVo(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
