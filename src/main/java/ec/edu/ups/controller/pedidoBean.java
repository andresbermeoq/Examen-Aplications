package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


import ec.edu.ups.ejb.comidaFacade;
import ec.edu.ups.ejb.pedidoFacade;
import ec.edu.ups.ejb.tarjetaFacade;
import ec.edu.ups.entidad.comida;
import ec.edu.ups.entidad.pedido;
import ec.edu.ups.entidad.tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class pedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private tarjetaFacade tarjetaFacade;
	private String idTarjeta;
	private tarjeta tarjeta;
	private List<tarjeta> tarjetas;
	
	private String nombreCliente;
	private Double subtotal;
	private Double iva;
	private Double total;
	private String observaciones;
	private Date fecha;
	
	
	@EJB
	private comidaFacade comidaFacade;
	private String nombreComida;
	private Double precioUnitario;
	private List<comida> comidas;
	private comida comidaPedido;
	
	
	@EJB
	private pedidoFacade pedidoFacade;
	private pedido pedido;
	
	private List<pedido> pedidos;
	
	private String mensaje;
	
	@PostConstruct
	public void init() {
		setTarjetas(tarjetaFacade.findAll());
		comidas = new ArrayList<>();
		pedidos = pedidoFacade.findAll();
		comidaPedido = new comida();
		pedido = new pedido();
	}

	public tarjetaFacade getTarjetaFacade() {
		return tarjetaFacade;
	}

	public void setTarjetaFacade(tarjetaFacade tarjetaFacade) {
		this.tarjetaFacade = tarjetaFacade;
	}

	public tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public void addComida() {
		comidaPedido.setNombre(this.nombreComida);
		comidaPedido.setPrecioUnitario(this.precioUnitario);
		comidas.add(comidaPedido);
		
		Double sum = 0.0;
		
		for(comida d: comidas) {
			sum += d.getPrecioUnitario();
		}
		
		this.subtotal = sum;
		this.iva = (12 * this.subtotal) / 100;
		this.total = this.subtotal + this.iva;
		
		comidaPedido = new comida();
	}
	
	
	public void addPedido() {
		tarjeta = tarjetaFacade.find(Integer.valueOf(getIdTarjeta()));	
		pedido.setTarjeta(tarjeta);
		pedido.setNombreCliente(nombreCliente);
		pedido.setTotal(total);
		pedido.setSubtotal(subtotal);
		pedido.setIva(iva);
		pedido.setComidas(comidas);
		pedido.setDate(new java.sql.Date(fecha.getDate()));
		pedido.setObservaciones(observaciones);
		
		setMensaje(pedido.toString());
		
		pedidoFacade.create(pedido);	
		
	}

	public List<tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public String getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public List<comida> getComidas() {
		return comidas;
	}

	public void setComidas(List<comida> comidas) {
		this.comidas = comidas;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public comidaFacade getComidaFacade() {
		return comidaFacade;
	}

	public void setComidaFacade(comidaFacade comidaFacade) {
		this.comidaFacade = comidaFacade;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public pedido getPedido() {
		return pedido;
	}

	public void setPedido(pedido pedido) {
		this.pedido = pedido;
	}

	public String getNombreComida() {
		return nombreComida;
	}

	public void setNombreComida(String nombreComida) {
		this.nombreComida = nombreComida;
	}

	public comida getComidaPedido() {
		return comidaPedido;
	}

	public void setComidaPedido(comida comidaPedido) {
		this.comidaPedido = comidaPedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	

}
