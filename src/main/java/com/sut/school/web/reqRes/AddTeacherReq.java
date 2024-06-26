package com.sut.school.web.reqRes;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddTeacherReq {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private int age;

}
