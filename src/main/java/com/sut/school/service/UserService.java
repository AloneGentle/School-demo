package com.sut.school.service;

import com.sut.school.vo.LoginReq;
import com.sut.school.vo.LoginRes;
import com.sut.school.vo.UserInfoRes;
import com.sut.school.web.reqRes.AddUserReq;

public interface UserService {

    LoginRes login(LoginReq req);

    UserInfoRes info(String token);

    Long addUser(AddUserReq user);

    void logout(String token);

}
