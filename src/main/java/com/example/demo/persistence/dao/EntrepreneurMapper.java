package com.example.demo.persistence.dao;


import com.example.demo.persistence.entity.Entrepreneur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrepreneurMapper implements RowMapper<Entrepreneur> {

    @Override
    public Entrepreneur mapRow(ResultSet resultSet, int i) throws SQLException {

        Entrepreneur entrepreneur = new Entrepreneur();
        entrepreneur.setId(resultSet.getLong("id"));
        entrepreneur.setName(resultSet.getString("name"));
        return entrepreneur;
    }
}
