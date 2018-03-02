package com.kakarot.plcenter;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.ReferenceConfig;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class PLReferenceConfigCache {

    public static final String DEFAULT_NAME = "_DEFAULT_";

    static final ConcurrentMap<String, PLReferenceConfigCache> cacheHolder = new ConcurrentHashMap<>();

    public static PLReferenceConfigCache getCache() {
        return getCache(DEFAULT_NAME);
    }

    public static PLReferenceConfigCache getCache(String name) {
        return getCache(name, DEFAULT_KEY_GENERATOR);
    }

    public static PLReferenceConfigCache getCache(String name, PLReferenceConfigCache.KeyGenerator keyGenerator) {
        PLReferenceConfigCache cache = cacheHolder.get(name);
        if(cache != null) {
            return cache;
        }
        cacheHolder.putIfAbsent(name, new PLReferenceConfigCache(name, keyGenerator));
        return cacheHolder.get(name);
    }

    public interface KeyGenerator {
        String generateKey(ReferenceConfig<?> referenceConfig);
    }


    public static final PLReferenceConfigCache.KeyGenerator DEFAULT_KEY_GENERATOR = referenceConfig -> {
        String iName = referenceConfig.getInterface();
        if(StringUtils.isBlank(iName)) {
            Class<?> clazz = referenceConfig.getInterfaceClass();
            iName = clazz.getName();
        }
        if(StringUtils.isBlank(iName)) {
            throw new IllegalArgumentException("No interface info in ReferenceConfig" + referenceConfig);
        }

        StringBuilder ret = new StringBuilder();
        if(! StringUtils.isBlank(referenceConfig.getGroup())) {
            ret.append(referenceConfig.getGroup()).append("/");
        }
        ret.append(iName);
        if(! StringUtils.isBlank(referenceConfig.getVersion())) {
            ret.append(":").append(referenceConfig.getVersion());
        }
        return ret.toString();
    };

    private final String name;
    private final PLReferenceConfigCache.KeyGenerator generator;

    ConcurrentMap<String, ReferenceConfig<?>> cache = new ConcurrentHashMap<>();

    private PLReferenceConfigCache(String name, PLReferenceConfigCache.KeyGenerator generator) {
        this.name = name;
        this.generator = generator;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(ReferenceConfig<T> referenceConfig) {
        String key = generator.generateKey(referenceConfig);

        ReferenceConfig<?> config = cache.get(key);
        if(config != null) {
            return (T) config.get();
        }

        cache.putIfAbsent(key, referenceConfig);
        config = cache.get(key);
        return (T) config.get();
    }

    public <T> void set(ReferenceConfig<T> referenceConfig) {
        String key = generator.generateKey(referenceConfig);
        cache.putIfAbsent(key, referenceConfig);
    }

    void destroyKey(String key) {
        ReferenceConfig<?> config = cache.remove(key);
        if(config == null) return;
        config.destroy();
    }

    /**
     * clear and destroy one {@link ReferenceConfig} in the cache.
     * @param referenceConfig use for create key.
     */
    public <T> void destroy(ReferenceConfig<T> referenceConfig) {
        String key = generator.generateKey(referenceConfig);
        destroyKey(key);
    }

    /**
     * clear and destroy all {@link ReferenceConfig} in the cache.
     */
    public void destroyAll() {
        Set<String> set = new HashSet<>(cache.keySet());
        set.forEach(this::destroyKey);
    }

    @Override
    public String toString() {
        return "PLReferenceConfigCache(name: " + name
                + ")";
    }
}
