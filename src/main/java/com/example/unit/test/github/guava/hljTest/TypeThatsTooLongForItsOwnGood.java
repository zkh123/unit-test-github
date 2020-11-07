package com.example.unit.test.github.guava.hljTest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TypeThatsTooLongForItsOwnGood {
    private String username;
    private Integer age;

    public TypeThatsTooLongForItsOwnGood(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public TypeThatsTooLongForItsOwnGood() {
    }
}
