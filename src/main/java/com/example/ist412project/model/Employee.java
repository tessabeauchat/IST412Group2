package com.example.ist412project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    /**
     * Creates table to store all employee data. Establishes fields in the employee table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    @Column(name = "emply_name")
    private String emplyName;
    @Column(name = "emply_email")
    private String emplyEmail;
    @ManyToMany(cascade = CascadeType.MERGE)

    @JoinTable(name = "employee_user",
            joinColumns = {@JoinColumn(name = "eid")})

    /**
     * Creates getter and setter methods for all employee table data fields
     * @param eid
     */
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
