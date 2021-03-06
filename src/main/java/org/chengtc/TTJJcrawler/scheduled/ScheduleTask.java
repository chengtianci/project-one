package org.chengtc.TTJJcrawler.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @name: TTJJTask
 * @description: 功能描述 - TTJJTask --
 * @author: chengtianci
 * @date: 2021/1/19 下午3:15
 */
@Component
@EnableScheduling   // 开启定时任务
public class ScheduleTask {

//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)`
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
