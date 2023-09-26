package logic;

public class Arista {
	private Persona origen;
	private Persona destino;
	private int peso;

	public Arista(Persona origen, Persona destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public Persona getOrigen() {
		return origen;
	}

	public Persona getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
}
