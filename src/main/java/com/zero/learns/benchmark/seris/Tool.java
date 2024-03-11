package com.zero.learns.benchmark.seris;

import java.util.Random;

/**
 * com.zero.learns.com.zero.learns.seris.Tool
 *
 * @author ylxb2
 * @since 2024/1/18 14:27
 */
public class Tool {

    static String[] types = new String[] {"int", "boolean", "long", "double", "char", "float", "String", "String"};

    public static void main(String[] args) {
        int n = 21;

        for(int i=0; i<n; i++) {
            String ct = types[new Random().nextInt(types.length)];
            System.out.println("    private " + ct + " value" + (i+1) + ";");
        }
    }
}
