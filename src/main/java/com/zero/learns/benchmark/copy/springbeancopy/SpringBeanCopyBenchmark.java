package com.zero.learns.benchmark.copy.springbeancopy;


import com.zero.learns.benchmark.copy.Student;
import com.zero.learns.benchmark.copy.StudentVo;
import com.zero.learns.benchmark.copy.Teacher;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zero.learns.springbeancopy.SpringBeanCopyBenchmark
 *
 * @author ylxb2
 * @since 2024/1/2 11:39
 */
@State(Scope.Benchmark)
public class SpringBeanCopyBenchmark {

    private Student student;
    private Teacher teacher;

    @Setup(Level.Trial)
    public void init() {
        student = new Student();
        student.setName("学生");
        student.setAge(15);
        student.setValid(true);
        List<String> hobbits = new ArrayList<>();
        hobbits.add("看书");
        hobbits.add("打篮球");
        hobbits.add("游泳");
        student.setHobbits(hobbits);

        this.teacher = new Teacher();
        teacher.setName("老师");
        teacher.setAge(35);
    }


    @Benchmark
    @OperationsPerInvocation()
    public void test() {
        StudentVo vo = new StudentVo();
        BeanUtils.copyProperties(student, vo);
        vo.setMyName(student.getName());
        vo.setTeacherName(teacher.getName());
    }


    @TearDown(Level.Trial)
    public void destory() {
        student = null;
        teacher = null;
    }
}
