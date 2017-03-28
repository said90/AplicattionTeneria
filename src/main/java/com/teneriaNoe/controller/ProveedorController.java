
package com.teneriaNoe.controller;



import com.teneriaNoe.ejb.ProveedorFacadeLocal;
import com.teneriaNoe.model.Proveedor;
import java.io.Serializable;
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
    
    @PostConstruct
    public void init(){
    proveedor=new Proveedor();
    }
    
    public void registrar(){
        try {
           proveedorEJB.create(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

}
