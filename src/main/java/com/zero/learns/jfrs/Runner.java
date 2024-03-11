package com.zero.learns.jfrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    static Map<Integer, List> map = new HashMap<>();

    public static void main(String[] args) {
        incrMemmory(1000);
    }

    private static void incrMemmory(int size) {
        for (int i = 0; i < 100; i++) {
            map.put(i, new ArrayList(size));
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
