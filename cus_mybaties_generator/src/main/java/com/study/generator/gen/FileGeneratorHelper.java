package com.study.generator.gen;

import com.study.generator.jdbc.FullyQualifiedTable;
import com.study.generator.jdbc.introspect.IntrospectedColumn;
import com.study.generator.jdbc.introspect.IntrospectedTable;
import com.study.generator.jdbc.java.FullyQualifiedJavaType;
import com.study.generator.model.ColumnInfo;
import com.study.generator.model.TableInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import static com.study.generator.util.message.Messages.getString;

public class FileGeneratorHelper {


    public static TableInfo transferToTableInfo(IntrospectedTable introspectedTable) {
        TableInfo   tableInfo  =  new TableInfo();
        FullyQualifiedTable fullyQualifiedTable   = introspectedTable.getFullyQualifiedTable();
        tableInfo.setTableName(fullyQualifiedTable.getIntrospectedTableName());
        tableInfo.setDomainName(fullyQualifiedTable.getDomainObjectName());
        tableInfo.setColumns( getColumnInfo(introspectedTable.getBaseColumns()));
        tableInfo.setKeyColumns(getColumnInfo(introspectedTable.getPrimaryKeyColumns()));
        tableInfo.setBaseResultMapId(introspectedTable.getBaseResultMapId());
        tableInfo.setDomainType(introspectedTable.getBaseRecordType());
        tableInfo.setXmlFileName(introspectedTable.getMyBatis3XmlMapperFileName());
        tableInfo.setXmlFileNameSpace(introspectedTable.getMyBatis3FallbackSqlMapNamespace());
        tableInfo.setJavaMapperType(introspectedTable.getMyBatis3JavaMapperType());
        tableInfo.setInsertStatementId(introspectedTable.getInsertStatementId());
        tableInfo.setInsertSelectiveStatementId(introspectedTable.getInsertSelectiveStatementId());
        tableInfo.setDeleteByPrimaryKeyStatementId(introspectedTable.getDeleteByPrimaryKeyStatementId());
        tableInfo.setUpdateByPrimaryKeySelectiveStatementId(introspectedTable.getUpdateByPrimaryKeySelectiveStatementId());
        tableInfo.setUpdateByPrimaryKeyStatementId(introspectedTable.getUpdateByPrimaryKeyStatementId());
        tableInfo.setSelectByPrimaryKeyStatementId(introspectedTable.getSelectByPrimaryKeyStatementId());
        tableInfo.setSelectListStatementId(introspectedTable.getSelectListStatementId());
        tableInfo.setJavaEntityPackage(introspectedTable.getEntityPackage());
        tableInfo.setJavaEntityTargetProject(introspectedTable.getEntityProject());
        tableInfo.setXmlTargetPackage(introspectedTable.getXmlPackage());
        tableInfo.setXmlTargetProject(introspectedTable.getXmlProject());
        tableInfo.setJavaMapperPackage(introspectedTable.getJavaPackage());
        tableInfo.setJavaMapperTargetProject(introspectedTable.getJavaProject());

        return   tableInfo;
    }

    private static List<ColumnInfo>  getColumnInfo(  List<IntrospectedColumn> baseColumns) {
        ColumnInfo columnInfo;
        List<ColumnInfo>  columnInfos  = new ArrayList<>();
        FullyQualifiedJavaType qualifiedJavaType  =null;
        for(IntrospectedColumn   introspectedColumn  :baseColumns  ){
            columnInfo  = new  ColumnInfo();
            columnInfo.setColumnName(introspectedColumn.getActualColumnName());
            columnInfo.setPropertyName(introspectedColumn.getJavaProperty());
            columnInfo.setComment(introspectedColumn.getRemarks());
            columnInfo.setJdbcType(introspectedColumn.getJdbcTypeName());
            qualifiedJavaType  = introspectedColumn.getFullyQualifiedJavaType();
            columnInfo.setJavaTypeFullName(qualifiedJavaType.getFullyQualifiedName());
            columnInfo.setJavaTypePackageName(qualifiedJavaType.getPackageName());
            columnInfo.setJavaTypeShortName(qualifiedJavaType.getShortName());
            columnInfos.add(columnInfo);
        }
        return  columnInfos;
    }


    public static void generator(TableInfo tableInfoList) {


    }


    private void writeGeneratedJavaFile(List<String> warnings)
            throws InterruptedException, IOException {
        File targetFile;
        String source = null;
        try {
            File directory = null;
            targetFile = getUniqueFileName(directory, "");
            warnings.add(getString(
                    "Warning.2", targetFile.getAbsolutePath())); //$NON-NLS-1$


            writeFile(targetFile, source, "UTF-8");
        } catch (Exception e) {
            warnings.add(e.getMessage());
        }
    }


    /**
     * Writes, or overwrites, the contents of the specified file.
     *
     * @param file         the file
     * @param content      the content
     * @param fileEncoding the file encoding
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void writeFile(File file, String content, String fileEncoding) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, false);
        OutputStreamWriter osw;
        if (fileEncoding == null) {
            osw = new OutputStreamWriter(fos);
        } else {
            osw = new OutputStreamWriter(fos, fileEncoding);
        }

        try (BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(content);
        }
    }

    /**
     * Gets the unique file name.
     *
     * @param directory the directory
     * @param fileName  the file name
     * @return the unique file name
     */
    private File getUniqueFileName(File directory, String fileName) {
        File answer = null;

        // try up to 1000 times to generate a unique file name
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 1000; i++) {
            sb.setLength(0);
            sb.append(fileName);
            sb.append('.');
            sb.append(i);

            File testFile = new File(directory, sb.toString());
            if (!testFile.exists()) {
                answer = testFile;
                break;
            }
        }

        if (answer == null) {
            throw new RuntimeException(getString(
                    "RuntimeError.3", directory.getAbsolutePath())); //$NON-NLS-1$
        }

        return answer;
    }



}
