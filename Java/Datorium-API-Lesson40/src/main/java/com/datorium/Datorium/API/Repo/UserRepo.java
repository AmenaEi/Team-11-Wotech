package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();          //Mocked DataBase

    /*
    public int add(User user) {
        users.add(user);
        return users.size();
    }
    */

    public ArrayList<User> getUsers() {
        return users;
    }

    public User update(int userIndex, User updateUserDTO) {
        var user = users.get(userIndex);
        user.name = updateUserDTO.name;
        return user;
    }

    public void add(User user){
        String url = "jdbc:sqlite:my.db";           //location for databse
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
                //INSERT INTO people (name) VALUES ('');DROP TABLE people;--')
                //conn.commit();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    /*
    public void add(User user){
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "email TEXT NOT NULL)";
                statement.execute(sql);

                sql = "INSERT INTO users (name, email) VALUES ('" + user.getName() + "', '" + user.getEmail() + "')";
                statement.execute(sql);
                System.out.println("User " + user.getName() + " added to the database.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    */

}
