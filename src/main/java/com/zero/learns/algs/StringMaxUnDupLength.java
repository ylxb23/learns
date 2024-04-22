package com.zero.learns.algs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最长无重复子串
 */
public class StringMaxUnDupLength {

    public static void main(String[] args) {
        String[] srcs = new String[]{"abcdabade", "a", "abc", "aba", "abcdedssdasd", "jkkkkk", "mmmmmm"};
        for(String src : srcs) {
            System.out.println("max unDup substring of '" + src + "' length: " + maxUnDupSubStringLength(src) + ", max substring is: " + maxUnDupSubString(src));
        }
    }

    /**
     * 最大无重复字串长度
     * @param src
     * @return
     */
    public static int maxUnDupSubStringLength(String src) {
        int max = 0;
        if(src == null || src.isEmpty()) {
            return max;
        }
        int maxDupIdx = -1;
        Map<Character, Integer> cLastIdx = new HashMap<>();
        for(int i=0; i<src.length(); i++) {
            char c = src.charAt(i);
            Integer idx = cLastIdx.get(c);
            if(idx == null) {
                max = i - maxDupIdx;
            } else {
                maxDupIdx = Math.max(maxDupIdx, idx);
                max = Math.max(max, i-idx);
            }
            cLastIdx.put(c, i);
        }
        return max;
    }

    /**
     * 最长无重复字串
     * @param src
     * @return
     */
    public static String maxUnDupSubString(String src) {
        if(src == null || src.length() < 2) {
            return src;
        }
        int max = 0;
        int maxDupIdx = -1;
        String maxUnDupSubString = "";
        Map<Character, Integer> cLastIdx = new HashMap<>();
        for(int i=0; i<src.length(); i++) {
            char c = src.charAt(i);
            Integer idx = cLastIdx.get(c);
            if(idx == null) {
                max = i - maxDupIdx;
                maxUnDupSubString = src.substring(maxDupIdx+1, i+1);
            } else {
                maxDupIdx = Math.max(maxDupIdx, idx);
                if(max < i - idx) {
                    max = i - idx;
                    maxUnDupSubString = src.substring(idx+1, i+1);
                }
            }
            cLastIdx.put(c, i);
        }
        return maxUnDupSubString;
    }
}
