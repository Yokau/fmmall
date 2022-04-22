package com.yokau.tkmapper.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "nickname")
    private String userNickName;
    @Column(name = "realname")
    private String userRealName;
    private String userImg;
    private String userMobile;
    private String userEmail;
    private String userSex;
    private Date userBirth;
    private Date userRegtime;
    private Date userModtime;
    private List<Orders> ordersList;
}

