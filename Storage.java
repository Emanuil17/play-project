package org.emo.business;

import java.util.*;

public class Storage {
	public static List<Company> companies;
	
	static {
		companies = new ArrayList<Company>();
		companies.add(new Company());
		
	}
	//Default constructor
	public Storage(){}
	
	//Constructor - List company
	public Storage(List<Company> companies) {
		Storage.companies = companies;
	}

	//Find a company by id
	public static Company findByID(Integer id){
		for (Company company : companies) {
		     if (id.equals(company.id)) {
		    	 return company;
		    }
		 }
			return null;
	}
	
	// Add company
	public void addCompany(Company company) {
		companies.add(company);
	}
	
	//Save a company to the list
	public static void save(Company company) {
		companies.add(company);
	}

	//Find all companies
	public static List<Company> findAllCompanies() {
		return new ArrayList<Company>(companies);
	}
	
	
	// Delete a sigle company from the collection
	public static boolean remove(Company company) {
		return companies.remove(company);
	}
	
}


	
