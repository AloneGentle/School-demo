package com.dljsxy.school.service;

import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;

public interface UserService {
    LoginRes login(LoginReq req);

    UserInfoRes info(String token);

    void logout();

}
