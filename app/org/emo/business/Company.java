package org.emo.business;
import java.util.*;

public class Company {
	   public static List<Company> companies;
	   public static List<Product> products = new LinkedList<Product>();
	   static {
			companies = new ArrayList<Company>();
			companies.add(new Company(1,"Apple",1000,"Apple email", products));
			
		}
	   public Integer id;
	   public static String name;
	   public Integer empNum;
	   public String email;
	   
	   
	//Default constructor
	   public Company() {}
	   
	   //Consturctor with some parameters 
	   public Company(Integer id, String name,Integer empNum, String email, Collection<Product> products) {
		   this.id=id;
		   Company.name = name;
		   this.empNum=empNum;
		   this.email=email;
		   Product.products = new LinkedList<Product>(products);
		   
	   }
	   
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
		Company.name = name;
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


	public String display() {
		   return name + empNum + email;
	   }
	
	public void addCompany(Company cmp) {
		companies.add(cmp);
	}
	
	public static List<Company> findAllCompanies() {
		return new ArrayList<Company>(companies);
	}

	public static List<Company> findByID(Integer id) {
	    List<Company> results = new ArrayList<Company>();
	    for (Company candidate : companies) {
	      if (candidate.id.equals(id)) {
	        results.add(candidate);
	      }
	    }
	    return results;
	  }
	
	  public static Company findCompanyByName(String name) {
		  
		  for (Company candidates : companies) {
		      if (Company.name.equals(name)) {
		        return candidates;
		      }
		    }
		    return null;
		  }
	
	public static List<Company> findByName(String term){
		List<Company> results = new ArrayList<Company>();
		for (Company choice: companies) {
			if(Company.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(choice);
			}
		}
		return results;
	}
	
	// Remove company
    public static boolean remove(Company company) {
    	return Company.remove(company);
    }
	
	//SAVE
	public static void save(Company company) {
		//companies.remove(findCompanyByName(name));
	    companies.add(company);
	  }

	

}
