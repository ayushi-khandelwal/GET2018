DROP DATABASE if exists employeePortalDatabase;

CREATE DATABASE if not exists employeePortalDatabase;

USE employeePortalDatabase;

CREATE TABLE if not exists employee(
   emp_code INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   middle_name VARCHAR(100),
   last_name VARCHAR(100) NOT NULL,
   dob DATE NOT NULL,
   gender VARCHAR(10) NOT NULL,
   email_id VARCHAR(100) NOT NULL,
   password VARCHAR(100) NOT NULL,
   enabled BOOLEAN DEFAULT TRUE
);
   
select * from employee;
   
CREATE TABLE if not exists job_title_master(
   job_code INT AUTO_INCREMENT PRIMARY KEY,
   job_title VARCHAR(100) NOT NULL
);
   
CREATE TABLE if not exists user_roles(
   user_role_id INT PRIMARY KEY AUTO_INCREMENT,
   user_name VARCHAR(200) NOT NULL,
   role VARCHAR(50) NOT NULL    
);

CREATE TABLE if not exists skill_master(
   skill_id INT AUTO_INCREMENT PRIMARY KEY,
   skill_name VARCHAR(100) NOT NULL
);

CREATE TABLE if not exists employee_skills(
   emp_skill_id INT AUTO_INCREMENT PRIMARY KEY,
   emp_code INT NOT NULL,
   skill_code INT NOT NULL,
   FOREIGN KEY (emp_code)  REFERENCES employee(emp_code),
   FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)
);

drop table project_master;

CREATE TABLE if not exists project_master(
   project_id INT AUTO_INCREMENT PRIMARY KEY,
   description VARCHAR(200),
   start_date DATE NOT NULL,
   end_date DATE
);

select * from project_master;