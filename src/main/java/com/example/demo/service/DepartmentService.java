package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.entity.Student;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.view.Response;
import com.example.demo.view.ResponseBuilder;
//import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;
//    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository1) {
        this.departmentRepository = departmentRepository;

        this.studentRepository = studentRepository1;
//        this.modelMapper = modelMapper;
    }
    public Response CreateDepartment(Department department) {
        try {
            department = departmentRepository.save(department);
            if(Objects.isNull(department)) {
                return ResponseBuilder.getFailureResponse(HttpStatus.CONFLICT,"product creation time error");
            }

     return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Department Created successfully",department);

        } catch(Exception e) {
            return ResponseBuilder.getFailureResponse(HttpStatus.CONFLICT,e.getMessage());
        }

    }
    public Response CreateStudent(Integer id,Student student) {
        try {
         Integer a = 1;

            Optional<Department> department = departmentRepository.findById(id);
            if(Objects.isNull(department.isPresent())) {
                return ResponseBuilder.getFailureResponse(HttpStatus.CONFLICT,"student creation time error");
            }

            Department  updatableDepartment = department.get();

            updatableDepartment.getStudents().add(student);
            departmentRepository.save(updatableDepartment);

            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Student Created successfully",department);

        } catch(Exception e) {
            return ResponseBuilder.getFailureResponse(HttpStatus.CONFLICT,e.getMessage());
        }

    }
    public Response UpdateStudent(Student student) {
        try {



            if(!Objects.isNull(student)) {
                Optional<Student> student1 = studentRepository.findById(student.getId());

                if(student1.isPresent()){
                    Student  updatableStudent = student1.get();

//                    modelMapper.map(student,updatableStudent);
                    updatableStudent.setName(student.getName());

                    updatableStudent =    studentRepository.save(updatableStudent);
                    if(!Objects.isNull(updatableStudent)) {
                        return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Student updated", updatableStudent);
                    }

                }
            }

            return null;
        } catch(Exception e) {
            return ResponseBuilder.getFailureResponse(HttpStatus.CONFLICT,e.getMessage());
        }

    }

}
