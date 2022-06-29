package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Atencion {

	private Due�o due�o;
	private Mascota mascota;
	private ArrayList<Medicamento>medicamentos;
	private Double precio;

	public Atencion(Due�o due�o, Mascota mascota, Double precio) {
		medicamentos = new ArrayList<Medicamento>();
		this.due�o = due�o;
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

	public Due�o getDue�o() {
		return due�o;
	}

	public void setDue�o(Due�o due�o) {
		this.due�o = due�o;
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
