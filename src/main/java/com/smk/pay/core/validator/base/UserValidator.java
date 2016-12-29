package com.smk.pay.core.validator.base;

import com.smk.pay.core.manager.base.IUserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/25 18:10
 */
@Component("userValidator")
public class UserValidator {

    @Autowired
    private IUserInfoManager userInfoManager;

}
