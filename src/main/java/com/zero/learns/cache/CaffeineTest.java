package com.zero.learns.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CaffeineTest {

    public static void main(String[] args) {
        // 基础Cache
        Cache<String, User> userCache = Caffeine.newBuilder()
                .maximumSize(3)    // 缓存最大数量
                .expireAfterWrite(5, TimeUnit.MINUTES)  // 写入后5分钟过期
                .build();
        // 预存缓存
        userCache.put("小二", UserService.getByName("小二"));
        // 获取缓存，如果缓存不存在则返回null
        User xiaoer = userCache.getIfPresent("小二");
        System.out.println("获取到缓存[小二]: " + xiaoer);
        // 获取缓存，如果缓存不存在则通过函数加载
        User load = userCache.get("小三", (key) -> {
            User loaded = UserService.getByName(key);
            // 防止穿透
            return Objects.requireNonNullElse(loaded, UserService.EMPTY_USER);
        });

        // LoadingCache
        LoadingCache<String, User> loadingCache = Caffeine.newBuilder()
                .maximumSize(3)
                .expireAfterWrite(5, TimeUnit.MINUTES)  // 加入缓存5分钟后过期
                .expireAfterAccess(1, TimeUnit.MINUTES) // 超过1分钟未访问则过期
                .expireAfter((key, value, expirationTime) -> {
                    // 返回过期时间戳
                    return Duration.of(3, TimeUnit.MINUTES.toChronoUnit());
                }) // 自定义过期时间
                .build(new CacheLoader<String, User>() {
                    @Override
                    public User load(String key) throws Exception {
                        User loaded = UserService.getByName(key);
                        // 防止穿透
                        return Objects.requireNonNullElse(loaded, UserService.EMPTY_USER);
                    }
                });
        // 获取缓存，可能加载缓存时异常
        try {
            User user = loadingCache.get("小三");
            System.out.println("获取缓存[小三]: " + user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
