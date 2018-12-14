package com.learn.testspring;

import com.yonghui.common.redis.YhRedisConfiguration;
import com.yonghui.consul.YhConsulConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import({YhConsulConfig.class,YhRedisConfiguration.class})
@SpringBootApplication
@EnableAutoConfiguration
public class TestspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringApplication.class, args);
    }


}

