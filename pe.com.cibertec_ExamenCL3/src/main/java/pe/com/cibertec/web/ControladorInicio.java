/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.servicio.CustomerService;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api")
public class ControladorInicio {

@Autowired
private CustomerService customerService; 

    
    @GetMapping("/custom")
    public List<Customer> listarCustomers(){    
        var customers = customerService.listarCustomers();  
        return customers;
    }
    
    @PostMapping("/custom")
    public void agregarCustomer( @RequestBody Customer customer){
                customerService.guardar(customer);  
    }
    

    @GetMapping("/custom/{id_customer}")
    public Customer editarCustomer(@PathVariable("id_customer") Long id){
       Customer customer = new Customer();
       customer.setId_customer(id);
               
     return     customerService.encontrarCustomer(customer);
        
    }
    
    @DeleteMapping("/custom/{id_customer}")
    public void eliminarCustomer(@PathVariable("id_customer") Long id){
       Customer customer = new Customer();
       customer.setId_customer(id);
       customerService.eliminar(customer);
    }
    

    
}