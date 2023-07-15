package com.example.ist412project.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    @Column(name = "emply_name")
    private String emplyName;
    @Column(name = "emply_email")
    private String emplyEmail;

    public void seteid(long eid) {
        this.eid = eid;
    }
    public String getemplyName() {
        return emplyName;
    }
    public void setemplyName(String emplyName) {
        this.emplyName = emplyName;
    }
    public String getemplyEmail() {
        return emplyEmail;
    }
    public void setemplyEmail(String emplyEmail) {
        this.emplyEmail = emplyEmail;
    }
}
