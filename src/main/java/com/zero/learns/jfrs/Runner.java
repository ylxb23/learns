package com.zero.learns.jfrs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jvm: -Xmx256m -Xms32m -XX:+HeapDumpOnOutOfMemoryError
 *      -XX:StartFlightRecording=disk=true,dumponexit=true,filename=jfr-recording.jfr,maxsize=1024m,maxage=1d,settings=profile
 *      jfr: path-to-gc-roots=true 不建议开启
 */
public class Runner {

    static Map<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        int size = 10000;
        if(args.length > 1) {
            size = Integer.parseInt(args[0]);
        }
        incrMemmory(size);
    }

    private static void incrMemmory(int size) {
        for (int i = 0; ; i++) {
            map.put(i, new ArrayList<>(size));
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
