package com.study.generator.model;


import lombok.Data;

import java.util.List;

@Data
public class TableInfo {

    private String tableName;


    private ColumnInfo keyColumn;


    private List<ColumnInfo> columns;

    private String domainName;

    private String domainType;


    private String baseResultMapId;


    private String  mapperPackage;

    private String  mapperFileName;

    private String  mapperNameSpace;

    private  String  mapperJavaType;



    private  String  xmlTargetPackage;

    private  String  xmlTargetProject;


    private String  javaEntityPackage;

    private String  javaEntityTargetProject;


    private  String  javaMapperPackage;

    private  String javaMapperTargetProject;



    private String insertStatementId;

    private String insertSelectiveStatementId;


    private String deleteByPrimaryKeyStatementId;


    private String updateByPrimaryKeyStatementId;


    private String updateByPrimaryKeySelectiveStatementId;


    private String selectByPrimaryKeyStatementId;


    private String selectListStatementId;


}
