package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Pedidos" database table.
 * 
 */
@Entity
@Table(name="\"Pedidos\"")
@NamedQuery(name="pedido.findAll", query="SELECT p FROM pedido p")
public class pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal iva;

	@Column(name="nombre_cliente")
	private String nombreCliente;

	private Integer numero;

	private String observaciones;

	private BigDecimal subtotal;

	@Column(name="tarjeta_fk")
	private Integer tarjetaFk;

	private BigDecimal total;

	//bi-directional many-to-one association to comida
	@OneToMany(mappedBy="pedido")
	private List<comida> comidas;

	//bi-directional one-to-one association to tarjeta
	@OneToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private tarjeta tarjeta;

	public pedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getTarjetaFk() {
		return this.tarjetaFk;
	}

	public void setTarjetaFk(Integer tarjetaFk) {
		this.tarjetaFk = tarjetaFk;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<comida> getComidas() {
		return this.comidas;
	}

	public void setComidas(List<comida> comidas) {
		this.comidas = comidas;
	}

	public comida addComida(comida comida) {
		getComidas().add(comida);
		comida.setPedido(this);

		return comida;
	}

	public comida removeComida(comida comida) {
		getComidas().remove(comida);
		comida.setPedido(null);

		return comida;
	}

	public tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

}