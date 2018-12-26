package com.hugo.stock.boot;

import com.hugo.stock.task.MyStockUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockBootStrap implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动调用请求");
        new MyStockUpdate().task();
    }
}
