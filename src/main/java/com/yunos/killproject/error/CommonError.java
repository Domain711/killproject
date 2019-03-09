package com.yunos.killproject.error;

public interface CommonError {
     int getErrCode();

     String getErrMsg();

     CommonError setErrMsg(String errMsg);
}
