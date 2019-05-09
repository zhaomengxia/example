package com.linln.admin.order.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 小笨笨
 * @date 2019/05/09
 */
@Data
public class TestValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
    @NotNull(message = "创建者不能为空")
    private Object createBy;
}