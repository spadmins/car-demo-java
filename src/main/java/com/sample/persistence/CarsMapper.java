package com.sample.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.model.Cars;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CarsMapper implements ResultSetMapper<Cars>{
    public Cars map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
        return new Cars(rs.getInt("ID"), rs.getString("CAR_NAME"), rs.getDouble("PRICE"));
    }
}
