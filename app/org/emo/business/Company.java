package org.emo.business;
import java.util.*;

public class Company {
		//Temporary storage 
	   public static List<Company> companies;
	   public static List<Product> products = new LinkedList<Product>();
	   static {
			companies = new ArrayList<Company>();
			companies.add(new Company(1,"Apple",1000,"Apple email", products));
			
		}
	   public Integer id;
	   public String name;
	   public Integer empNum;
	   public String email;
	   
	   
	//Default constructor
	   public Company() {}
	   
	   //Consturctor with some parameters 
	   public Company(Integer id, String name,Integer empNum, String email, Collection<Product> products) {
		   this.id=id;
		   this.name = name;
		   this.empNum=empNum;
		   this.email=email;
		   Product.products = new LinkedList<Product>(products);
		   
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
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		Company.products = products;
	}
	
	// Return the list of companies
	public static List<Company> findAllCompanies() {
		return new ArrayList<Company>(companies);
	}
	
	// Return one single company
	public static List<Company> findByIDs(Integer id) {
	    List<Company> results = new ArrayList<Company>();
	    for (Company candidate : companies) {
	      if (candidate.id.equals(id)) {
	        results.add(candidate);
	      }
	    }
	    return results;
	  }
	
	// Add into temporary storage
	public void addCompany(Company cmp) {
		companies.add(cmp);
	}
	
	// Remove company
    public static boolean remove(Company company) {
    	return Company.remove(company);
    }
	
    //Save
  	public static void save(Company company) {
  		//companies.remove(findCompanyByName(name));
  	    companies.add(company);
  	  }
    
	
	
  	
  	
  	// Alternative
	public static List<Company> findByName(String term){
		List<Company> results = new ArrayList<Company>();
		for (Company choice: companies) {
			if(choice.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(choice);
			}
		}
		return results;
	}
	
	}
