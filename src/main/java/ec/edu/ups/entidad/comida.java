package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "Comida" database table.
 * 
 */
@Entity
@Table(name="\"Comida\"")
@NamedQuery(name="comida.findAll", query="SELECT c FROM comida c")
public class comida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to pedido
	@ManyToOne
	@JoinColumn(name="pedidos_fk")
	private pedido pedido;

	public comida() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(pedido pedido) {
		this.pedido = pedido;
	}

}