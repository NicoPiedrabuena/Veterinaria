package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Atencion {

	private Dueño dueño;
	private Mascota mascota;
	private ArrayList<Medicamento>medicamentos;
	private Double precio;

	public Atencion(Dueño dueño, Mascota mascota, Double precio) {
		medicamentos = new ArrayList<Medicamento>();
		this.dueño = dueño;
		this.mascota = mascota;
		this.precio = precio;
	}

	public Double getPrecio() {
		for (Medicamento medicamento : medicamentos) {
			this.precio += medicamento.getPrecio();
		}
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Dueño getDueño() {
		return dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	public void agregarMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}

	

}
