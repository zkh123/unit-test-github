package com.example.unit.test.github.redissonCache;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * redis缓存
 */
@Slf4j
@Service
public class RedisStringRedisTemplateOperation {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final long TENANT_ID = 777777l;

    private static final String MESSAGE_ID = "777_messageId_stringRedisTemplate";

    /**
     * 缓存内容 (设置过期时间)
     * @param code
     * @param mobile
     */
    public void operateSet(String code,long mobile){
        String redisKey = String.format(RedisKeyUtil.REDIS_REG_USER_TEMPLATE, RedisStringRedisTemplateOperation.TENANT_ID, String.valueOf(mobile));

        VerifyCodeContent verifyCodeContent  = new VerifyCodeContent();
        verifyCodeContent.code = code;
        verifyCodeContent.messageId = RedisStringRedisTemplateOperation.MESSAGE_ID;

//        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSONString(verifyCodeContent), Duration.ofSeconds(10000));
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSONString(verifyCodeContent), 2000l);

        log.info("stringRedisTemplate operateSet result: {}, redisKey={}" , "success",redisKey);
    }

    /**
     * 读取缓存
     * @param mobile
     */
    public String operateGet(long mobile){
        String redisKey = String.format(RedisKeyUtil.REDIS_REG_USER_TEMPLATE, RedisStringRedisTemplateOperation.TENANT_ID, String.valueOf(mobile));

        String data = stringRedisTemplate.opsForValue().get(redisKey);

        log.info("stringRedisTemplate operateSet result: {}, redisKey={}, data={}" , "success",redisKey,data);

        return data;
    }

    static class VerifyCodeContent {
        private String code;
        private String messageId;
    }

}
