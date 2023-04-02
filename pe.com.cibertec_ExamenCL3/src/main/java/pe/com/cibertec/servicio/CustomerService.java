/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import pe.com.cibertec.domain.Customer;

/**
 *
 * @author USUARIO
 */
public interface CustomerService {
    
    public List<Customer> listarCustomers();
    public void guardar(Customer pro);
    public void eliminar(Customer pro);
    public Customer encontrarCustomer(Customer pro);
}
