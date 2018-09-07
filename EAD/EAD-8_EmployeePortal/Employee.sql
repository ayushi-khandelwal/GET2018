DROP DATABASE if exists employee_portal;

CREATE DATABASE if not exists employee_portal;

USE employee_portal;

CREATE TABLE if not exists employee(
   emp_code INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   middle_name VARCHAR(100),
   dob DATE NOT NULL,
   gender VARCHAR(1) NOT NULL,
   primary_contact_number VARCHAR(10),
   secondary_contact_number VARCHAR(10),
   email_id VARCHAR(100) NOT NULL,
   skype_id VARCHAR(100),
   profile_picture VARCHAR(512),
   password VARCHAR(100) NOT NULL,
   enabled BOOLEAN DEFAULT TRUE
);
   
CREATE TABLE if not exists job_title_master(
   job_code INT PRIMARY KEY,
   job_title VARCHAR(100) NOT NULL
);
   
CREATE TABLE if not exists user_roles(
   user_role_id INT PRIMARY KEY AUTO_INCREMENT,
   user_name VARCHAR(200) NOT NULL,
   role VARCHAR(50) NOT NULL    
);

CREATE TABLE if not exists skill_master(
   skill_id INT PRIMARY KEY,
   skill_name VARCHAR(100) NOT NULL
);

CREATE TABLE if not exists employee_skills(
   emp_skill_id INT AUTO_INCREMENT PRIMARY KEY,
   emp_code INT NOT NULL,
   skill_code INT NOT NULL,
   FOREIGN KEY (emp_code)  REFERENCES employee(emp_code),
   FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)
);

CREATE TABLE if not exists project_master(
   project_id INT PRIMARY KEY,
   description VARCHAR(200) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE,
   project_logo VARCHAR(100)
);

CREATE TABLE if not exists address(
   address_id INT PRIMARY KEY,
   emp_code INT NOT NULL,
   add_line_1 VARCHAR(100) NOT NULL,
   add_line_2 VARCHAR(100),
   city VARCHAR(100) NOT NULL,
   state VARCHAR(100) NOT NULL,
   pincode VARCHAR(100) NOT NULL,
   FOREIGN KEY (emp_code) REFERENCES employee(emp_code)
);

CREATE table if not exists job_details(
    emp_code INT NOT NULL,
    job_detail_id INT NOT NULL,
    date_of_joining INT NOT NULL,
    total_exp INT NOT NULL,
    job_code INT NOT NULL,
    