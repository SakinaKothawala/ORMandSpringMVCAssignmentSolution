package com.greatlearning.crm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customers")

public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "list-customers";
		
	}
	
	@RequestMapping("/new")
	public String showFormForAdd( Model model ) {
		Customer customer = new Customer();
		
		model.addAttribute( "newCustomer", true );
		model.addAttribute( "customer", customer );
		
		return "edit-customer";
	}
	
	@RequestMapping("/edit")
	public String showFormForEdit(
		@RequestParam("id") int id,
		Model model
	) {
		Customer customer = customerService.findById( id );
		
		model.addAttribute( "newCustomer", false );
		model.addAttribute( "customer", customer );
		
		return "edit-customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(
		@RequestParam("id") int id,
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("email") String email
	) {
		Customer customer = null;
		
		if( id == 0 ) {
			customer = new Customer( firstname, lastname, email );
		} else {
			customer = customerService.findById( id );
			customer.setFirstname( firstname );
			customer.setLastname( lastname );
			customer.setEmail( email ); 
		}
		
		customerService.save( customer );
				
		return "redirect:/customers/list";
	}
	
	@RequestMapping("/delete")
	public String showFormForAdd( @RequestParam("id") int id ) {
		customerService.deleteById( id );
		
		return "redirect:/customers/list";
	}
}


