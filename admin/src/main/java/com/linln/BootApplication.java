package com.linln;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 小笨笨
 * @date 2018/8/14
 */
@SpringBootApplication
@EnableJpaAuditing // 使用jpa自动赋值
@EnableCaching // 开启缓存
@EnableSwagger2
@Slf4j
public class BootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(BootApplication.class, args);
        Environment environment=applicationContext.getEnvironment();
        log.info("\n-----------------------------------------------\n\t"+
                "BootApplication is running! Access URLs:\n\t"+
                "Doc: \thttp://localhost:{}/api/swagger-ui.html#\n"+
        "---------------------------------------------------------\n",environment.getProperty("server.port"));

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }
}
