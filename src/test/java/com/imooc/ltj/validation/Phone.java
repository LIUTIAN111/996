package com.imooc.ltj.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义手机号约束注解
 * @author LTJ
 * @version 1.0
 * @date 2020/2/10 14:49
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//保留策略
@Constraint(validatedBy = PhoneValidator.class)//指定关联的验证器
public @interface Phone {

    //约束注解验证时的输出信息
    String message() default "手机号校验错误";

    //约束注解在验证时所属的组别
    Class<?>[] groups() default{};

    //约束注解的有效负载
    Class<? extends Payload>[] payload() default {};
}
