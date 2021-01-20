package org.chengtc.TTJJcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @name: Application
 * @description: 功能描述 - Application --
 * @author: chengtianci
 * @date: 2021/1/19 下午2:50
 */
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
