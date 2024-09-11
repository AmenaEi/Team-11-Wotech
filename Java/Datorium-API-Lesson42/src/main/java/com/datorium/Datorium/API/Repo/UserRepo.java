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

    //public ArrayList<User> getUsers() {
    //    return users;
    //}

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

    public ArrayList<User> getUsers(){
        String url = "jdbc:sqlite:my.db";           //location for databse
        var resultList = new ArrayList<User>();         //prepare a box
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();     //create an action what to do
                var result = statement.executeQuery("SELECT id, name FROM people");     //different box but more abstract
                //INSERT INTO people (name) VALUES ('');DROP TABLE people;--')
                //conn.commit();

                while(result.next()){
                    var user = new User();  //create new user
                    user.id = result.getInt("id");
                    user.name = result.getString("name");   //assign new user a name
                    resultList.add(user);   //add user to the box
                }  //stops when there is no next element
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

        return resultList;
    }

    /*
    public User update(User user){
        var userFromDb = users.get(user.id);
        userFromDb.name = user.name;
        return userFromDb;
    }
     */

    public void update(User user){
        String url = "jdbc:sqlite:my.db";           //location for databse
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("UPDATE people SET name = '"
                        + user.name + "' WHERE id = " + user.id);
                //INSERT INTO people (name) VALUES ('');DROP TABLE people;--')
                //conn.commit();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    //UpdateUserDTO contains userId
    //User contains only Name
    //Our mission is to add the userId to the User class
    // 1. Add int Id to the User class
    // 2. Replace UpdateUserDTO usage by just User class
    // 3. Delete UpdateUserDTO
    // 4. Remove the unnecessary ids that came from UpdateUserDTO
    // 5. Update the Get method with Id




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
