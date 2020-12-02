package com.example.unit.test.github.redissonCache.dto;

import com.example.unit.test.github.redissonCache.dto.stereotype.TenantIdValid;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseReq {

    @TenantIdValid(message = "tenantId校验错误")
    private Long tenantId;

    /**
     * 注册来源
     */
    private String source;

    /**
     * 业务扩展信息,透传到MQ
     */
    private Object ext;
}
