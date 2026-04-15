package dev.tk.tk_java_full_stack_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.tk.tk_java_full_stack_app.model.Customer;
import dev.tk.tk_java_full_stack_app.repository.CustomerRepository;


@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Customer> customers = customerRepository.findByName(query);
        customers.addAll(customerRepository.findByEmail(query));
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "index";
    }
    
    
    @PostMapping("/create")
    public String addCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saved customer: " + customer);
        customerRepository.save(customer);
        return "redirect:/";
    }


    
}