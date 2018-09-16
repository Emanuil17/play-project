package org.emo.business;
import java.util.*;

public class Company {
	
	public static List<Company> companies;

	   public Integer id;
	   public String name;
	   public Integer empNum;
	   public String email;
	   private List<Integer> productID;
	   private List<String> productName;
	   private List<Double> productPrice;
	   
	//Default constructor
	   public Company() {}
	   
	//Consturctor with some parameters 
	   public Company(Integer id, String name,Integer empNum, String email, Collection<Integer> productID, Collection <String> productName, Collection<Double> productPrice) {
		 this.id=id;
		 this.name = name;
		 this.empNum=empNum;
		 this.email=email;
		 this.productID = new ArrayList<Integer> (productID);
		 this.productName = new ArrayList<String> (productName);
		 this.productPrice = new ArrayList<Double> (productPrice);
	   }
	   
		// Generated Getters and setters 
	   	public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public Integer getEmpNum() {
			return empNum;
		}
		public void setEmpNum(Integer empNum) {
			this.empNum = empNum;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    
	   	public List<Integer> getProductID() {
			return productID;
		}

		public void setProductID(List<Integer> productID) {
			this.productID = productID;
		}

		public List<String> getProductName() {
			return productName;
		}

		public void setProductName(List<String> productName) {
			this.productName = productName;
		}

		public List<Double> getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(List<Double> productPrice) {
			this.productPrice = productPrice;
		}
	}
