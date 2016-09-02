package arbolBB;

public class Nodo {
	int dato;
	Nodo Izq;
	Nodo Der;

	public Nodo(int data) {
		this.dato = data;
		Izq = null;
		Der = null;
	}

	public void setData(int d) {
		dato = d;
	}

	public int getData() {
		return dato;
	}

	public Nodo getIzq() {
		return Izq;
	}

	public void setIzq(Nodo n) {
		Izq = n;
	}

	public Nodo getDer() {
		return Der;
	}

	public void setDer(Nodo n) {
		Der = n;
	}
}
