package com.LiaoChengxin.dao;

import com.LiaoChengxin.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements  IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        int i = 0;
        PreparedStatement ps = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;

        try {
            String sql = "select * from usertable";
            preparedStatement1 = con.prepareStatement(sql);
            resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                i = i + 1;
            }

        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        } finally {

            try {
                if (preparedStatement1 != null)
                    preparedStatement1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet1 != null)
                    resultSet1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        boolean flag = true;
        try {
            String sql = "select * from usertable where username=? ";
            preparedStatement1 = con.prepareStatement(sql);
            preparedStatement1.setString(1, user.getUsername());
            resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                flag = false;
            }

        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        } finally {

            try {
                if (preparedStatement1 != null)
                    preparedStatement1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet1 != null)
                    resultSet1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (flag)
        {
            String sql = "insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)";
            try {
                ps = con.prepareStatement(sql);
                String s = Integer.toString(i + 1);
                ps.setString(1, s);
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getGender());
                ps.setString(6, user.getBirthdate().toString());
                ps.execute();
                System.out.println("insert --> OK !");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }}
        return flag;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,Integer.toString(user.getId()));
        ps.execute();
        return user.getId();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        ps.setString(5,user.getBirthdate().toString());
        ps.setString(6,Integer.toString(user.getId()));
        ps.execute();
        return user.getId();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {

        String sql = "select * from usertable where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id.toString());
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql = "select * from usertable where username=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        User user = null;

        if (rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
                int id = rs.getInt("id");
                String username2 = rs.getString("username");
                String password2 = rs.getString("password");
                String email2 = rs.getString("email");
                String gender2 = rs.getString("gender");
                Date birthdate2 = rs.getDate("birthdate");
                User user = new User(id, username2, password2, email2, gender2, birthdate2);
                list.add(user);
            }

        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable where password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password2 = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");
            User user = new User(id, username, password2, email, gender, birthdate);
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable where email=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password2 = rs.getString("password");
            String email2 = rs.getString("email");
            String gender = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");
            User user = new User(id, username, password2, email2, gender, birthdate);
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable where gender=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,gender);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password2 = rs.getString("password");
            String email = rs.getString("email");
            String gender2 = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");
            User user = new User(id, username, password2, email, gender2, birthdate);
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable where birthdate=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,birthDate.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password2 = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");
            User user = new User(id, username, password2, email, gender, birthdate);
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "select * from usertable ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password2 = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");
            User user = new User(id, username, password2, email, gender, birthdate);
            list.add(user);
        }
        return list;
    }
}
