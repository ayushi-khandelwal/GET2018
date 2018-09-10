package com.metacube.training.adminEmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.adminEmployeePortal.model.Skill;

public class SkillMapper implements RowMapper<Skill>
{
    public Skill mapRow(ResultSet resultSet, int i) throws SQLException
    {

        Skill skill = new Skill();
        skill.setId(resultSet.getInt("skill_id"));
        skill.setName(resultSet.getString("skill_name"));
        return skill;
    }
}
