/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.ClienteRespuesta;

/**
 *
 * @author julia
 */
@Stateless
public class ClienteRespuestaFacade extends AbstractFacade<ClienteRespuesta> {

    @PersistenceContext(unitName = "SC-INML-11PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteRespuestaFacade() {
        super(ClienteRespuesta.class);
    }
    
}
