package com.lockcoin.locktmall.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author tangwenbo
 * @date 2018/2/6
 * @since JDK1.8
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeTask() {
        System.out.println("异步任务");
    }
}
