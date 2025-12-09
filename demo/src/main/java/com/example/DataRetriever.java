package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        int category
        String query = "select * from product limit ? offset ? "; 

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
                    rs.getInt("")
                )
            }
                } catch (Exception e) {
            // TODO: handle exception
        }
    }
}