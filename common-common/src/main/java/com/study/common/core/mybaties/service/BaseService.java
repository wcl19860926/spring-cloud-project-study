package com.study.common.core.mybaties.service;


import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageParams;
import com.study.common.base.dto.ResultDto;
import com.study.common.core.mybaties.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity, PK extends Serializable> {

    T insert(T entity);

    T insertSelective(T entity);

    Integer update(T entity);


    Integer updateSelective(T entity);

    void delete(PK id);

    T findById(PK id);

    List<T> findList(Map<String, Object> params);


    List<T> selectList(String statement, @Param("map") Map<String, Object> params);


    Integer selectCount(String statement, @Param("map") Map<String, Object> params);


    ResultDto<PageData<T>> selectByPage(PageParams params);

    public ResultDto<PageData<T>> selectByPage(String statement, PageParams params);

}
