package com.example.demo.model.dao;

import com.example.demo.model.entity.Entrepreneur;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Component
public class ActivityExtractor implements ResultSetExtractor<Map<Entrepreneur, List<String>>> {
    @Override
    public Map<Entrepreneur, List<String>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Entrepreneur, List<String>> data = new LinkedHashMap<>();
        while (resultSet.next()) {
            Entrepreneur entrepreneur = new Entrepreneur();
            entrepreneur.setId(resultSet.getLong("entrepreneur.id"));
            entrepreneur.setName(resultSet.getString("entrepreneur.name"));
            data.putIfAbsent(entrepreneur, new ArrayList<>());
            String activity = resultSet.getString("activity.name");
            data.get(entrepreneur).add(activity);
        }
        return data;
    }
}
