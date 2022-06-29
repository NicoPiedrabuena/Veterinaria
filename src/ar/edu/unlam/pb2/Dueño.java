package ar.edu.unlam.pb2;

import java.util.HashSet;

public class Dueño {

	private Integer dni;
	private String nombre;
	private HashSet<Mascota> mascotas;

	public Dueño(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.mascotas = new HashSet<Mascota>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMascota(Mascota mascota) throws MascotaDuplicadaException {
		if (mascotas.contains(mascota)) {
			throw new MascotaDuplicadaException();
		}
		mascotas.add(mascota);
	}

	public HashSet<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(HashSet<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota traerMascotaPorId(Integer idMascota) throws MascotaNoEncontradaException {
		for (Mascota mascota : mascotas) {
			if (mascota.getId().equals(idMascota)) {
				return mascota;
			}

		}
		throw new MascotaNoEncontradaException();
	}

}
