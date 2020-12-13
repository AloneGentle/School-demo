package com.dljsxy.school.service;

import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public LoginRes login(LoginReq req) {
        var ret = new LoginRes();
        log.info("login, req={}", req);
        ret.setToken("token 2iosjifjsdf88232");
        return ret;
    }

    @Override
    public UserInfoRes info(String token) {
        var info = new UserInfoRes();
        info.setName("Super Admin");
        info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        info.setIntroduction("I am a super administrator");
        info.setRoles(List.of("admin"));
        return info;
    }

    @Override
    public void logout() {

    }


}
