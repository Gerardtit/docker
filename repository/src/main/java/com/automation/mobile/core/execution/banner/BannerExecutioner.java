package com.automation.mobile.core.execution.banner;

import com.automation.mobile.entities.Banner;

public class BannerExecutioner extends Thread {

    private Banner banner;

    public BannerExecutioner(Banner pBanner) {

        this.banner = pBanner;
    }

    @Override
    public void run() {

        BannerProcessor bannerProcessor = new BannerProcessor(banner);

        try {

            bannerProcessor.start();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
