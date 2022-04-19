package com.yokau.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userRealName;
    private String userImg;
}
