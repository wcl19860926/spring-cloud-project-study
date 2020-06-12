package com.study.generator.context;

import com.study.generator.jdbc.config.*;
import com.study.generator.config.FileOutConfig;
import com.study.generator.config.TemplateConfig;

import java.util.List;

public class Context {

    private String beginningDelimiter;

    private String endingDelimiter;

    public static TemplateConfig getTemplateConfig() {
        return null;
    }

    public static List<FileOutConfig> getFileOutConfig() {
        return  null;
    }

    public JavaTypeResolverConfiguration getJavaTypeResolverConfiguration() {
        return new JavaTypeResolverConfiguration();
    }

    public ConnectionFactoryConfiguration getConnectionFactoryConfiguration() {
        return null;
    }

    public String getBeginningDelimiter() {
        return beginningDelimiter;
    }

    public String getEndingDelimiter() {
        return endingDelimiter;
    }

    public JavaModelGeneratorConfiguration getJavaModelGeneratorConfiguration() {
        return null;
    }

    public JavaClientGeneratorConfiguration getJavaClientGeneratorConfiguration() {
        return null;
    }

    public SqlMapGeneratorConfiguration getSqlMapGeneratorConfiguration() {
        return null;
    }

    public String getTargetRuntime() {
        return null;
    }

    public String getIntrospectedColumnImpl() {
        return null;
    }

    public boolean autoDelimitKeywords() {
        return true;
    }
}
