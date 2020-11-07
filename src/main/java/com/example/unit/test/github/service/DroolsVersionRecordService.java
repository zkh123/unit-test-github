package com.example.unit.test.github.service;

import com.example.unit.test.github.entity.DroolsVersionRecord;
import com.example.unit.test.github.mapper.DroolsVersionRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsVersionRecordService {

    @Autowired
    private DroolsVersionRecordMapper droolsVersionRecordMapper;

    public DroolsVersionRecord selectByPrimaryKey(Long id){
        return droolsVersionRecordMapper.selectByPrimaryKey(id);
    }

}
