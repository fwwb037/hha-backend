package com.bin.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tageshi
 * @date 2023/3/15 15:17
 */
@EnableDubbo
@SpringBootApplication
@EnableScheduling
public class hhaUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(hhaUserConsumerApplication.class, args);
    }
}
