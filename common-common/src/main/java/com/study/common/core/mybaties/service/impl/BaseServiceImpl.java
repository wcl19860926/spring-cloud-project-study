package com.study.common.core.mybaties.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageParams;
import com.study.common.base.dto.ResultDto;
import com.study.common.core.id.service.IdGeneratorService;
import com.study.common.core.mybaties.entity.BaseEntity;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.BaseService;
import com.study.common.core.mybaties.service.holder.SnowflakeIdGeneratorHolder;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {

    private static final String SELECT_BY_PAGE_LIST = "queryListPage";

    private IdGeneratorService idGeneratorService;


    public BaseServiceImpl( ) {
        this.idGeneratorService = SnowflakeIdGeneratorHolder.getInstance();
    }

    @Autowired
    public SqlSessionTemplate sqlSession;

    public abstract BaseMapper<T, PK> getMapper();

    @Override
    public T findById(PK id) {
        Assert.notNull(id, "通过主键查找时，给出的id不能为空");
        return getMapper().findById(id);
    }

    @Override
    public T save(T entity) {
        Assert.notNull(entity, "待保存的对象不能为空");
        entity.setId(idGeneratorService.generate());
        getMapper().insert(entity);
        return entity;
    }

    @Override
    public void delete(PK id) {
        Assert.notNull(id, "删除对象时，没有给出id");
        getMapper().delete(id);
    }

    @Override
    public List<T> findAll() {
        return getMapper().findAll();
    }


    /**
     * 自定义sql查询List<EntityMap>
     */
    @Override
    public List<T> selectList(String statement, @Param("map") Map<String, Object> params) {
        return sqlSession.selectList(getMapperName() + statement, params);
    }


    @Override
    public Integer selectCount(String statement, Map<String, Object> params) {
        return sqlSession.selectOne(getMapperName() + statement, params);
    }


    /**
     * 获取mapperName
     */
    private String getMapperName() {
        return this.getMapper().getClass().getName();
    }


    @Override
    public ResultDto<PageData<T>> selectByPage(PageParams params) {
        Page pageInfo = PageHelper.startPage(params.getPageIndex(), params.getPageSize());
        PageData pageData = new PageData(pageInfo.getPageNum(), pageInfo.getPageSize());
        pageData.setTotalRecord((int) pageInfo.getTotal());
        List<T> data = sqlSession.selectList(getMapperName() + SELECT_BY_PAGE_LIST, params);
        pageData.setData(data);
        return ResultDto.sucess(pageData);

    }



    /**
     * 自定义sql查询List<EntityMap>
     */
    @Override
    public ResultDto<PageData<T>> selectByPage(String statement, PageParams params) {
        Page pageInfo = PageHelper.startPage(params.getPageIndex(), params.getPageSize());
        PageData pageData = new PageData(pageInfo.getPageNum(), pageInfo.getPageSize());
        pageData.setTotalRecord((int) pageInfo.getTotal());
        List<T> data = sqlSession.selectList(getMapperName() + SELECT_BY_PAGE_LIST, params);
        pageData.setData(data);
        return ResultDto.sucess(pageData);
    }
}
