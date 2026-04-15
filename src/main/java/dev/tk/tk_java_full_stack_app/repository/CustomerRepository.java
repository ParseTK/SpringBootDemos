package dev.tk.tk_java_full_stack_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.tk.tk_java_full_stack_app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByName(String name);
    public List<Customer> findByEmail(String email);
    public List<Customer> findById(int id);
}



