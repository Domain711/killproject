package com.yunos.killproject.error;

/**
 * @auth Qin HaiJiang
 * @date 2019/3/8 9:59
 */

//包装业务异常
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收BusinessError 构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    //接收自定义BusinessError 构造业务异常
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}