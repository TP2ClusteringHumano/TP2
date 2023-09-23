package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	public static List<Arista> encontrarArbolGeneradorMinimo(Grafo grafo) {
		List<Arista> aristas = grafo.getAristas();
		List<Arista> arbolGeneradorMinimo = new ArrayList<>();

		Collections.sort(aristas, (a1, a2) -> Integer.compare(a1.getPeso(), a2.getPeso()));

		UnionFind unionFind = new UnionFind(grafo.getNumVertices());

		for (Arista arista : aristas) {
			int origen = arista.getOrigen();
			int destino = arista.getDestino();

			if (!unionFind.estanConectados(origen, destino)) {
				arbolGeneradorMinimo.add(arista);
				unionFind.unir(origen, destino);
			}
		}

		return arbolGeneradorMinimo;
	}
}

class UnionFind {
	private int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int encontrar(int x) {
		if (parent[x] != x) {
			parent[x] = encontrar(parent[x]);
		}
		return parent[x];
	}

	public void unir(int x, int y) {
		int raizX = encontrar(x);
		int raizY = encontrar(y);
		parent[raizX] = raizY;
	}

	public boolean estanConectados(int x, int y) {
		return encontrar(x) == encontrar(y);
	}
}
