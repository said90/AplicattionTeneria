package com.tenerianoe.controller;

import com.tenerianoe.ejb.DepartamentoFacadeLocal;
import com.tenerianoe.ejb.MunicipioFacadeLocal;
import com.tenerianoe.ejb.ProveedorFacadeLocal;
import com.tenerianoe.model.Departamento;
import com.tenerianoe.model.Municipio;
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
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    @EJB
    private MunicipioFacadeLocal municipioEJB;

    private Municipio municipio;
    private Proveedor proveedor;
    private Departamento departamento;

    private List<Proveedor> proveedores;
    private List<Departamento> departamentos;
    private List<Municipio> municipios;

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        departamento = new Departamento();
        proveedores = proveedorEJB.findAll();
        departamentos = departamentoEJB.findAll();
        municipios = municipioEJB.findAll();
        this.listarDepartamentos();
    }

    /**
     * Metodo para registrar un proveedor
     *
     */
    public void registrar() {
        try {
            this.proveedor.setDepartamento(departamento);
            proveedorEJB.create(proveedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));

        }
    }

    public void listarDepartamentos() {
        try {
            departamentos = departamentoEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
}
