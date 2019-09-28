package com.siddd00474.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
    @Id
//    @Size(min = 7,max = 7,message = "id 7 ki tu")
    private long studentId;
    @NotNull(message = "Không thể bỏ trống")
    private String name;
    @Email(message = "Email sai định dạng")
    private String email;
    @Size(min = 6,message = "Password tối thiểu 6 kí tự")
    private String password;
    private long createAtMLS;
    private long updatedAtMLS;
    private long deletedAtMLS;
    private int status;
    @ManyToMany(mappedBy = "studentSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<AptechClass> aptechClassSet;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreateAtMLS() {
        return createAtMLS;
    }

    public void setCreateAtMLS(long createAtMLS) {
        this.createAtMLS = createAtMLS;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public long getDeletedAtMLS() {
        return deletedAtMLS;
    }

    public void setDeletedAtMLS(long deletedAtMLS) {
        this.deletedAtMLS = deletedAtMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<AptechClass> getAptechClassSet() {
        return aptechClassSet;
    }

    public void setAptechClassSet(Set<AptechClass> aptechClassSet) {
        this.aptechClassSet = aptechClassSet;
    }
}
