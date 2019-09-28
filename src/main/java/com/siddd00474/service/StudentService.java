package com.siddd00474.service;

import com.siddd00474.entity.Student;
import com.siddd00474.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    //list
    public List<Student> getList(){
        return studentRepository.findAllByStatus(1);
    }

    //find student by student id
    public Student findById(long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }


    //find student by email

    public Student getByEmail(String email){
       return studentRepository.findByEmail(email);
    }
    // add new student
    public Student add(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreateAtMLS(Calendar.getInstance().getTimeInMillis());
        student.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        student.setStatus(1);
        return studentRepository.save(student);
    }
    //edit student
    public Student edit(long id,Student updateStudent){
        Optional<Student> optionalStudent =studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existStudent = optionalStudent.get();
            existStudent.setName(updateStudent.getName());
            existStudent.setEmail(updateStudent.getEmail());
            existStudent.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
           return studentRepository.save(existStudent);
        }
        return null;
    }
    //delete
    public Student delete(long id){
        Optional<Student> optionalStudent =studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existStudent = optionalStudent.get();
            existStudent.setStatus(0);
            existStudent.setDeletedAtMLS(Calendar.getInstance().getTimeInMillis());
            return studentRepository.save(existStudent);
        }
        return null;
    }
}
