package com.service.impl;

import com.entity.User;
import com.service.UserService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getTimestamp("inserttime"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return users;
    }

    @Override
    public void addUser(String name) {
        String sql = "INSERT INTO user(name) VALUES(?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, name);
            st.executeQuery();
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE user set name = ? where id = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getName());
            st.setInt(2, user.getId());
            st.executeQuery();
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }

    public User getUser(int id) {
        User user = null;
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getTimestamp("inserttime"));

            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return user;
    }
}
