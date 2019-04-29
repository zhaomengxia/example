package com.linln.devtools.generate.utils;

import lombok.Data;

/**
 * @Author zhaomengxia
 * @create 2019/4/28 11:18
 */
@Data
public class UploadResponse {
    private String filename;
    private String url;

    public UploadResponse(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }
}
