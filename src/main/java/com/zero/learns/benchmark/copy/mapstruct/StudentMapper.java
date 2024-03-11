package com.zero.learns.benchmark.copy.mapstruct;

import com.zero.learns.benchmark.copy.Student;
import com.zero.learns.benchmark.copy.StudentVo;
import com.zero.learns.benchmark.copy.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * org.zero.test.benchmark.mapper.StudentMapper
 *
 * @author ylxb2
 * @since 2024/1/2 9:44
 */
@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(source = "teacher.name", target = "teacherName"),
            @Mapping(source = "student.name", target = "myName"),
            @Mapping(source = "student.age", target = "age"),
            @Mapping(source = "student.valid", target = "valid"),
            @Mapping(source = "student.hobbits", target = "hobbits")
    })
    StudentVo toStudentVo(Student student, Teacher teacher);
}
