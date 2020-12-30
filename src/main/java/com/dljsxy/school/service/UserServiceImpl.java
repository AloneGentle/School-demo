package com.dljsxy.school.service;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.repository.UserRepository;
import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import com.dljsxy.school.web.reqRes.AddUserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public LoginRes login(LoginReq req) {
        log.info("login, req={}", req);
        var ret = new LoginRes();
        var username = req.getUsername();
        if (!StringUtils.hasLength(username)) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }

        var user = userRepository.findByUserName(username);
        if (user == null) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }

        if (user.getPassword().equals(req.getPassword())) {
            ret.setToken(genToken(req.getUsername()));
        } else {
            throw new WebApiException(WebExceptionEnum.PASSWORD_ERROR);
        }
        return ret;
    }

    String genToken(String username) {
        // TODO impl genToken
        return "token 2iosjifjsdf88232";
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
