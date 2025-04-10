package com.zero.learns.jmx;

import java.time.Duration;
import java.util.Random;

public class TokenUsageCounter extends Thread {
    private final TokenUsageMBean tokenUsageMBean;

    public TokenUsageCounter(TokenUsageMBean tokenUsageMBean) {
        this.tokenUsageMBean = tokenUsageMBean;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.tokenUsageMBean.setUsed(new Random().nextLong() + 100L);
        }
    }
}
