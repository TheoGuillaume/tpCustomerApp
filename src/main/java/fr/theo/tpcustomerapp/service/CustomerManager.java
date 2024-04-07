/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.theo.tpcustomerapp.service;

import fr.theo.tpcustomerapp.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
/**
 *Façade pour gérer les Customers.
 * @author theo
 */
@RequestScoped
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Methode pour récupérer tous les employés
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    /**
     * methode pour modifier un employée
     * @param customer
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
      return em.merge(customer);
    }
    
    /**
     * methode pour enregistrer un employer
     * @param customer 
     */
    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }
}
