package com.example.demo.persistence.dao;

import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class ActivityExtractor implements ResultSetExtractor<Set<Entrepreneur>> {
    @Override
    public Set<Entrepreneur> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Set<Entrepreneur> data = new HashSet<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("entrepreneur.id");
            String name = resultSet.getString("entrepreneur.name");
            Activity activity = new Activity(resultSet.getLong("activity.id"), resultSet.getString("activity.name"));
            Optional<Entrepreneur> any = data.stream().filter(x -> x.getId().equals(id)).findAny();
            if (any.isPresent()) {
                any.get().getActivities().add(activity);
            } else {
                Entrepreneur entrepreneur = new Entrepreneur();
                entrepreneur.setId(id);
                entrepreneur.setName(name);
                Set<Activity> activities = new HashSet<>();
                activities.add(activity);
                entrepreneur.setActivities(activities);
                data.add(entrepreneur);
            }
        }
        return data;
    }
}
