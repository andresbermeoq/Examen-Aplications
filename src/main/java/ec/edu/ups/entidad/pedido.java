package ec.edu.ups.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pedido", schema = "public")
@NamedQuery(name="pedido.findAll", query="SELECT p FROM pedido p")
public class pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date date;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	private Double subtotal;
	private Double iva;
	private Double total;
	private String observaciones;
	
	@OneToMany(mappedBy = "pedido")
	private List<comida> comidas;
	
	
	@ManyToOne
	@JoinColumn(name = "tarjeta_id")
	private tarjeta tarjeta;


	public pedido() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
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


	public List<comida> getComidas() {
		return comidas;
	}


	public void setComidas(List<comida> comidas) {
		this.comidas = comidas;
	}


	public tarjeta getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}


	@Override
	public String toString() {
		return "pedido [id=" + id + ", date=" + date + ", nombreCliente=" + nombreCliente + ", subtotal=" + subtotal
				+ ", iva=" + iva + ", total=" + total + ", observaciones=" + observaciones + ", comidas=" + comidas
				+ ", tarjeta=" + tarjeta + "]";
	}
	
	
	
	
	
	
	

}
