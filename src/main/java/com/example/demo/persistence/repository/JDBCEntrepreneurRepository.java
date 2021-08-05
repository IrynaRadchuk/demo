package com.example.demo.persistence.repository;

import com.example.demo.persistence.dao.ActivityExtractor;
import com.example.demo.persistence.entity.Entrepreneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class JDBCEntrepreneurRepository{
    @Autowired
    private ActivityExtractor activityExtractor;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCEntrepreneurRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Entrepreneur> index() {
        return jdbcTemplate.query("SELECT * FROM entrepreneur", new BeanPropertyRowMapper<>(Entrepreneur.class));
    }

    public Set<Entrepreneur> getGroupedActivities() {
        return jdbcTemplate.query("select ENTREPRENEUR.id, ENTREPRENEUR .NAME, ACTIVITY.NAME, ACTIVITY.ID   from ENTREPRENEUR left join ENTREPRENEUR_ACTIVITY on ENTREPRENEUR .ID = ENTREPRENEUR_ACTIVITY.ENTREPRENEUR_ID left join ACTIVITY on ACTIVITY.ID = ENTREPRENEUR_ACTIVITY.ACTIVITY_ID", activityExtractor);
    }
}
