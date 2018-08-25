/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EncuestaAspecto;

/**
 *
 * @author julia
 */
@Stateless
public class EncuestaAspectoFacade extends AbstractFacade<EncuestaAspecto> {

    @PersistenceContext(unitName = "SC-INML-11PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaAspectoFacade() {
        super(EncuestaAspecto.class);
    }
    
}
