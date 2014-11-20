/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Entities.RangoPrecio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danielfuentes
 */
@Stateless
public class RangoPrecioFacade extends AbstractFacade<RangoPrecio> {
    @PersistenceContext(unitName = "InmobiliariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RangoPrecioFacade() {
        super(RangoPrecio.class);
    }
    
}
