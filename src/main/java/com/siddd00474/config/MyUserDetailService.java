package com.siddd00474.config;

import com.siddd00474.entity.Student;
import com.siddd00474.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentService.getByEmail(email);
        if(student==null){
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles("admin","user") // fix cung role
                .build();
    }
}
