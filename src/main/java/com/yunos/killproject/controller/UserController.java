package com.yunos.killproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.yunos.killproject.controller.viewobject.UserVo;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.response.CommonReturnType;
import com.yunos.killproject.service.UserService;
import com.yunos.killproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials="true",allowedHeaders = "*")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    //用户注册接口
    @RequestMapping(value = "reg", method = RequestMethod.POST, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType reg(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "password") String password
    ) throws BusinessException {


        //验证手机号，otpcode是否对应
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);

        if (!StringUtils.equals(inSessionOtpCode, otpCode)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不正确");
        }

        //验证码合法进入注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setGender(gender);
        userModel.setRegisterMode("byphone");
        userModel.setPassword(encodeByMd5(password));
        userService.register(userModel);

        return CommonReturnType.create(null);

    }

    private String encodeByMd5(String str) {
        String res = DigestUtils.md5DigestAsHex(str.getBytes());
        return res;
    }

    //用户获取otp短信接口
    @RequestMapping(value = "getOtp", method = RequestMethod.POST, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {
        //需要按照一定的规则生成OTP验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);


        //将对应的OTP验证码与对应用户的手机号关联起来,暂时使用httpsession的方式存储手机号-验证码
        this.httpServletRequest.getSession().setAttribute(telphone, otpCode);

        //将OTP验证码通过短信通道发送给用户

        System.out.println("telphone=" + telphone + "&optCode=" + otpCode);
        return CommonReturnType.create(null);
    }

    @RequestMapping("getUser")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service 服务层
        UserModel user = userService.getUserById(id);

        if (null == user) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        //将核心领域模型转换为可供前端使用的viewobject
        UserVo vo = convertFromModel(user);
        return CommonReturnType.create(vo);
    }

    private UserVo convertFromModel(UserModel userModel) {
        if (null == userModel) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);
        return userVo;
    }

}
