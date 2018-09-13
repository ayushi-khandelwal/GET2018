package com.metacube.training.AdminEmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.AdminEmployeePortalSpringBoot.mappers.SkillMapper;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SkillDAOImpl(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_SKILL = "select * from skill_master where skill_id = ?";
    private final String SQL_DELETE_SKILL = "delete from skill_master where skill_id = ?";
    private final String SQL_UPDATE_SKILL = "update skill_master set skill_name = ? where skill_id = ?";
    private final String SQL_GET_ALL = "select * from skill_master";
    private final String SQL_INSERT_SKILL = "insert into skill_master(skill_name) values(?)";

    /**
     * returns skill by id
     */
    public Skill getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id },
                new SkillMapper());
    }

    /**
     * returns list of all skills
     */
    public List<Skill> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
    }

    /**
     * deletes skill
     */
    public boolean delete(Skill skill)
    {
        try
        {
            return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates skill
     */
    public boolean update(Skill skill)
    {
        try
        {
            return jdbcTemplate.update(SQL_UPDATE_SKILL, skill.getName(),
                    skill.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds skill
     */
    public boolean create(Skill skill)
    {
        try
        {
            return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getName()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }
}
