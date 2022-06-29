package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		assertNotNull(veterinaria);
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		assertNotNull(due�o);
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		// El tipo de mascota puede ser solamente doméstica y exótica (enum)
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		assertNotNull(mascota);
		assertEquals((Integer)1,mascota.getId());
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws MascotaDuplicadaException, DuenioInexistenteException {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		Mascota mascota1 = new Mascota ("Nicole",1,"meme",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�oPorDni(38266294).agregarMascota(mascota);
		veterinaria.traerDue�oPorDni(38266294).agregarMascota(mascota1);
		assertEquals((Integer)2,(Integer)veterinaria.traerDue�oPorDni(38266294).getMascotas().size());
	}
	
	@Test (expected =MascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException() throws MascotaDuplicadaException, DuenioInexistenteException {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		Mascota mascota1 = new Mascota ("Nicole",1,"meme",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�oPorDni(38266294).agregarMascota(mascota);
		veterinaria.traerDue�oPorDni(38266294).agregarMascota(mascota1);
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		Medicamento medicamento = new Medicamento (1,"amoxidal", 100.0);
		assertEquals("amoxidal", medicamento.getDescripcion());
	}
	
	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		veterinaria.recepcionarDue�o(due�o);
		assertEquals((Integer)1 ,(Integer)veterinaria.getDue�osConMascotas().size());
	}
	
	@Test
	public void queSePuedaCrearUnaAtencionConIdDeDuenioIdDeMascotaYPrecio() throws DuenioInexistenteException, MascotaNoEncontradaException, MascotaDuplicadaException{
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�o(38266294).agregarMascota(mascota);
		veterinaria.iniciarAtencion(38266294,1,0.0);
		assertEquals ((Integer)1,(Integer)veterinaria.getAtenciones().size());
	}
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() throws MascotaDuplicadaException, MascotaNoEncontradaException, DuenioInexistenteException {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�o(38266294).agregarMascota(mascota);
		veterinaria.iniciarAtencion(38266294,1,0.0);
		
		Medicamento medicamento = new Medicamento (1,"amoxidal", 100.0);
		Medicamento medicamento1 = new Medicamento (2,"suero", 300.0);
		
		veterinaria.traerAtencionPorDniDelDue�o(38266294).agregarMedicamento(medicamento);
		veterinaria.traerAtencionPorDniDelDue�o(38266294).agregarMedicamento(medicamento1);
		assertEquals((Integer)2,(Integer)veterinaria.traerAtencionPorDniDelDue�o(38266294).getMedicamentos().size());
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() throws MascotaDuplicadaException, MascotaNoEncontradaException, DuenioInexistenteException {
		// El precio total de la atencion será la suma del precio de la atencion mas la suma del precio de todos los medicamentos
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�o(38266294).agregarMascota(mascota);
		veterinaria.iniciarAtencion(38266294,1,0.0);
		
		Medicamento medicamento = new Medicamento (1,"amoxidal", 100.0);
		Medicamento medicamento1 = new Medicamento (2,"suero", 300.0);
		
		veterinaria.traerAtencionPorDniDelDue�o(38266294).agregarMedicamento(medicamento);
		veterinaria.traerAtencionPorDniDelDue�o(38266294).agregarMedicamento(medicamento1);
		
		assertEquals((Double)400.0,veterinaria.traerAtencionPorDniDelDue�o(38266294).getPrecio());
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() throws MascotaDuplicadaException, DuenioInexistenteException {
		Veterinaria veterinaria = new Veterinaria("Del oeste");
		Due�o due�o = new Due�o(38266294,"Piedrabuena Walter");
		Mascota mascota = new Mascota ("Eli",1,"chicha",TipoDeMascota.DOMESTICA);
		Mascota mascota1 = new Mascota ("Nicole",2,"meme",TipoDeMascota.DOMESTICA);
		veterinaria.recepcionarDue�o(due�o);
		veterinaria.traerDue�o(38266294).agregarMascota(mascota);
		veterinaria.traerDue�o(38266294).agregarMascota(mascota1);
	
		assertEquals("chicha",veterinaria.obtenerListaDeMascotasDeUnDue�oOrdenadasPorApodo(38266294).first().getApodo());
		assertEquals("meme",veterinaria.obtenerListaDeMascotasDeUnDue�oOrdenadasPorApodo(38266294).last().getApodo());
	}
	/*
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() {
		
	}*/
	
}
