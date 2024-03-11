package com.zero.learns.benchmark.copy;

import java.util.List;

/**
 * org.zero.test.benchmark.mapper.StudentVo
 *
 * @author ylxb2
 * @since 2024/1/2 9:43
 */
public class StudentVo {
    private String teacherName;
    private String myName;
    private int age;
    private boolean valid;
    private List<String> hobbits;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
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
