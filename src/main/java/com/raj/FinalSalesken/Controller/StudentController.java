package com.raj.FinalSalesken.Controller;


import com.raj.FinalSalesken.Model.Semester;
import com.raj.FinalSalesken.Model.Student;
import com.raj.FinalSalesken.Repository.StudentRepository;
import com.raj.FinalSalesken.Repository.StudentService;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.function.*;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;



    @RequestMapping("/")
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView("index.jsp");
        List<Student> studentList = service.getAllStudents();
        model.addObject("students", studentList);
        return model;
    }

    @RequestMapping(value = "/addStudentMarks", method = RequestMethod.POST)
    public String addMarks(@RequestParam("Id") String Id, @RequestParam("sem") int sem, @RequestParam("subject") String subject, @RequestParam("marks") int marks)
    {
        try {
            String response = service.addMarks(Id, sem, subject, marks);
            return "redirect:/";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public String deleteStudentByID(@RequestParam("SId") String SId)
    {
        try {
            String response = service.deleteStudent(SId);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return (e.toString());
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudentByName(@RequestParam("SName") String SName)
    {
        try {
            String response = service.addStudent(SName);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

        return "redirect:/";

    }










    /////////////////////////

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home.jsp");
        model.addObject("message", "this.message");
        System.out.println("this is home");
        return model;
    }


    @RequestMapping("/save")
    public String saveStudent() throws IOException {


        Student s = new Student("101","Raj",new ArrayList<Semester>());
        System.out.println(s.toString());
        return "save.jsp";
    }

    @RequestMapping("/find")
    public String find(Model model){
//        String id = "101";
//        Optional<Student> s = repository.findById(id);
//        List<Student> students = s.stream().toList();
//        System.out.println(s);
//        System.out.println(repository.count());

//        model.addAttribute("students", students);
        return "find.jsp";
    }




}
