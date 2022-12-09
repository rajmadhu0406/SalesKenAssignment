package com.raj.FinalSalesken.Repository;

import com.raj.FinalSalesken.Model.Semester;
import com.raj.FinalSalesken.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final String indexName = "student-index";


    public String addStudent(String name) {

        int nextId = (int) studentRepository.count() + 1;
        String Id = Integer.toString(nextId);

        System.out.println("Student Count : " + Id);


        Semester first = new Semester(1);
        Semester second = new Semester(2);
        List<Semester> semList= new ArrayList<>();
        semList.add(first);
        semList.add(second);

//      student.setSemesters(semList);
        Student student = new Student(Id, name, semList);

        System.out.println("Student Count : " + Id);
        System.out.println("Student semesters : " + student.getSemesters());

        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return e.toString();
        }

        return "Successfully added student!";

    }

    @Transactional
    public String addMarks(String studentId, int semId, String subject, Integer marks) {

        try {

            Optional<Student> students = studentRepository.findById(studentId);

            if (students.isEmpty()) {
                return "Marks add unsuccessfull, no student with StudentId : " + semId;
            }

            Student student = ((Student[]) students.stream().toArray())[0];

            for (Semester sem : student.getSemesters()) {
                if (sem.getSemId() == semId) {
                    if (subject == "English") {
                        sem.setEnglish(marks);
                    } else if (subject == "Maths") {
                        sem.setEnglish(marks);
                    } else if (subject == "Science") {
                        sem.setEnglish(marks);
                    } else {
                        return "error in subject name";
                    }
                } else {
                    return "Error in semId!!!";
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return "marks add success!";
    }

    public Student getStudent(String studentId) {
        Optional<Student> students = null;

        try {
            students = studentRepository.findById(studentId);

            if (students.isEmpty()) {
                throw new Exception("getStudent() failed!");
            }
            Student student = ((Student[]) students.stream().toArray())[0];
            return student;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public List<Student> getAllStudents() {
        try {
            Iterable<Student> students = studentRepository.findAll();
            List<Student> studentList = new ArrayList<>();
            for (Student s : students) {
                studentList.add(s);
            }
            return studentList;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ArrayList<Student>();
    }

    public String deleteStudent(String id){
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            return  (e.toString());
        }

        return "Successfully deleted student with Id : " + id;

    }


}
