package com.raj.FinalSalesken.Controller;

import com.raj.FinalSalesken.Model.Student;
import com.raj.FinalSalesken.Repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonArray;
import javax.json.JsonString;
import java.io.IOException;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private StudentService service;

    @PostMapping(value = "/addStudent")
    public ResponseEntity<Object> addStudent(@RequestParam String studentName) throws IOException{
        System.out.println("Student Name : " + studentName);

        String response = service.addStudent(studentName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findStudent")
    public ResponseEntity<Object> getStudent(@RequestParam("Id") String Id) throws IOException{
        Student student = service.getStudent(Id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllStudent() throws IOException{
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping(path = "/addMarks")
    public ResponseEntity<Object> addMarks(@RequestParam("Id")String Id,
                                           @RequestParam("sem")int sem,
                                           @RequestParam("subject")String subject,
                                           @RequestParam("marks")int marks) throws Exception {

        System.out.println("class of Id: " + Id.getClass());

        String response = service.addMarks(Id,sem,subject,marks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteById(@RequestParam("Id") String Id) throws Exception{

        String response = service.deleteStudent(Id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
