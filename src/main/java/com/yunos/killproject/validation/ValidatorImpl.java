package com.yunos.killproject.validation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 校验器接口的实现
 *
 * @auth Qin HaiJiang
 * @date 2019/3/12 11:27
 */

@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;


    //通用的方法，用于校验并返回校验结果

    public ValidationResult validate(Object bean) {
        ValidationResult validationResult = new ValidationResult();
        Set<ConstraintViolation<Object>> violations = validator.validate(bean);

        if (violations.size() > 0) {
            //有错误
            //遍历错误信息
            validationResult.setHasError(true);
            violations.forEach(constraintViolation -> {
                String errMsg = constraintViolation.getMessage();
                String property = constraintViolation.getPropertyPath().toString();
                validationResult.getErrMsgMap().put(property, errMsg);
            });

        }

        return validationResult;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //hibernate validator实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }
}
