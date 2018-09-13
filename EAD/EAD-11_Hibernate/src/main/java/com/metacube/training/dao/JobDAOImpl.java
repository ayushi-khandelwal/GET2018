package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public Job getJobTitleById(Long id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Job.class);
		crit.add(Restrictions.eq("job_code", id));
		return (Job) crit.uniqueResult();
	}

	public List<Job> getAllJobTitles() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Job.class);
		return crit.list();
	}

	public boolean deleteJobTitle(Job jobTitle) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM job_title_master WHERE job_code = :id";
		int result = session.createQuery(hql)
				.setParameter("id", jobTitle.getJobCode())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateJobTitle(Job jobTitle) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE job_title_master SET job_title = :title WHERE job_code = :id";
		int result = session.createQuery(hql)
				.setParameter("title", jobTitle.getJobTitle())
				.setParameter("id", jobTitle.getJobCode())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createJobTitle(Job jobTitle) {
		return sessionFactory.getCurrentSession().save(jobTitle) != null;
	}

}
