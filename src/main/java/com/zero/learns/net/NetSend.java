package com.zero.learns.net;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NetSend {

    private static Map<String, String> argMap = new HashMap<String, String>();

    private static final String KEY_HELP = "-H";
    private static final String KEY_TARGET = "-T";
    private static final String KEY_DATA_S = "-S";
    private static final String KEY_DATA_F = "-F";
    private static final String USAGE = "Usage: java com.zero.learns.net.NetSend [-H] <-T host:port> <[-S string] | [-F filePath]> \n" +
            "\t-H [optional] print help message and exit. \n" +
            "\t-T <required> target server address, assembly with host:port. \n" +
            "\t-S <optional or -F> send message with string. \n" +
            "\t-F <optional or -S> send message with file data. \n";

    public static void main(String[] args) {
        args2Map(args);
        printArgMap();
        validateArgMap();
        if(argMap.containsKey(KEY_HELP)) {
            printUsageAndExit();
        }

        Socket socket = new Socket();
    }

    private static void printUsageAndExit() {
        System.out.println(USAGE);
        System.exit(0);
    }

    private static final String PATTERN_TARGET = "/([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))(\\.([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))){3}:\\d{1,5}/";
    private static void validateArgMap() {
        String target = argMap.get(KEY_TARGET);
        if(target == null) {
            System.err.println("must with parameter: -T");
            printUsageAndExit();
        }
        if(Pattern.matches(PATTERN_TARGET, target)) {
            System.err.println("");
            printUsageAndExit();
        }
        String s = argMap.get(KEY_DATA_S);
        String f = argMap.get(KEY_DATA_F);
        if(s == null && f == null) {
            System.err.println("must with parameter -S or -F");
            printUsageAndExit();
        }

    }


    static void args2Map(String[] args) {
        String key=null;
        for(int i=0; i<args.length;) {
            key = args[i].trim();
            if(KEY_HELP.equals(key)) {
                argMap.put(key, "");
            } else {
                argMap.put(key, args[++i].trim());
            }
            i++;
        }
    }

    static void printArgMap() {
        for(Map.Entry<String, String> entry : argMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    static void print(String[] args) {
        for(int i=0; i<args.length; i++) {
            System.out.print(args[i].trim() + " ");
        }
        System.out.println();
    }
}
