package com.linln.admin.test.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author 小笨笨
 * @date 2019/05/09
 */
@Data
public class TestValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
    @NotEmpty(message = "备注不能为空")
    private String remark;
}