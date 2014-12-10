/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.ejemplo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danielfuentes
 */
@Stateless
public class CdsFacade extends AbstractFacade<Cds> {
    @PersistenceContext(unitName = "com.lenticulares_ejemplo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CdsFacade() {
        super(Cds.class);
    }
    
}
