package com.imooc.ltj.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 待验证实体类
 *
 * @author LTJ
 * @version 1.0
 * @date 2020/2/8 23:59
 */
@Data
public class UserInfo {

    //登录场景
    public interface LoginGroup{}

    //注册场景
    public interface RegisterGroup{}

    //组排序场景
    @GroupSequence({
            LoginGroup.class,RegisterGroup.class, Default.class
    })
    public interface Group{}

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空",groups = LoginGroup.class)
    private String userId;

    /**
     * 用户名
     */
    //不会自动去掉字符串前后空格
    @NotEmpty(message = "用户名称不能为空")
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 20, message = "密码不能小于6位或大于20位")
    //自动去掉字符串前后空格，再进行验证
    private String password;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空",groups = RegisterGroup.class)
    @Email(message = "邮箱必须为有效邮箱")
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号无效")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18,message = "年龄不能小于18岁")
    @Max(value = 60,message = "年龄不能大于60岁")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能为未来时间")
    private Date birthday;

    /**
     * 好友列表
     * @Valid 级联验证
     */
    @Size(min = 1,message = "不能少于一个好友")
    private List<@Valid UserInfo> friends;

}
