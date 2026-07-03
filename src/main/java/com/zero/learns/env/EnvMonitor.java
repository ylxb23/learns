package com.zero.learns.env;

public class EnvMonitor {

    public static void main(String[] args) {
        while(true) {
            System.out.println("Get property GRAY_LABEL=" + System.getProperty("GRAY_LABEL"));
            System.out.println("Get env GRAY_LABEL=" + System.getenv("GRAY_LABEL"));
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                System.err.println("thread interrupted");
            }
        }
    }
}
