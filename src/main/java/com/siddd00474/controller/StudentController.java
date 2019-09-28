package com.siddd00474.controller;

import com.siddd00474.entity.Student;
import com.siddd00474.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //show list
    @GetMapping(value = "/list")
    public String listStudent(Model model){
        model.addAttribute("list",studentService.getList());
        return "list";
    }
    //detail

    @GetMapping(value = "/detail/{id}")
    public String showDetail(@PathVariable("id") long id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }

    //register
    @GetMapping(value = "/create")
    public String createStudent(Model model){
        model.addAttribute("student",new Student());
        return "form";
    }
    @PostMapping(value = "/create")
    public String addStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        studentService.add(student);
        return "redirect:/students/list";
    }
    @GetMapping(value = "/login")
    public String showLoginPage(){
        return "login";
    }
    //edit student su dung 1 form edit khac form dang ki
    //1. show thong tin can edit
    @GetMapping(value = "/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "edit";
    }

    //2. update thong tin
    @PostMapping(value = "/update/{id}")
    public String updateStudent(@PathVariable("id") long id,@Valid Student student,BindingResult result){
        if(result.hasErrors()){
            return "edit";
        }
        studentService.edit(id,student);
        return "redirect:/students/list";
    }

    //xoa mem bang phuong thuc get.
    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id){
        studentService.delete(id);
        return "redirect:/students/list";
    }

}
