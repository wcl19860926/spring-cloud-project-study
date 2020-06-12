package com.study.generator.config;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class FileOutConfig {
    /**
     * 模板
     */
    private String templatePath;

    public FileOutConfig() {
        // to do nothing
    }

    public FileOutConfig(String templatePath) {
        this.templatePath = templatePath;
    }

    /**
     * 输出文件
     */
    public abstract String outputFile(TableInfo tableInfo);
}
