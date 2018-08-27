package controllers;

import javax.inject.Inject;

import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import org.emo.business.Company;
import org.emo.business.Product;
import java.util.*;
import views.html.company.*;


public class Application extends Controller {
	
	@Inject
	FormFactory formFactory;
	 
	public Result index(){
		return redirect (routes.Application.list());
	}
	
	// Show list of companies
	public Result list() {
		List<Company> companies = Company.findAllCompanies();
		List<Product> products = Product.findAllProducts();
		return ok(list.render(companies,products));
		}
	
	// Add Company
	public Result addCompany() {
		Form<Company> companyForm = formFactory.form(Company.class);
		Form<Product> productForm = formFactory.form(Product.class);
		return ok(details.render(companyForm,productForm));
	}
	
	
	// Save to a temporary storage
		public Result save() {	
			Form<Company> companyForm = formFactory.form(Company.class).bindFromRequest();//bindFormRequest extracts the information posted in the form
			Form<Product> productForm = formFactory.form(Product.class).bindFromRequest();
			Company company = companyForm.get();
			Product product = productForm.get();// Get the extracted information
			Logger.debug("companyForm.name = {}", company.getName());
			Logger.debug("productForm.id = {}", product.getProductID());
			Company.save(company);
			Product.save(product);
			return redirect(routes.Application.list());
		    }
	
		
	
	public Result update() {
		Form<Company> companyForm = formFactory.form(Company.class).bindFromRequest();
		Company company = companyForm.get();
		Form<Product> productForm = formFactory.form(Product.class).bindFromRequest();
		Product product = productForm.get();
		List<Company> oldCompany = Company.findByID(company.id);
		List<Product> oldProduct = Product.findByID(product.id);
		
		if (oldCompany == null && oldProduct == null) {
			return notFound ("Company not found");
		}
			
		
		return redirect(routes.Application.list());
	}
	
	
   // Show a particular company found by name
	public Result show(Integer id) {
		final Optional<Company> company = Company.findByID(id).stream().findAny();
		final Optional<Product> product = Product.findByID(id).stream().findAny();
		if (company == null && product==null) {
			return notFound("Company not found");
		}
		return ok(show.render(company.get(),product.get()));
	}
	
	//Dashboard
    public Result welcome(String first, String last) {
    	return ok(welcome.render(first,last));
    }
    
    
    
    
    
 // PROBLEM
 	public Result edit(Integer id) {
 		List<Company> company = Company.findByID(id);
 		List<Product> product = Product.findByID(id);
 		if(company == null && product ==null) {
 			return notFound("Book not found");
 		}
 		Form<Company> companyForm = formFactory.form(Company.class).fill((Company) company);
 		Form<Product> productForm = formFactory.form(Product.class).fill((Product) product);
 		 
 		return ok(edit.render(companyForm,productForm));
 	}
    

    
    
    //Problem
    public Result delete(String name) {
    	final Company company = (Company) Company.findByName(name);
    	if (company == null) {
    		return notFound("Company not found");
    	}
    	Company.remove(company); 
    	return redirect(routes.Application.list());
    }
    
}
