package com.zero.learns.cache;

import com.github.benmanes.caffeine.cache.Expiry;

public class ExpiryOfDataOffline implements Expiry {
    @Override
    public long expireAfterCreate(Object key, Object value, long currentTime) {
        return 0;
    }

    @Override
    public long expireAfterUpdate(Object key, Object value, long currentTime, long currentDuration) {
        return 0;
    }

    @Override
    public long expireAfterRead(Object key, Object value, long currentTime, long currentDuration) {
        return 0;
    }
}
