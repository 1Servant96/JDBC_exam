package peaksoft.dao;

import peaksoft.config.DataBaseConfiguration;
import peaksoft.model.Student;

import java.sql.*;

public class DAO {
    public void create() {
        String query1 = "create table if not exists students( id serial primary key , name varchar(50),age int);";
        try (Connection connection = DataBaseConfiguration.getConnection();) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query1);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Long id,String name, byte age) {
        String query2 = "update students set name = ?, age = ?";
        try (Connection connection = DataBaseConfiguration.getConnection();
            PreparedStatement statement = connection.prepareStatement(query2)){
            statement.setString(1, name);
            statement.setByte(2,age);
            statement.executeUpdate();
            System.out.println("You successfully updated the table");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert(String name, byte age){
        String query = "insert into students (name, age) VALUES (?,?)";
        try(Connection connection = DataBaseConfiguration.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
statement.setString(1,name);
statement.setInt(2,age);
statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void read(Long id) {
        String query3 = "select * from students where id = "+ id;
        try (Connection connection = DataBaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query3);) {
while(resultSet.next()){
    System.out.println(resultSet.getInt("id"));
    System.out.println(resultSet.getString("name"));
    System.out.println(resultSet.getInt("age"));
}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudentById(Long id) {
        String query4 = "delete from students where id = "+ id;
        try (Connection connection = DataBaseConfiguration.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
