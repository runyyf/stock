package com.hugo.stock.quartz;

import com.hugo.stock.task.MyStockUpdate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MinQuartzJob {
    @Scheduled(cron = "0 0/3 9,10,11,13,14 ? * MON-FRI")
    public void scheduledTask(){
        new MyStockUpdate().task();
    }
}
