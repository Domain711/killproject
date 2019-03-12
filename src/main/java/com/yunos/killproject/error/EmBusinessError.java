package com.yunos.killproject.error;

/**
 * @auth Qin HaiJiang
 * @date 2019/3/8 9:44
 */
public enum EmBusinessError implements CommonError {

    //通用错误类型00001开头
    PARAMETER_VALIDATION_ERROR(00001, "参数不合法"),

    UNKNOW_ERROR(00001, "未知错误"),

    //10000开头为用户相关的错误信息
    USER_NOT_EXIST(10001, "用户不存在"),
    USER_LOGIN_FAIL(10002, "手机号或密码错误");

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    //定义全局变量
    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
