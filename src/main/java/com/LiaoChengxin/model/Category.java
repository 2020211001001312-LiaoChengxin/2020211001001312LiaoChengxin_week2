package com.LiaoChengxin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int CategoryId;
    private String CategoryName;
    private String Description;
    private boolean Active;

    public Category(){}
    public Category(int categoryId, String categoryName, String description, boolean active) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        Description = description;
        Active = active;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Active=" + Active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql = "select * from Category";
        ArrayList<Category> list = new ArrayList<Category>();
        PreparedStatement pt =  con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Category c = new Category();
            c.setCategoryId(rs.getInt("CategoryId"));
            c.setCategoryName(rs.getString("CategoryName"));
            c.setDescription(rs.getString("Description"));
            c.setActive(rs.getBoolean("Active"));
            list.add(c);
        }

        return list;

    }


    public static String findByCategoryId(Connection con,int categoryId) throws SQLException {

        String categoryName = null;
        String sql = "select * from Category where CategoryId="+categoryId;
        ArrayList<Category> list = new ArrayList<Category>();
        PreparedStatement pt =  con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){

            categoryName = rs.getString("CategoryName");


        }

        return categoryName;
    }



}
