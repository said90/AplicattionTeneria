package com.teneriaNoe.controller;

import com.teneriaNoe.ejb.ProveedorFacadeLocal;
import com.teneriaNoe.model.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bfranco
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
        proveedores=proveedorEJB.findAll();
    }

    public void registrar() {
        try {
            proveedorEJB.create(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Getter y Setters

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
