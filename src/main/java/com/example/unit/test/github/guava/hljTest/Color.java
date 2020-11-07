package com.example.unit.test.github.guava.hljTest;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Color {
    private String a;
    private String b;
    private String c;

    public Color(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
