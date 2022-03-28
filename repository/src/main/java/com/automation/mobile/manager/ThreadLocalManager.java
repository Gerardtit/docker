package com.automation.mobile.manager;

import com.automation.mobile.models.Feature;

public class ThreadLocalManager {

    public static ThreadLocal<Feature> feature = new ThreadLocal<>();
}
