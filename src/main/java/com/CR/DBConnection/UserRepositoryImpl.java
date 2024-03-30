package com.CR.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.CR.model.User;
import com.CR.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, mobile, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile(), user.getUsername(), user.getPassword());
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setMobile(rs.getString("mobile"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET first_name=?, last_name=?, mobile=?, password=? WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getMobile(), user.getPassword(), user.getId());
    }


}
