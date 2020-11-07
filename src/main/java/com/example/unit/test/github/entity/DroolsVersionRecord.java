package com.example.unit.test.github.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class DroolsVersionRecord {
    private Long id;

    private Byte type;

    private Long userid;

    private String username;

    private String drlversion;

    private Date inserttime;

    private Date updatetime;

    private Boolean isactive;
}