package com.linln.component.shiro.config;



import java.lang.annotation.*;
/**
 * @Author zhaomengxia
 * @create 2019/5/9 9:58
 */
@Target({ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface CurrentUser {
}
