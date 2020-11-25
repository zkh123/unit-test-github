package com.example.unit.test.github.test;

public class BaseReq {
    private Long tenantId;
    private String source;
    private Object ext;

    public BaseReq() {
    }

    public Long getTenantId() {
        return this.tenantId;
    }

    public String getSource() {
        return this.source;
    }

    public Object getExt() {
        return this.ext;
    }

    public BaseReq setTenantId(final Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public BaseReq setSource(final String source) {
        this.source = source;
        return this;
    }

    public BaseReq setExt(final Object ext) {
        this.ext = ext;
        return this;
    }
}
