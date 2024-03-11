package com.zero.learns.benchmark.copy.mapstruct;

import com.zero.learns.benchmark.copy.Student;
import com.zero.learns.benchmark.copy.Teacher;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zero.learns.mapstruct.MapStructBenchmark
 *
 * @author ylxb2
 * @since 2024/1/2 11:25
 */
@State(Scope.Benchmark)
public class MapStructBenchmark {

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
    }

    @Benchmark
    @OperationsPerInvocation()
    public void test() {
        StudentMapper.MAPPER.toStudentVo(student, teacher);
    }

    @TearDown(Level.Trial)
    public void destory() {
        student = null;
        teacher = null;
    }
}
