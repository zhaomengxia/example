package com.linln.modules.system.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/4/28 11:37
 */
@Data
public class District {
    private String name;
    private String code;

    private List<District> districts;

    public District(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public District() {
    }
}
