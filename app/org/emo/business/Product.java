package org.emo.business;

import java.util.*;

public class Product {
	
	public static List<Product> products = new LinkedList<>();
	
	
	
	static {
		products.add(new Product(1,"Iphone X", 1000));
	}
	
	public Integer id;
	public String name;
    public Integer price;
    
   
    public Product() {}
    
    public Product(Integer id, String name,Integer price ){
    	this.id= id;
    	this.name = name;
        this.price = price;
        }
    
    
    public Integer getProductID(){
        return id;
    }
    
    public void setProductID (Integer id){
        this.id = id;
    }
    
    public String getProductName(){
        return name;
    }
    
    public void setProductName(String name){
        this.name = name;
    } 
    
    public Integer getProductPrice(){
        return price;
    }
    public void setProductPrice (Integer price){
        this.price = price;
    }
    
    public static List<Product> findByID(Integer id) {
    	List<Product> result = new ArrayList<Product>();
    	for (Product prd : products) {
    	if(prd.id.equals(id)) {
    		result.add(prd);
    		} 
    	}
    	return result;
    	}
    
    public static Product findById(Integer id) {
		for(Product product: products) {
			if(product.id==id)
				return product;
		}
		return null;
	}
    
    public static List<Product> findByName(String term){
		List<Product> results = new ArrayList<Product>();
		for (Product choice: products) {
			if(choice.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(choice);
			}
		}
		return results;
	}
    
	
	public void addProduct(Product prd) {
		products.add(prd);
	}
    
    public static void save(Product product) {
    	products.add(product);
	  }
    
    // Remove product
    public static boolean remove(Product product) {
    	return Product.remove(product);
    }
    
    //Find All products
    public static List<Product> findAllProducts() {
		return new ArrayList<Product>(products);
	}
    
}
