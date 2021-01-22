package com.dljsxy.school.web;

import com.dljsxy.school.service.UserService;
import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import com.dljsxy.school.web.reqRes.AddUserReq;
import com.dljsxy.school.web.reqRes.BaseApiRes;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public BaseApiRes<LoginRes> login(@RequestBody LoginReq req) {
        var ret = new BaseApiRes<LoginRes>();
        ret.setData(userService.login(req));
        return ret;
    }

    @RequestMapping("/add-user")
    public Long addUser(AddUserReq req) {
        return userService.addUser(req);
    }


    @RequestMapping("/logout")
    public BaseApiRes<Void> logout(@CookieValue("vue_admin_template_token") String token) {
        var ret = new BaseApiRes<Void>();
        userService.logout(token);
        return ret;
    }

    @RequestMapping("/info")
    public BaseApiRes<UserInfoRes> info(String token) {
        var ret = new BaseApiRes<UserInfoRes>();
        ret.setData(userService.info(token));
        return ret;
    }
}
