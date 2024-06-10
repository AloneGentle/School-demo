package com.sut.school.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoRes {
    private List<String> roles;
    private String introduction;
    private String avatar;
    private String name;
}
