package com.distichain.test.job;

import com.distichain.test.manager.ProductManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class ProductJob {

    private ProductManager productManager;

    @Autowired
    public ProductJob(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Scheduled(fixedDelayString = "${job.time.refreshCache}")
    public void start() {
        log.info("Start refresh cache at {}", LocalDateTime.now());
        productManager.refreshCache();
        log.info("End refresh cache at {}", LocalDateTime.now());
    }
}
