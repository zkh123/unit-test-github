package com.example.unit.test.github.redissonCache;

import com.alibaba.fastjson.JSON;
import com.example.unit.test.github.enums.ExceptionEnum;
import com.example.unit.test.github.exception.ExceptionCatch;
import com.example.unit.test.github.redissonCache.dto.VerifyCodeSignUpReq;
import com.example.unit.test.github.redissonCache.dto.stereotype.LoginTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis锁
 */
@Slf4j
@Service
public class LockOperation {

    @Resource
    private RedissonClient redissonClient;


    public void operate(){
        VerifyCodeSignUpReq signUpReq = new VerifyCodeSignUpReq();
        signUpReq.setTenantId(666666l);
        signUpReq.setAccountName("15711112222");
        signUpReq.setLoginType(LoginTypeEnum.Mobile);  // 手机 Mobile(1),

        String lockKey = String.format(RedisKeyUtil.LOCK_REG_USER_TEMPLATE, signUpReq.getTenantId(), signUpReq.getLoginType(), signUpReq.getAccountName());
        log.info("注册，{} , redis的key为： ", JSON.toJSONString(signUpReq), lockKey);
        RLock lock = redissonClient.getLock(lockKey);
        try {
            //尝试获取锁对象
            if (!lock.tryLock(10, TimeUnit.MINUTES)){
                log.error("抱歉 两次了{}" + lockKey);
                throw new ExceptionCatch(ExceptionEnum.SEND_REPEAT);
            }

            doSomething();

        }catch (Exception e){
            log.error("");
        }finally {
            lock.unlock();
        }
    }

    private void doSomething(){
        for (int i = 0 ; i < 20 ; i++){
            System.out.println("i="+i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
