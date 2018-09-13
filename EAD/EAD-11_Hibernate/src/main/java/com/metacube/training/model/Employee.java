package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    @Column(name = "emp_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empCode;
    
    @Column(name = "first_name")
    String firstName;
    
    @Column(name = "middle_name")
    String middleName;
    
    @Column(name = "last_name")
    String lastName;
    
    @Column(name = "dob")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    Date dateOfBirth;
    
    @Column(name = "gender")
    String gender;
    
    @Column(name = "email_id")
    String email;
    
    @Column(name = "password")
    String password;

    public int getEmpCode()
    {
        return empCode;
    }

    public void setEmpCode(int empCode)
    {
        this.empCode = empCode;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
