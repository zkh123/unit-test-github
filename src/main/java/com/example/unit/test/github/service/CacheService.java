package com.example.unit.test.github.service;

import com.example.unit.test.github.entity.DroolsVersionRecord;
import com.example.unit.test.github.mapper.DroolsVersionRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private DroolsVersionRecordMapper droolsVersionRecordMapper;

    public String testCache1(Long key){
        DroolsVersionRecord droolsVersionRecord = droolsVersionRecordMapper.selectByPrimaryKey(key);
        if (null != droolsVersionRecord){
            return droolsVersionRecord.getDrlversion();
        }else {
            return "";
        }
    }

    public DroolsVersionRecord testCache2(Long key){
        DroolsVersionRecord droolsVersionRecord = droolsVersionRecordMapper.selectByPrimaryKey(key);
        return droolsVersionRecord;
    }

}
