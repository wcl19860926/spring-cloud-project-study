package com.study.common.mybaties.service;


import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageParams;
import com.study.common.base.dto.ResultDto;
import com.study.common.mybaties.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity, PK extends Serializable> {

    T save(T entity);

    void delete(PK id);

    T findById(PK id);

    List<T> findAll();


    List<T> selectList(String statement, @Param("map") Map<String, Object> params);


    Integer selectCount(String statement, @Param("map") Map<String, Object> params);


    ResultDto<PageData<T>> selectByPage(PageParams params);

    public ResultDto<PageData<T>> selectByPage(String statement, PageParams params);

}
