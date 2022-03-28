package com.automation.mobile.core.execution;

import com.automation.mobile.core.execution.banner.BannerExecutioner;
import com.automation.mobile.entities.Banner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutionManager {

    public static ExecutorService threadPool;

    private static ExecutionManager _executionManager = null;

    public static ExecutionManager getInstance() {

        if (ExecutionManager._executionManager == null) {

            ExecutionManager._executionManager = new ExecutionManager();
        }
        return ExecutionManager._executionManager;
    }

    public void StartBannerExecution(List<Banner> bannerList) {
        try {

            threadPool = Executors.newFixedThreadPool(bannerList.size());

            for (Banner banner : bannerList) {

                BannerExecutioner bannerExecutioner = new BannerExecutioner(banner);

                threadPool.submit(bannerExecutioner);
            }

            threadPool.shutdown();

            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}
