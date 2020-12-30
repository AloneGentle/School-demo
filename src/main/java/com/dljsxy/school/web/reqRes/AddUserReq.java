package com.dljsxy.school.web.reqRes;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AddUserReq {
    @NotNull
    @NotEmpty
    private String name;

}
