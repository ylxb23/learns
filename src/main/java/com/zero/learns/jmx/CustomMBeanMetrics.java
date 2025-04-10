package com.zero.learns.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CustomMBeanMetrics {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        int mBeanCount = mBeanServer.getMBeanCount();
        System.out.println("mBean count: " + mBeanCount);
        System.out.println("default domain: " + mBeanServer.getDefaultDomain());
        System.out.println("domains: " + Arrays.toString(mBeanServer.getDomains()));

        ObjectName tokenObjectName = new ObjectName("com.zero.usage.token:type=tokenUsage");
        TokenUsageMXBean tokenUsageMXBean = new TokenUsageMXBean(tokenObjectName);
        tokenUsageMXBean.setTotal(1000L);
        new TokenUsageCounter(tokenUsageMXBean).start();    // start custom mbean counter
        // register mxbean
        mBeanServer.registerMBean(tokenUsageMXBean, tokenObjectName);

        List<TokenUsageMBean> customMBeans = ManagementFactory.getPlatformMXBeans(TokenUsageMBean.class);
        if(!customMBeans.isEmpty()) {
            TokenUsageMBean tokenUsageMBean = customMBeans.get(0);
            for(int i=0; i < 10; i++) {
                Thread.sleep(1000L);
                System.out.printf("custom token usage MXBean, total: %d, used: %d \n", tokenUsageMBean.getTotal(), tokenUsageMBean.getUsed());
            }
        }

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.printf("Heap memory usage: %s, Non Heap memory usage: %s \n", memoryMXBean.getHeapMemoryUsage(), memoryMXBean.getNonHeapMemoryUsage());
        System.gc();
        System.out.printf("Heap memory usage: %s, Non Heap memory usage: %s \n", memoryMXBean.getHeapMemoryUsage(), memoryMXBean.getNonHeapMemoryUsage());

        List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
        for (MemoryManagerMXBean memoryManagerMXBean : memoryManagerMXBeans) {
            System.out.printf("Memory Manager mx beans: %s \n", Arrays.toString(memoryManagerMXBean.getMemoryPoolNames()));
        }

    }
}
