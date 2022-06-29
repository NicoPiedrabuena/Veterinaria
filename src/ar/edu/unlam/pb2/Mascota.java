package ar.edu.unlam.pb2;

import java.util.Objects;

public class Mascota implements Comparable <Mascota> {

	private String nombre;
	private Integer id;
	private TipoDeMascota tipo;
	private String apodo;

	public Mascota(String nombre, Integer id,String apodo, TipoDeMascota tipo) {
		this.nombre= nombre;
		this.id = id;
		this.tipo = tipo;
		this.apodo = apodo;
	}

	public String getNombre() {
		return nombre;
	}
	

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDeMascota getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMascota tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(Mascota o) {
		return this.apodo.compareTo(o.getApodo());
	}
	

}
