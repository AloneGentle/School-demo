package com.dljsxy.school.service;

import com.dljsxy.school.entity.User;
import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import com.dljsxy.school.web.reqRes.AddUserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.dljsxy.school.repository.UserRepository;


import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;


    @Override
    public User getUserInfoByName(String username) {
        return userRepository.findByUserName(username);
    }

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
    public Long addUser(AddUserReq user) {
        return null;
    }


    @Override
    public void logout() {

    }


}
