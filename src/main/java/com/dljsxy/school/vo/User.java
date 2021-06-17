package com.dljsxy.school.vo;

import java.util.List;

public record User(List<String> roles, String introduction, String avatar, String name) {
}
