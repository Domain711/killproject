package com.yunos.killproject.response;

/**
 * 通用的返回对象
 *
 * @auth Qin HaiJiang
 * @date 2019/3/8 8:42
 */
public class CommonReturnType {
    //请求的返回处理结果 "success","fail"
    private String status;

    //若返回 status==success则data内返回前端需要的json信息
    //若返回status==fail则data内返回通用的错误码信息
    private Object data;


    //定义通用的创建函数
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
