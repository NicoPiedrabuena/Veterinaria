package ar.edu.unlam.pb2;


import java.util.HashSet;
import java.util.TreeSet;



public class Veterinaria {

	private String nombre;
	private HashSet<Due�o> due�osConMascotas;
	private HashSet<Atencion> atenciones;

	public Veterinaria(String nombre) {
		this.setNombre(nombre);
		due�osConMascotas = new HashSet<Due�o>();
		atenciones = new HashSet<Atencion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void recepcionarDue�o(Due�o due�o) {
		due�osConMascotas.add(due�o);

	}

	public HashSet<Due�o> getDue�osConMascotas() {
		return due�osConMascotas;
	}

	public void setDue�osConMascotas(HashSet<Due�o> due�osConMascotas) {
		this.due�osConMascotas = due�osConMascotas;
	}

	public Due�o traerDue�oPorDni(Integer dni) throws DuenioInexistenteException {
		for (Due�o due�o : due�osConMascotas) {
			if (due�o.getDni().equals(dni)) {
				return due�o;
			}
		}
		throw new DuenioInexistenteException();
	}

	public Due�o traerDue�o(Integer idDue�o) {
		for (Due�o due�o : due�osConMascotas) {
			if (due�o.getDni().equals(idDue�o)) {
				return due�o;
			}
		}
		return null;
	}

	public void iniciarAtencion(Integer dni, Integer idMascota, Double precio) throws MascotaNoEncontradaException, DuenioInexistenteException {
		Due�o due�o = traerDue�oPorDni(dni);
		Mascota mascota = due�o.traerMascotaPorId(idMascota);
		atenciones.add(new Atencion(due�o,mascota,precio));
	}

	public HashSet<Atencion> getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(HashSet<Atencion> atenciones) {
		this.atenciones = atenciones;
	}
	
	public Atencion traerAtencionPorDniDelDue�o(Integer dni) {
		for (Atencion atencion : atenciones) {
			if(atencion.getDue�o().getDni().equals(dni)) {
				return atencion;
			}
		}
		return null;
	}
	public TreeSet<Mascota> obtenerListaDeMascotasDeUnDue�oOrdenadasPorApodo(Integer dni) throws DuenioInexistenteException {
		TreeSet<Mascota> ordenada = new TreeSet<>();
		 ordenada.addAll(traerDue�oPorDni(dni).getMascotas());
		return ordenada;
	}

}
