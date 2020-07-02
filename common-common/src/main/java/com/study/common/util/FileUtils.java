package com.study.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {

    }

    public byte[] toBytes(InputStream in) {
        byte[] bytes = null;
        if (in == null) {
            throw new IllegalArgumentException("InputStream argument cannot be null.");
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream(512);
            byte[] buffer = new byte[512];

            try {
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                bytes = out.toByteArray();
            } catch (IOException e) {
                logger.error("将文件转换成字节数据失败！", e);
            } finally {

                try {
                    in.close();
                } catch (IOException var17) {
                }
                try {
                    out.close();
                } catch (IOException var16) {
                }
            }

            return bytes;
        }
    }
}
