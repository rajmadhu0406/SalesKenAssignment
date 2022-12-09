package com.raj.FinalSalesken.Repository;

import com.raj.FinalSalesken.Model.Semester;
import com.raj.FinalSalesken.Model.Student;
import org.elasticsearch.common.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
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

//        int nextId = (int) studentRepository.count() + 1;

        String Id = UUIDs.randomBase64UUID();//Integer.toString(nextId);

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

    public String addMarks(String studentId, int semId, String subject, int marks) {

        try {

            Optional<Student> students = studentRepository.findById(studentId);

            if (students.isEmpty()) {
                return "Marks add unsuccessfull, no student with StudentId : " + semId;
            }

            Student student = students.get();
            List<Semester> semestersList = student.getSemesters();

            for (Semester sem : semestersList) {

                System.out.println(sem.getSemId());
                System.out.println(semId);
                System.out.println(sem.getSemId() == semId);
                System.out.println((subject.equals("Maths")));

                if (sem.getSemId() == semId) {
                    if (subject.equals("English")) {
                        sem.setEnglish(marks);
                    } else if (subject.equals("Maths")) {
                        sem.setMaths(marks);
                    } else if (subject.equals("Science")) {
                        sem.setScience(marks);
                    } else {
                        return "error in subject name";
                    }

                    break;
                }
            }//for

            student.setSemesters(semestersList);
            studentRepository.save(student);

        }catch (Exception e){
            System.out.println(e.toString());
        }

        return "marks add success!";
    }

    public Student getStudent(String studentId) {

        try {
            Optional<Student> students = studentRepository.findById(studentId);

            if (students.isEmpty()) {
                throw new Exception("getStudent() failed!");
            }

            Student student = students.get();
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
            System.out.println("erro : " + e.toString());
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
