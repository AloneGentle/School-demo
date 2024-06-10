package com.sut.school.service;

import com.sut.school.constant.WebExceptionEnum;
import com.sut.school.entity.User;
import com.sut.school.exception.WebApiException;
import com.sut.school.repository.UserRepository;
import com.sut.school.utils.JacksonUtil;
import com.sut.school.vo.LoginReq;
import com.sut.school.vo.LoginRes;
import com.sut.school.vo.UserInfoRes;
import com.sut.school.web.reqRes.AddUserReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    @Resource
    StringRedisTemplate redis;

    @Autowired
    ObjectMapper objectMapper;

    public static void main(String[] args) {
        var BCryptPasswordEncoder = new BCryptPasswordEncoder();
        BCryptPasswordEncoder.encode("190627");

    }

    @Override
    public LoginRes login(LoginReq req) {
        log.info("login, req={}", req);
        var ret = new LoginRes();
        var username = req.getUsername();
        if (!StringUtils.hasLength(username)) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }

        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }

        // TODO 防止密码数据泄露, 需要做摘要算法, 需要使用标准密码算法或手动加盐
        // see https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt  config as a bean
        // a better way is use DelegatingPasswordEncoder,see BeansConf class
        var bcrypt = new BCryptPasswordEncoder();
        if (bcrypt.matches(req.getPassword(), user.getPassword())) {
            ret.setToken(genToken(user));
        } else {
            throw new WebApiException(WebExceptionEnum.PASSWORD_ERROR);
        }
        return ret;
    }


    String genToken(User user) {
        // TODO impl genToken，实现生成token 算法，每个人每次登录生成不同的token，并记录登录时间 设置有效期
        // use org.apache.commons.lang3.RandomUtils.nextInt() is better, not new a Random Object every time
        var str = System.currentTimeMillis() + RandomUtils.nextInt(0, 100000) + user.getUsername();
        var token = DigestUtils.md5DigestAsHex(str.getBytes());
        try {
            // set user info as json string use redis's set command with 1 hour expire
            // use JacksonUtil.MAPPER.writeValueAsString to serialize a User object to a JSON string.
            // Instead of use JacksonUtil, an other way is use @Resource ObjectMapper like class StudentServiceImpl:27,
            // the difference is JacksonUtil give you more control on ObjectMapper's configuration
            redis.opsForValue().set(token, objectMapper.writeValueAsString(user), 1, TimeUnit.HOURS);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new WebApiException(WebExceptionEnum.SYSTEM_ERROR);
        }

        return token;
    }

    @Override
    public UserInfoRes info(String token) {
        var info = new UserInfoRes();
        // 有效期内的token 才能返回info, because line 71 set redis value with a expire 1 hour,
        var cacheInfo = redis.opsForValue().get(token);
        if (cacheInfo == null) {
            throw new WebApiException(WebExceptionEnum.PASSWORD_ERROR);
        }
        User user;
        try {
            user = JacksonUtil.MAPPER.readValue(cacheInfo, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new WebApiException(WebExceptionEnum.SYSTEM_ERROR);
        }
        redis.expire(token, 1, TimeUnit.HOURS);
        // TODO token 要和下面的 info 关联上，一个token 对应一个登录会话，token 需要有效期限,长时间不登录要失效，登录中操作要刷新
        //我认为我只需要关联info与token,'需要有效期限,长时间不登录要失效，登录中操作要刷新',这个TODO 在生成token的时候已经实现了吧
        // add new Columns (name,avatar,introduction,roles) to table user to save these info,
        // so these columns can be get by findByUsername and then save to redis with a key of token.
        // don't forget to change SQL statement in init.sql
        // 使本次生成的token与 用户名相关联的用户信息联系在一起?

        // please use cache info in redis instead of above code, delete code in line 104~107,
        //and use  BeanUtils.copyProperties(user, info) copy User Object to info Object, Why not return User Object to front end directly ? What's the difference between UserInfoRes and User?
        BeanUtils.copyProperties(user, info);
        //这个不知道什么作的 查了没看明白
        return info;
    }

    @Override
    public Long addUser(AddUserReq req) {
        // TODO 判断用户名是否已经存在, 做摘要后写入db
        // 判断各个字段是否合法，字符串长度
        var username = req.getUsername();
        var user = userRepository.findByUsername(username);
        if (user != null) {
            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }
        user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));

        return userRepository.save(user).getId();
    }

    @Override
    public void logout(String token) {
        // TODO 清理该用户本次登录会话的token，
        redis.delete(token);


    }

}
