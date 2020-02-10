package com.imooc.ltj.validation;

import javax.validation.Valid;

/**
 * 用户信息服务类
 * @author LTJ
 * @version 1.0
 * @date 2020/2/10 10:22
 */
public class UserInfoService {

    /**
     * UserInfo作为输入参数
     * @param userInfo
     */
    public void setUserInfo(@Valid UserInfo userInfo){

    }


    public @Valid UserInfo getUserInfo(){
        return new UserInfo();
    }

    public UserInfoService(){

    }

    public UserInfoService(@Valid UserInfo userInfo){

    }
}
