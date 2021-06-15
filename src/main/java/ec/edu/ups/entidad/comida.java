package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Comida", schema = "public")
@NamedQuery(name="comida.findAll", query="SELECT c FROM comida c")
public class comida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	@Column(name="precio_unitario")
	private Double precioUnitario;
	
	
	public comida() {
	}
		
	public comida(String nombre, Double precioUnitario) {
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
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

	public Double getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "comida [id=" + id + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + "]";
	}
	
	

}