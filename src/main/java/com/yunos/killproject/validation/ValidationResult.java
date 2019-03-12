package com.yunos.killproject.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 校验结果类
 *
 * @auth Qin HaiJiang
 * @date 2019/3/12 11:23
 */
public class ValidationResult {

    //是否有错误
    private boolean hasError = false;

    //错误信息集合
    private Map<String, String> errMsgMap = new HashMap<>();


    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public Map<String, String> getErrMsgMap() {
        return errMsgMap;
    }

    public void setErrMsgMap(Map<String, String> errMsgMap) {
        this.errMsgMap = errMsgMap;
    }

    //格式化字符串信息
    public String getErrMsg(){
        return StringUtils.join(errMsgMap.values().toArray(),",");
    }
}
