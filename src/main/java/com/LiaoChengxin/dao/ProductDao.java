package com.LiaoChengxin.dao;

import com.LiaoChengxin.model.Product;
import com.LiaoChengxin.model.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {

        String sql = "delete from Product where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,Integer.toString(productId));
        ps.execute();
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {

        String sql = "update Product set ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? where ProductId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,instance.getProductName());
        ps.setString(2,instance.getProductDescription());
        ps.setString(3,instance.getPicture().toString());
        ps.setString(4,String.valueOf(instance.getPrice()));
        ps.setString(5,Integer.toString(instance.getCategoryId()));
        ps.setString(6,Integer.toString(instance.getProductId()));
        ps.execute();
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {

        String sql = "select * from Product where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,productId.toString());
        ResultSet rs = ps.executeQuery();
        Product product = null;
        if (rs.next())
        {
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));

        }

        return product;

    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        ArrayList<Product> list = new ArrayList<Product>();
        String sql = "select * from Product where CategoryId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,Integer.toString(categoryId));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ProductId = rs.getInt("ProductId");
            String ProductName = rs.getString("ProductName");
            String ProductDescription = rs.getString("ProductDescription");
            InputStream picture = new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8));
            Double price = rs.getDouble("price");
            int CategoryId = rs.getInt("CategoryId");
            Product product = new Product(ProductId, ProductName, ProductDescription, picture, price,CategoryId);
            list.add(product);
        }

        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        ArrayList<Product> list = new ArrayList<Product>();
        String sql = "select * from Product where price>? and price<?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,Double.toString(minPrice));
        ps.setString(1,Double.toString(maxPrice));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ProductId = rs.getInt("ProductId");
            String ProductName = rs.getString("ProductName");
            String ProductDescription = rs.getString("ProductDescription");
            InputStream picture = new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8));
            Double price = rs.getDouble("price");
            int CategoryId = rs.getInt("CategoryId");
            Product product = new Product(ProductId, ProductName, ProductDescription, picture, price,CategoryId);
            list.add(product);
        }

        return list;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        ArrayList<Product> list = new ArrayList<Product>();
        String sql = "select * from Product ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ProductId = rs.getInt("ProductId");
            String ProductName = rs.getString("ProductName");
            String ProductDescription = rs.getString("ProductDescription");
            InputStream picture = new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8));
            Double price = rs.getDouble("price");
            int CategoryId = rs.getInt("CategoryId");
            Product product = new Product(ProductId, ProductName, ProductDescription, picture, price,CategoryId);
            list.add(product);
        }

        return list;

    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {

        ArrayList<Product> list = new ArrayList<Product>();
        String sql = "select * from Product where ProductName=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,productName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ProductId = rs.getInt("ProductId");
            String ProductName = rs.getString("ProductName");
            String ProductDescription = rs.getString("ProductDescription");
            InputStream picture = new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8));
            Double price = rs.getDouble("price");
            int CategoryId = rs.getInt("CategoryId");
            Product product = new Product(ProductId, ProductName, ProductDescription, picture, price,CategoryId);
            list.add(product);
        }

        return list;

    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        return null;
    }
}
