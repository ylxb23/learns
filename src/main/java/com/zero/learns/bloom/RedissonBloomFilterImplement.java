package com.zero.learns.bloom;


import org.redisson.Redisson;
import org.redisson.RedissonBloomFilter;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.api.options.PlainOptions;
import org.redisson.config.Config;

/**
 * @author zero
 * @since 2024/5/8 15:40
 */
public class RedissonBloomFilterImplement {
    /**
     * 期望插入的元素总数量
     */
    private static final Integer EXPECT_INSERTIONS = 1000_0000;

    /**
     * 误判率
     */
    private static final Double EXPECT_ERROR_RATE = 0.01;

    private static final String REDIS_ADDRESS = "redis://127.0.0.1:6379";

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_ADDRESS);

        RedissonClient client = Redisson.create(config);
        // 初始化布隆过滤器
        RBloomFilter<String> redissonBloomFilter = client.getBloomFilter("bloom_filter::talking");
        redissonBloomFilter.tryInit(EXPECT_INSERTIONS, EXPECT_ERROR_RATE);

        redissonBloomFilter.add("Hello world");
        redissonBloomFilter.add("Hello earth");
        redissonBloomFilter.add("Hello moon");
        redissonBloomFilter.add("Hello sun");

        System.out.println("size: " + redissonBloomFilter.getSize());
        System.out.println("exists(Hello)?: " + redissonBloomFilter.contains("Hello"));
        System.out.println("exists(Hello world)?: " + redissonBloomFilter.contains("Hello world"));
        System.exit(0);
    }
}
