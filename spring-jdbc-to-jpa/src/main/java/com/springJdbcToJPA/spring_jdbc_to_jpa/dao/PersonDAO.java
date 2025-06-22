package com.springJdbcToJPA.spring_jdbc_to_jpa.dao;

import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setTimestamp(rs.getTimestamp("date_time"));

                return person;
            }
        });
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Person where id=?", new Object[]{id}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setTimestamp(rs.getTimestamp("date_time"));

                return person;
            }
        });
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Person where id=?", new Object[]{id});
    }
}
