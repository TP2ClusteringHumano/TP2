package logic;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private int numVertices;
	private List<Arista> aristas;
	private List<Persona> personas;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.aristas = new ArrayList<>();
		this.personas = new ArrayList<Persona>();
	}

	public void agregarArista(int origen, int destino, int peso) {
		Arista arista = new Arista(origen, destino, peso);
		aristas.add(arista);
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public void agregarPersona(Persona persona) {
		// Asumiendo que las personas están numeradas desde 0 hasta numVertices - 1
		// Agregamos aristas desde la persona a las personas anteriores
		for (int i = 0; i < aristas.size(); i++) {
			int peso = persona.calcularSimilitud(personas.get(i));
			agregarArista(i, numVertices, peso);
		}

		personas.add(persona);
		numVertices++;
	}

}
