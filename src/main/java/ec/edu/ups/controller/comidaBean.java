package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.comidaFacade;
import ec.edu.ups.ejb.tarjetaFacade;
import ec.edu.ups.entidad.comida;
import ec.edu.ups.entidad.tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class comidaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private comidaFacade comidaFacade;
	
	@EJB
	private tarjetaFacade tarjetaFacade;
	
	private String nombre;
	private Double precioUnitario;
	
	private List<tarjeta> tarjetas;
	
	@PostConstruct
	public void init() {
		tarjetas = tarjetaFacade.findAll();
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
	
	public List<tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	public String addComida() {
		
		return null;
	}


	
	
	
	
	
	
	
	
	
	

	
}
