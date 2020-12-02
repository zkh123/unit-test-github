package com.example.unit.test.github.controller;

import com.example.unit.test.github.good.constant.ResponseConstant;
import com.example.unit.test.github.good.response.MobiContentResponse;
import com.example.unit.test.github.redissonCache.LockOperation;
import com.example.unit.test.github.redissonCache.RedisRedisTemplateOperation;
import com.example.unit.test.github.redissonCache.RedisStringRedisTemplateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "redissonCache")
@RestController
public class RedissonCacheController {

    @Autowired
    private LockOperation lockOperation;

    @Autowired
    private RedisStringRedisTemplateOperation redisStringRedisTemplateOperation;

    @Autowired
    private RedisRedisTemplateOperation redisRedisTemplateOperation;

    /**
     * http://localhost:8099/redissonCache/stringRedisTemplate/lockOperation
     * @return
     */
    @GetMapping(value = "stringRedisTemplate/lockOperation")
    public MobiContentResponse LockOperation(){
        MobiContentResponse mobiContentResponse = new MobiContentResponse();
        lockOperation.operate();
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        return mobiContentResponse;
    }


    /**
     * http://localhost:8099/redissonCache/stringRedisTemplate/operateSet?code=yyyyyy&mobile=15712128989
     * @param code
     * @param mobile
     * @return
     */
    @GetMapping(value = "stringRedisTemplate/operateSet")
    public MobiContentResponse operateSet(@RequestParam(value = "code") String code,
                                          @RequestParam(value = "mobile") long mobile){
        MobiContentResponse mobiContentResponse = new MobiContentResponse();
        redisStringRedisTemplateOperation.operateSet(code,mobile);
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        return mobiContentResponse;
    }


    /**
     * http://localhost:8099/redissonCache/stringRedisTemplate/operateGet?mobile=15712128989
     * @param mobile
     * @return
     */
    @GetMapping(value = "stringRedisTemplate/operateGet")
    public MobiContentResponse OperateGet(@RequestParam(value = "mobile") long mobile){
        MobiContentResponse mobiContentResponse = new MobiContentResponse();
        String data = redisStringRedisTemplateOperation.operateGet(mobile);
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        mobiContentResponse.setContent(data);
        return mobiContentResponse;
    }




    /**
     * http://localhost:8099/redissonCache/redisTemplate/operateSet?code=bbb&mobile=15712123466
     * @param code
     * @param mobile
     * @return
     */
    @GetMapping(value = "redisTemplate/operateSet")
    public MobiContentResponse redisTemplateOperateSet(@RequestParam(value = "code") String code,
                                          @RequestParam(value = "mobile") long mobile){
        MobiContentResponse mobiContentResponse = new MobiContentResponse();
        redisRedisTemplateOperation.operateSet(code,mobile);
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        return mobiContentResponse;
    }

    /**
     * http://localhost:8099/redissonCache/redisTemplate/operateGet?mobile=15712123466
     * @param mobile
     * @return
     */
    @GetMapping(value = "redisTemplate/operateGet")
    public MobiContentResponse redisTemplateOperateGet(@RequestParam(value = "mobile") long mobile){
        MobiContentResponse mobiContentResponse = new MobiContentResponse();
        String data = redisRedisTemplateOperation.operateGet(mobile);
        mobiContentResponse.setResultMessage(ResponseConstant.SUCCESS_VALUE);
        mobiContentResponse.setContent(data);
        return mobiContentResponse;
    }

}
