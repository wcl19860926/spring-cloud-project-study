package com.study.common.mybaties.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity<PK>  implements Serializable {

    private PK id;

    private Date createTime;

    private Date updateTime;

    private  boolean isDelete;


}
