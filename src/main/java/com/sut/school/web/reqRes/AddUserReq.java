package com.sut.school.web.reqRes;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddUserReq {
    // TODO String 长度判断
    @NotNull
    @NotEmpty
    private String username;
    //        // 判断各个字段是否合法，字符串长度
    @NotNull
    @NotEmpty
    @Length(max = 20, min = 6)
    private String password;
}
