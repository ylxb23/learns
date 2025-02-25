package com.zero.learns.beans;

import org.springframework.stereotype.Component;

/**
 * @author zero
 * @since 2024/11/13 16:34
 */
@Component
class ManService {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
