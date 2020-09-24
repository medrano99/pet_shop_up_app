/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import udem.edu.co.entities.Vendedor;

/**
 *
 * @author MEDRANO
 */
@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> {

    @PersistenceContext(unitName = "appWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedorFacade() {
        super(Vendedor.class);
    }
    
    @Override
    public boolean login(Vendedor vendedor){
        String consulta = "SELECT v FROM Vendedor v WHERE v.user = ?1 AND v.pass = ?2";
        Query query = em.createQuery(consulta);
        query.setParameter(1,vendedor.getUser());
        query.setParameter(2,vendedor.getPass());
        List <Vendedor> respuesta = query.getResultList();
        return !respuesta.isEmpty();
    
    }
}
