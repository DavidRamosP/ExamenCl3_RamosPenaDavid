/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.Dao.CustomerDao;

/**
 *
 * @author USUARIO
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Customer> listarCustomers() {
     return (List<Customer>) customerDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Customer cus) {
        customerDao.save(cus);
    }

    @Override
    @Transactional
    public void eliminar(Customer cus) {
     customerDao.delete(cus);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer encontrarCustomer(Customer cus) {
       return customerDao.findById(cus.getId_customer()).orElse(null);
    }
    
}
