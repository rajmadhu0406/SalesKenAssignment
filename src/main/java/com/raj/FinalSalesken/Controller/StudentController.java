package com.raj.FinalSalesken.Controller;


import com.raj.FinalSalesken.Model.Semester;
import com.raj.FinalSalesken.Model.Student;
import com.raj.FinalSalesken.Repository.StudentRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.function.*;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repository;


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home.jsp");
        model.addObject("message", "this.message");

        System.out.println("this is home");
        return model;
    }

    @RequestMapping("/save")
    public String saveStudent() throws IOException {

        Student s = new Student("101","Raj",new ArrayList<Semester>());
        repository.save(s);
        return "save.jsp";
    }

    @RequestMapping("/findById")
    public String find(String id){
        Optional<Student> s = repository.findById(id);
        return "find.jsp";
    }




}
