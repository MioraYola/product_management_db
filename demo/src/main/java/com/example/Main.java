package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever(); 
        List<Category> categories = dataRetriever.getAllCategory();
        System.out.println("==liste des catégories==");
        for (Category category: categories){
            System.out.println("ID: "+ category.getId()+ " , Nom: " + category.getName());
        }

        System.out.println("==liste les produits avec pagination==");
        int page= 1;
        int size= 5; 

        List<Product> products = dataRetriever.getProductList(page, size); 
        for(Product product : products){
            System.out.pintln("ID: " + product.getId()+
                                " ,nom: " + product.getName() +
                                " ,date de création: "+ product.getCreationDateTime() +
                                " ,catégorie: " + product.getCategory() )
        }

    }
}
