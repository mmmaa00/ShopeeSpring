package com.example.ShopeeSpring.helper.mapper;

import com.example.ShopeeSpring.entity.Session;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionMapper implements RowMapper<Session> {
    @Override
    public Session mapRow(ResultSet resultSet, int i) throws SQLException {
        Session session = new Session();
        session.setUserId(resultSet.getString("user_id"));
        session.setToken(resultSet.getString("token"));
        return session;
    }
}