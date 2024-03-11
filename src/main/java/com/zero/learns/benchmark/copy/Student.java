package com.zero.learns.benchmark.copy;

import java.util.List;

/**
 * org.zero.test.benchmark.mapper.Student
 *
 * @author ylxb2
 * @since 2024/1/2 9:41
 */
public class Student {
    private String name;
    private int age;
    private boolean valid;
    private List<String> hobbits;

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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getHobbits() {
        return hobbits;
    }

    public void setHobbits(List<String> hobbits) {
        this.hobbits = hobbits;
    }
}
