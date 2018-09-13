package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public Employee getEmployeeById(Long id) {
		Criteria crit = sessionFactory.openSession().createCriteria(Employee.class);
		crit.add(Restrictions.eq("emp_code", id));
		return (Employee) crit.uniqueResult();
	}

	public List<Employee> getAllEmployees() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return crit.list();
	}

	public boolean deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM employee WHERE emp_code = :emp_code";
		int result = session.createQuery(hql)
				.setParameter("emp_code", employee.getEmpCode())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE employee SET first_name = :first_name, "
				+ "middle_name = :middle_name, last_name = :last_name, dob = :dob, gender = :gender, email_id = :email, "
				+ "password = :pwd, enabled = :enabled WHERE emp_code = :emp_code";
		int result = session.createQuery(hql)
		.setParameter("first_name", employee.getFirstName())
		.setParameter("middle_name", employee.getMiddleName())
		.setParameter("last_name", employee.getLastName())
		.setParameter("dob", employee.getDateOfBirth())
		.setParameter("gender", employee.getGender())
		.setParameter("email", employee.getEmail())
		.setParameter("pwd", employee.getPassword())
		.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createEmployee(Employee employee) {
		return sessionFactory.getCurrentSession().save(employee) != null;
	}

	public List<Employee> getAllEmployeeByName(String name) {
		Criteria crit = sessionFactory.openSession().createCriteria(Employee.class);
		Criterion firstName = Restrictions.like("first_name", "%" + name + "%");
		Criterion middleName = Restrictions.like("middle_name", "%" + name + "%");
		Criterion lastName = Restrictions.like("last_name", "%" + name + "%");
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(firstName);
		disjunction.add(middleName);
		disjunction.add(lastName);
		crit.add(disjunction);
		return crit.list();
	}

}
