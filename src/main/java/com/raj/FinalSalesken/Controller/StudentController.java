package com.raj.FinalSalesken.Controller;


import com.raj.FinalSalesken.Model.Semester;
import com.raj.FinalSalesken.Model.Student;
import com.raj.FinalSalesken.Repository.StudentRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


        System.out.println(s.toString());
        return "save.jsp";
    }

    @RequestMapping("/find")
    public String find(Model model){
        String id = "101";
        Optional<Student> s = repository.findById(id);
        List<Student> students = s.stream().toList();
        System.out.println(s);
        System.out.println(repository.count());

        model.addAttribute("students", students);
        return "find.jsp";
    }




}
