/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.theo.tpcustomerapp.service;

import fr.theo.tpcustomerapp.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author theo
 */
@RequestScoped
public class DiscountManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    /**
     * méthode qui retourne le Discount qui a un certain code
     * @param code
     * @return 
     */
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    public List<Discount> getAllDiscounts() {
       Query query = em.createNamedQuery("Discount.findAll");
       return query.getResultList();
    }
}
