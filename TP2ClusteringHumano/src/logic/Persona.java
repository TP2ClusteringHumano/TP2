package logic;

public class Persona {
	private String nombre;
	private int interesDeportes;
	private int interesMusica;
	private int interesEspectaculos;
	private int interesCiencia;

	public Persona(String nombre, int interesDeportes, int interesMusica, int interesEspectaculo, int interesCiencia) {
		if (interesDeportes < 1 || interesDeportes > 5) {
			throw new IllegalArgumentException("El interes en los deportes es invalido" + interesMusica);
		}
		if (interesMusica < 1 || interesMusica > 5) {
			throw new IllegalArgumentException("El interes en musica es invalido" + interesDeportes);
		}
		if (interesEspectaculo < 1 || interesEspectaculo > 5) {
			throw new IllegalArgumentException("El interes en la farandula es invalido" + interesEspectaculo);
		}
		if (interesCiencia < 1 || interesCiencia > 5) {
			throw new IllegalArgumentException("El interes en ciencias es invalido" + interesCiencia);
		}
		this.nombre = nombre;
		this.interesDeportes = interesDeportes;
		this.interesMusica = interesMusica;
		this.interesEspectaculos = interesEspectaculo;
		this.interesCiencia = interesCiencia;
	}

	public int calcularSimilitud(Persona otraPersona) {
        return Math.abs(this.interesDeportes - otraPersona.consultarInteresDeportes())
                + Math.abs(this.interesMusica - otraPersona.consultarInteresMusica())
                + Math.abs(this.interesEspectaculos - otraPersona.consultarInteresEspectaculo())
                + Math.abs(this.interesCiencia - otraPersona.consultarInteresCiencia());
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

	public int consultarInteresEspectaculo() {
		return this.interesEspectaculos;
	}

	public int consultarInteresCiencia() {
		return this.interesCiencia;
	}
	
	
	@Override
	public String toString() {
		return nombre + " [D: " + interesDeportes + ", M: " + interesMusica + ", E: " + interesEspectaculos + ", C: "
				+ interesCiencia + "]";
	}
}