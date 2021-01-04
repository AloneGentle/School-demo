package com.dljsxy.school.service;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.repository.UserRepository;
import com.dljsxy.school.vo.LoginReq;
import com.dljsxy.school.vo.LoginRes;
import com.dljsxy.school.vo.UserInfoRes;
import com.dljsxy.school.web.reqRes.AddUserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.dljsxy.school.entity.User;
import com.dljsxy.school.utils.MD5Util;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    StringRedisTemplate redis;

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

        // TODO 防止密码数据泄露, 需要做摘要算法, 需要使用标准密码算法或手动加盐
        if (user.getPassword().equals(req.getPassword())) {
            ret.setToken(genToken(req.getUsername()));
            getMD5(user.getPassword());


        } else {
            throw new WebApiException(WebExceptionEnum.PASSWORD_ERROR);
        }
        return ret;
    }

    String genToken(String username) {
        // TODO impl genToken，实现生成token 算法，每个人每次登录生成不同的token，并记录登录时间 设置有效期

        return (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
    }

    @Override
    public UserInfoRes info(String token) {
        var info = new UserInfoRes();
        // 有效期内的token 才能返回info

        // TODO token 要和下面的 info 关联上，一个token 对应一个登录会话，token 需要有效期限,长时间不登录要失效，登录中操作要刷新
        info.setName("Super Admin");
        info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        info.setIntroduction("I am a super administrator");
        info.setRoles(List.of("admin"));
        return info;
    }

    @Override
    public Long addUser(AddUserReq req) {
        // TODO 判断用户名是否已经存在, 做摘要后写入db
        // 判断各个字段是否合法，字符串长度
        var username = req.getUsername();
        var user = userRepository.findByUserName(username);
        if (user == null) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }
            User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(getMD5(req.getPassword()));


        return userRepository.save(user).getId();
    }
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }
    }

    @Override
    public void logout() {

        // TODO 清理该用户本次登录会话的token，

    }


}
