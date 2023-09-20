package logic;

public class Persona {
	private String nombre;
	private int interesDeportes;
	private int interesMusica;
	private int interesFarandula;
	private int interesCiencia;

	public Persona(String nombre, int interesDeportes, int interesMusica, int interesFarandula, int interesCiencia) {
		if (interesDeportes < 1 || interesDeportes > 5) {
			throw new IllegalArgumentException("El interes en los deportes es invalido" + interesMusica);
		}
		if (interesMusica < 1 || interesMusica > 5) {
			throw new IllegalArgumentException("El interes en musica es invalido" + interesDeportes);
		}
		if (interesFarandula < 1 || interesFarandula > 5) {
			throw new IllegalArgumentException("El interes en la farandula es invalido" + interesFarandula);
		}
		if (interesCiencia < 1 || interesCiencia > 5) {
			throw new IllegalArgumentException("El interes en ciencias es invalido" + interesCiencia);
		}
		this.nombre = nombre;
		this.interesDeportes = interesDeportes;
		this.interesMusica = interesMusica;
		this.interesFarandula = interesFarandula;
		this.interesCiencia = interesCiencia;
	}

	// CONSULTAR-----------------------------------------------------------------
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

	@Override
	public String toString() {
		return nombre + " [D: " + interesDeportes + ", M: " + interesMusica + ", F: " + interesFarandula + ", C: "
				+ interesCiencia + "]";
	}
}