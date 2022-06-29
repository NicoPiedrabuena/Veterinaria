package ar.edu.unlam.pb2;


import java.util.HashSet;
import java.util.TreeSet;



public class Veterinaria {

	private String nombre;
	private HashSet<Dueño> dueñosConMascotas;
	private HashSet<Atencion> atenciones;

	public Veterinaria(String nombre) {
		this.setNombre(nombre);
		dueñosConMascotas = new HashSet<Dueño>();
		atenciones = new HashSet<Atencion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void recepcionarDueño(Dueño dueño) {
		dueñosConMascotas.add(dueño);

	}

	public HashSet<Dueño> getDueñosConMascotas() {
		return dueñosConMascotas;
	}

	public void setDueñosConMascotas(HashSet<Dueño> dueñosConMascotas) {
		this.dueñosConMascotas = dueñosConMascotas;
	}

	public Dueño traerDueñoPorDni(Integer dni) throws DuenioInexistenteException {
		for (Dueño dueño : dueñosConMascotas) {
			if (dueño.getDni().equals(dni)) {
				return dueño;
			}
		}
		throw new DuenioInexistenteException();
	}

	public Dueño traerDueño(Integer idDueño) {
		for (Dueño dueño : dueñosConMascotas) {
			if (dueño.getDni().equals(idDueño)) {
				return dueño;
			}
		}
		return null;
	}

	public void iniciarAtencion(Integer dni, Integer idMascota, Double precio) throws MascotaNoEncontradaException, DuenioInexistenteException {
		Dueño dueño = traerDueñoPorDni(dni);
		Mascota mascota = dueño.traerMascotaPorId(idMascota);
		atenciones.add(new Atencion(dueño,mascota,precio));
	}

	public HashSet<Atencion> getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(HashSet<Atencion> atenciones) {
		this.atenciones = atenciones;
	}
	
	public Atencion traerAtencionPorDniDelDueño(Integer dni) {
		for (Atencion atencion : atenciones) {
			if(atencion.getDueño().getDni().equals(dni)) {
				return atencion;
			}
		}
		return null;
	}
	public TreeSet<Mascota> obtenerListaDeMascotasDeUnDueñoOrdenadasPorApodo(Integer dni) throws DuenioInexistenteException {
		TreeSet<Mascota> ordenada = new TreeSet<>();
		 ordenada.addAll(traerDueñoPorDni(dni).getMascotas());
		return ordenada;
	}

}
