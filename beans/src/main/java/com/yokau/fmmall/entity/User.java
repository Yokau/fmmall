package com.yokau.fmmall.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象",description = "买家/用户信息")

public class User {
    @ApiModelProperty(dataType = "int", required = false)
    private int userId;
    @ApiModelProperty(dataType = "String", required = true, value = "用户注册账号")
    private String userName;
    @ApiModelProperty(dataType = "String", required = true, value = "用户注册密码")
    private String userPassword;
    @ApiModelProperty(dataType = "String", required = true, value = "用户昵称")
    private String userNickName;
    @ApiModelProperty(dataType = "String", required = true, value = "用户真实姓名")
    private String userRealName;
    @ApiModelProperty(dataType = "String", required = true, value = "用户头像URL")
    private String userImg;
    @ApiModelProperty(dataType = "String", required = true, value = "用户手机号码")
    private String userMobile;
    @ApiModelProperty(dataType = "String", required = true, value = "用户邮箱")
    private String userEmail;
    @ApiModelProperty(dataType = "String", required = true, value = "用户性别")
    private String userSex;
    @ApiModelProperty(dataType = "Date", required = true, value = "用户生日日期")
    private Date userBirth;
    @ApiModelProperty(dataType = "Date", required = true, value = "用户注册时间")
    private Date userRegtime;
    @ApiModelProperty(dataType = "Date", required = true, value = "用户修改时间")
    private Date userModtime;
}
