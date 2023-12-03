package com.example.demo.CronJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class ScheduledTasks {
    @Scheduled(cron = "0 0 7 * * ?")
    public void myTask1() {
        log.info("Scheduled task executed at " + new Date());
    }
}
