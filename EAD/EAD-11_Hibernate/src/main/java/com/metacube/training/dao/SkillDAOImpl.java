package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
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

import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Skill getSkillById(int id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		crit.add(Restrictions.eq("skill_id", id));
		return (Skill) crit.uniqueResult();
	}

	public List<Skill> getAllSkills() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		return crit.list();
	}

	public boolean deleteSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "DELETE FROM skill_master WHERE skill_id = :id";
		int result = session.createQuery(hql)
				.setParameter("id", skill.getSkillId())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean updateSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE skill_master SET skill_name = :name WHERE skill_id = :id";
		int result = session.createQuery(hql)
				.setParameter("name", skill.getSkillName())
				.setParameter("id", skill.getSkillId())
				.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	public boolean createSkill(Skill skill) {
		return sessionFactory.getCurrentSession().save(skill) != null;
	}
	
}
