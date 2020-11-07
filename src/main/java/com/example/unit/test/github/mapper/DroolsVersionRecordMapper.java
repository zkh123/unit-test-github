package com.example.unit.test.github.mapper;

import com.example.unit.test.github.entity.DroolsVersionRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DroolsVersionRecordMapper {
    int insert(DroolsVersionRecord record);
    DroolsVersionRecord selectByPrimaryKey(Long id);


}