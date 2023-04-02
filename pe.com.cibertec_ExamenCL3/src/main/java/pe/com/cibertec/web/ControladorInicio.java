/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.servicio.CustomerService;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class ControladorInicio {

@Autowired
private CustomerService customerService; 

    
    @GetMapping("/")
    public String inicio(Model model){
      
        var customers = customerService.listarCustomers();
        
        model.addAttribute("customers", customers);
        
        
        log.info("ejecutando controlador spring con MVC ");
     
    return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Customer customer){
        
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Customer customer, Errors errores){
        if(errores.hasErrors()){
        return "modificar";
        }
        
        customerService.guardar(customer);
        return "redirect:/";
     }

    @GetMapping("/editar/{id_customer}")
    public String editar(Customer customer, Model model){
        customer = customerService.encontrarCustomer(customer);
        
        model.addAttribute("customer", customer);
        
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_producto}")
    public String eliminar(Customer customer, Model model){
        customerService.eliminar(customer);
        
        return "redirect:/";
    }

    
    
}