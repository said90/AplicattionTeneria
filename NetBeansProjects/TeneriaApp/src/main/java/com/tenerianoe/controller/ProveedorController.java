package com.tenerianoe.controller;

import com.tenerianoe.ejb.ProveedorFacadeLocal;
import com.tenerianoe.model.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author said
 */
@Named
@ViewScoped
public class ProveedorController implements Serializable {

    @EJB
    private ProveedorFacadeLocal proveedorEJB;

    private Proveedor proveedor;
    private List<Proveedor> proveedores;

    @PostConstruct
    public void init() {

        proveedor = new Proveedor();
        proveedores = proveedorEJB.findAll();

    }

    /**
     * Metodo para registrar un proveedor
     *
     */
    public void registrar() {
        try {
            proveedorEJB.create(proveedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));

        }
    }
    
     public void modificar() {
        try {
            proveedorEJB.edit(proveedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));

        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
