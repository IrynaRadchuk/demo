package com.example.demo.model.dao;

import com.example.demo.model.entity.Entrepreneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EntrepreneurDao {
    @Autowired
    private ActivityExtractor activityExtractor;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EntrepreneurDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Entrepreneur> index() {
        return jdbcTemplate.query("SELECT * FROM entrepreneur", new BeanPropertyRowMapper<>(Entrepreneur.class));
    }

    public Map<Entrepreneur, List<String>> getGroupedActivities() {
        return jdbcTemplate.query("select ENTREPRENEUR.id, ENTREPRENEUR .NAME, ACTIVITY.NAME   from ENTREPRENEUR left join ENTREPRENEUR_ACTIVITY on ENTREPRENEUR .ID = ENTREPRENEUR_ACTIVITY.ENTREPRENEUR_ID left join ACTIVITY on ACTIVITY.ID = ENTREPRENEUR_ACTIVITY.ACTIVITY_ID", activityExtractor);
    }
}
