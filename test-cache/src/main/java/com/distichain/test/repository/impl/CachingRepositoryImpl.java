package com.distichain.test.repository.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.repository.CachingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class CachingRepositoryImpl implements CachingRepository {

    private RedisTemplate redisTemplate;

    @Autowired
    public CachingRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(String code, ProductBo product) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(code, product);
    }

    @Override
    public ProductBo find(String code) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return (ProductBo) valueOperations.get(code);
    }
}
