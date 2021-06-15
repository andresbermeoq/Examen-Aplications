package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.comidaFacade;
import ec.edu.ups.entidad.comida;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class comidaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private comidaFacade comidaFacade;
	
	private String nombre;
	private Double precioUnitario;
	
	private List<comida> comidas;
	
	@PostConstruct
	public void init() {
		comidas = comidaFacade.findAll();
	}
	
	
	public comidaBean() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public List<comida> getComidas() {
		return comidas;
	}


	public void setComidas(List<comida> comidas) {
		this.comidas = comidas;
	}
	
	
	public void addComida() {
		comidaFacade.create(new comida(this.nombre, this.precioUnitario));
		comidas = comidaFacade.findAll();
	}

	

	
}
