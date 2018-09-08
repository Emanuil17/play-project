package controllers;

import javax.inject.Inject;

import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import org.emo.business.Company;
import org.emo.business.Storage;
import java.util.*;
import views.html.company.*;


public class Application extends Controller {
	
	@Inject
	FormFactory formFactory;
	 
	public Result index(){
		return redirect (routes.Application.addCompany());
	}
	
	public Result list() {
		List<Company> companies = Storage.findAllCompanies();
		return ok(list.render(companies));
		}
	
	// Add Company process
	public Result addCompany() {
		Form<Company> companyForm = formFactory.form(Company.class); // Creating form of the Company class
		return ok(details.render(companyForm));
	}
	
	// Save to a temporary storage
	public Result save() {	
		Form<Company> companyForm = formFactory.form(Company.class).bindFromRequest();//bindFormRequest extracts the information posted in the form
		Company company = companyForm.get(); // Get company out of the form
		Storage.save(companyForm.get()); // Save the company to the storage
		return redirect(routes.Application.list());
	}
	
	// Show list of all companies
	public Result show() {
		final List<Company> companies = Storage.findAllCompanies();
			if (companies == null) {
				return notFound("Company not found");
			}
		return ok(list.render(companies));
	}
	
	// Delete single company from list
	public Result delete(Integer id) {
    	Company company = Storage.findByID(id);
    	if (company == null) {
    		return notFound("Company not found");
    	}
    	Logger.debug("In controller method delete");
    	Storage.remove(company); 
    	return redirect(routes.Application.list());
    }
	
	// Show the details for a single  company
	public Result detailedResults(Integer id) {
		Company company  = Storage.findByID(id);
		if (company == null) {
			return notFound("Company not found");
		}
		return ok(show.render(company));
	}

	//Dashboard welcome message
    public Result welcome(String first, String last) {
    	return ok(welcome.render(first,last));
    }
    
    // Edit company
 	public Result edit (Integer id) {
 		// Retrieve the company by id
 		Company editCompany = Storage.findByID(id);
 			if (editCompany ==null) {
 				return notFound("Company not found!");
 			}
 		//Craete a form based on the Company class
 		Form<Company> companyForm =formFactory.form(Company.class).fill(editCompany);
 		// Render the Edit company, passign the form object
 		return ok(edit.render(companyForm));
 	}
 	
 	
 	// Update the list with a new company PROBLEM
    public Result update() {
		Form<Company> companyForm = formFactory.form(Company.class).bindFromRequest();
		Company company = companyForm.get();
		Company Oldcompany = Storage.findByID(company.id);
		if (company == null) {
			return notFound ("Company not found");
		}
		Oldcompany.id = company.id; 
		Oldcompany.name = company.name;
		Oldcompany.empNum = company.empNum;
		Oldcompany.email = company.email; 
		Oldcompany.productID = company.productID;
		Oldcompany.productName = company.productName;
		Oldcompany.productPrice = company.productPrice;
		
		return redirect(routes.Application.list());
	}
    
}
