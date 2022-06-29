package ar.edu.unlam.pb2;

public class Medicamento {

	private Integer id;
	private String descripcion;
	private Double precio;

	public Medicamento(Integer id, String descripcion, Double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	

}
