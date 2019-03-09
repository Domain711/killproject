package com.yunos.killproject.controller;

import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义统一异常处理controller
 * @auth Qin HaiJiang
 * @date 2019/3/8 11:10
 */
public class BaseController {

    public static final String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";

    //定义exceptionHandle 处理未被controller层解决的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception ex) {
        CommonReturnType commonReturnType = new CommonReturnType();
        Map<String, Object> data = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            commonReturnType.setStatus("fail");
            data.put("errCode", businessException.getErrCode());
            data.put("errMsg", businessException.getErrMsg());
        } else {
            commonReturnType.setStatus("fail");
            data.put("errCode", EmBusinessError.UNKNOW_ERROR.getErrCode());
            data.put("errMsg", EmBusinessError.UNKNOW_ERROR.getErrMsg());
        }
        commonReturnType.setData(data);
        return commonReturnType;
    }
}
