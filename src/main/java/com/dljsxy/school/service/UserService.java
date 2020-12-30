package com.dljsxy.school.service;

import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import com.dljsxy.school.web.reqRes.AddUserReq;

public interface UserService {

    LoginRes login(LoginReq req);

    UserInfoRes info(String token);

    Long addUser(AddUserReq user);

    void logout();

}
