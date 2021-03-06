package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Tarjeta", schema = "public")
@NamedQuery(name="tarjeta.findAll", query="SELECT t FROM tarjeta t")
public class tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String cvv;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_caducidad")
	private Date fechaCaducidad;

	@Column(name="nombre_titular")
	private String nombreTitular;

	@Column(name="numero_tarjeta")
	private String numeroTarjeta;
	
	@OneToMany(mappedBy = "tarjeta")
	private List<pedido> pedidos;
	
	public tarjeta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public List<pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "tarjeta [id=" + id + ", cvv=" + cvv + ", fechaCaducidad=" + fechaCaducidad + ", nombreTitular="
				+ nombreTitular + ", numeroTarjeta=" + numeroTarjeta + ", pedidos=" + pedidos + "]";
	}
	
	
	
}