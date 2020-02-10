package com.imooc.ltj.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义手机号约束注解关联验证器
 * @author LTJ
 * @version 1.0
 * @date 2020/2/10 14:56
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {

    /**
     * 自定义校验逻辑方法
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //手机号验证规则正则
        String check="^(1[3-9])\\d{9}$";
        Pattern pattern=Pattern.compile(check);
        //空值处理
        String phone= Optional.ofNullable(value).orElse("");
        Matcher matcher=pattern.matcher(phone);

        return matcher.matches();
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }
}
