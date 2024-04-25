package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        String query = "CREATE TABLE users " +
                "(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(250) NOT NULL," +
                "lastname VARCHAR(250) NOT NULL," +
                "age INT NOT NULL);";
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLSyntaxErrorException ignored) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String query = "DROP TABLE users";
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLSyntaxErrorException ignored) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, name);
            pr.setString(2, lastName);
            pr.setByte(3, age);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection connection = Util.getConnection();
             PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = Util.getConnection();
             PreparedStatement pr = connection.prepareStatement(query)) {
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("lastname"));
                user.setAge(result.getByte("age"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void cleanUsersTable() {
        String query = "DELETE FROM users";
        try (Connection connection = Util.getConnection();
             PreparedStatement pr = connection.prepareStatement(query)) {
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
