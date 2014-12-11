/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmobiliaria;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author danielfuentes
 */
@Named(value = "tLoginController")
@SessionScoped
public class TLoginController implements Serializable {
private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Creates a new instance of TLoginController
     */
    public TLoginController() {
        
        this.perfil = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
        System.out.println("perfil "+this.perfil);
    }
    
}
