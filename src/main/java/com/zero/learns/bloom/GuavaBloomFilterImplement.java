package com.zero.learns.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * 布隆过滤器，仅判断一定不存在和可能存在
 * @author zero
 * @since 2024/5/8 15:48
 */
public class GuavaBloomFilterImplement {
    /**
     * 期望插入的元素总数量
     */
    private static final Integer EXPECT_INSERTIONS = 1000_0000;

    /**
     * 误判率
     */
    private static final Double EXPECT_ERROR_RATE = 0.01;

    private static BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), EXPECT_INSERTIONS, EXPECT_ERROR_RATE);

    public static void main(String[] args) {
        // 插入数据
        bloomFilter.put("Hello world");

        // 判断元素是否存在
        boolean notExists = bloomFilter.mightContain("Hello");
        boolean exists = bloomFilter.mightContain("Hello world");

        System.out.println("exists(Hello)?: " + notExists + ", exists(Hello world)?: " + exists);
    }
}
