package logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	protected ArrayList<HashSet<Persona>> personas;
	ArrayList<Arista> aristas;
	List<Persona> vertices;

	public Grafo(int cantVertices, List<Persona> listaPersonas) {
		personas = new ArrayList<HashSet<Persona>>();
		for (int i = 0; i < cantVertices; i++) {
			personas.add(new HashSet<Persona>());
		}
		vertices = listaPersonas;
	}

	public void agregarArista(Persona origen, Persona destino, int peso) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarDistintos(origen, destino);

		if (!existeArista(origen, destino)) {
			personas.get(vertices.indexOf(origen)).add(destino);
			personas.get(vertices.indexOf(destino)).add(origen);
		}
		Arista nuevo = new Arista(origen, destino, peso);
		if (!aristas.contains(nuevo)) {
			aristas.add(nuevo);
		}
	}

	public void eliminarArista(Persona origen, Persona destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarDistintos(origen, destino);

		personas.get(vertices.indexOf(origen)).remove(destino);
		personas.get(vertices.indexOf(destino)).remove(origen);

		for (int i = 0; i < aristas.size(); i++) {
			if (aristas.get(i).getOrigen() == origen && aristas.get(i).getDestino() == destino) {
				aristas.remove(i);
				break;
			}
		}
	}

	public boolean existeArista(Persona origen, Persona destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarDistintos(origen, destino);

		return personas.get(vertices.indexOf(origen)).contains(destino) && personas.get(vertices.indexOf(destino)).contains(origen);
	}

	public int tamano() {
		return personas.size();
	}

	public Set<Persona> vecinos(Persona i) {
		verificarVertice(i);

		return personas.get(vertices.indexOf(i));
	}

	public void verificarVertice(Persona i) {
		if (i == null)
			throw new IllegalArgumentException("Persona invalida" + i);
	}

	public void verificarDistintos(Persona i, Persona j) {
		if (i == j)
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

}
