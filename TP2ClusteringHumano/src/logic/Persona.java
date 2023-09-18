package logic;

public class Persona {
	private String nombre;
	private int interesDeportes;
	private int interesMusica;
	private int interesFarandula;
	private int interesCiencia;
	
	public Persona(String nombre, int interesDeportes, int interesMusica, int interesFarandula, int interesCiencia) {
		if (!(interesDeportes<=5&&interesDeportes>=1)) {
			throw new IllegalArgumentException("El interes en los deportes es invalido");
		}
		if (!(interesMusica<=5&&interesMusica>=1)) {
			throw new IllegalArgumentException("El interes en musica es invalido");
		}
		if (!(interesFarandula<=5&&interesFarandula>=1)) {
			throw new IllegalArgumentException("El interes en la farandula es invalido");
		}
		if (!(interesCiencia<=5&&interesCiencia>=1)) {
			throw new IllegalArgumentException("El interes en ciencias es invalido");
		}
		this.nombre=nombre;
		this.interesDeportes=interesDeportes;
		this.interesMusica=interesMusica;
		this.interesFarandula=interesFarandula;
		this.interesCiencia=interesCiencia;
	}
	//CONSULTAR-----------------------------------------------------------------
	public String consultarNombre() {
		return this.nombre;
	}
	public int consultarInteresDeportes() {
		return this.interesDeportes;
	}
	public int consultarInteresMusica() {
		return this.interesMusica;
	}
	public int consultarInteresFarandula() {
		return this.interesFarandula;
	}
	public int consultarInteresCiencia() {
		return this.interesCiencia;
	}
}