package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class DataRetriever {

    public List<Category> getAllCategory(){
        List<Category> categories= new ArrayList<>();
        String query = "select id, name from category"; 

        try ( Connection conn = DBConnection.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs= stmt.executeQuery()){
            
                while (rs.next()) {
                    Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")

                    ); 
                    categories.add(category);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    List<Product> getProductList (int page, int size){
        int offset = (page -1)*size; 
         String query = 
        "SELECT p.*, c.id AS cat_id, c.name AS cat_name " +
        "FROM product p " +
        "JOIN category c ON p.category_id = c.id " +
        "LIMIT ? OFFSET ?"; 
         List<Product> products = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
    ) {
            stmt.setInt(1, size);
            stmt.setInt(2, offset); 

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getTimestamp("creationDateTime"),
                    new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                    )
                );

                products.add(product);
            }
                } catch (SQLException e) {
                    e.printStackTrace();
        }
            return products;
    }

    List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax) {

        List<Product> products = new ArrayList<>(); 
        String query = "select p.*, c.id, c.name " +
                        "from product p" +
                        "join category c on p.category_id=c.id" +
                        "where 1=1"; 
        
        
    }

}