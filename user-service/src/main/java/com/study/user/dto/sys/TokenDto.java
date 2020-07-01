package com.study.user.dto.sys;

import lombok.Data;

import java.util.Date;
@Data
public class TokenDto {
    private String token;
    private String clientId;
    private long expire;
    private Date created;
}
