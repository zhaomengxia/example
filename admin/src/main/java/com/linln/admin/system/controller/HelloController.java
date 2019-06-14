package com.linln.admin.system.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @Author zhaomengxia
 * @create 2019/6/13 16:08
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String set(HttpSession session){
        session.setAttribute("user","javaboy");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session){

        return session.getAttribute("user")+":"+port;
    }


}
