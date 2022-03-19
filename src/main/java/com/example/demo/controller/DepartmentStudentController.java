package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Student;
import com.example.demo.service.DepartmentService;
import com.example.demo.view.Response;
import com.example.demo.view.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
public class DepartmentStudentController {

    private final DepartmentService departmentService;

    public DepartmentStudentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("departments")
    public Response createDepartment(@RequestBody Department department) {
        return departmentService.CreateDepartment(department);
    }

    @PostMapping("students/{id}")
    public Response createStudent(@PathVariable Integer id,@RequestBody Student student) {

       return departmentService.CreateStudent(id, student);
    }
    @PutMapping ("students/")
    public Response updateStudent(@PathVariable Integer departmentId,@PathVariable Integer studentId,@RequestBody Student student) {

        return departmentService.UpdateStudent(student);
    }

    @PostMapping ("upload2/")
    public Response fileUpload2( @RequestParam("file") MultipartFile file)throws IOException  {

        final Path root = Paths.get("B:\\final E-commerce project\\E_Commerce\\products");
       long size = file.getSize();
       Long fileSize = size / (1024 * 1024);
        if (fileSize > Long.parseLong(String.valueOf(100))) {//this logic only workable for offline not online
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_ACCEPTABLE, "File size should be less then 100 MB");
        }
        if(!Files.exists(root)){
            try {
                Files.createDirectories(root);//create Directories in our system OS
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
        //we already have Directories now upload our file to this Directories
        try {
            String timeStamp = String.valueOf(System.currentTimeMillis());
            Path filePath = root.resolve(timeStamp + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            System.out.println("This is uploaded file path " + filePath);//this is the currently created file path

            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "file saved", String.valueOf(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }


    }

    @PostMapping ("upload/")
    public Response fileUpload( @RequestParam("file") MultipartFile file) throws IOException {

        final Path root = Paths.get("B:\\final E-commerce project\\E_Commerce\\Ecommerce_demo\\uploads\\kibria local server\\products");

        //tro to control file size with MultipartFile object
        long size = file.getSize();//requested file size

        Long fileSize = size / (1024 * 1024);//converted file size requested size type to MB

        if (fileSize > Long.parseLong(String.valueOf(100))) {//this logic only workable for offline not online
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_ACCEPTABLE, "File size should be less then 100 MB");
        }
        //check file already created or not
        if (!Files.exists(root)) {//if don't have Directories in our system OS
            try {
                Files.createDirectories(root);//create Directories in our system OS
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
        //we already have Directories now upload our file to this Directories
        try {
            String timeStamp = String.valueOf(System.currentTimeMillis());
            Path filePath = root.resolve(timeStamp + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            System.out.println("This is uploaded file path " + filePath);//this is the currently created file path

            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "file saved", String.valueOf(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        }





}
