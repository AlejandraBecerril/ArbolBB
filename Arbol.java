package arbolBB;

public class Arbol {
	public static Nodo raiz;

	public Arbol() {
		this.raiz = null;
	}

	public boolean Buscar(int id) {
		Nodo Aux = raiz;
		while (Aux != null) {
			if (Aux.dato == id) {
				return true;
			} else if (Aux.dato > id) {
				Aux = Aux.Izq;
			} else {
				Aux = Aux.Der;
			}
		}
		return false;
	}
	
	public Nodo getIzq() {
		return getIzq();
	}

	public void setIzq(Nodo n) {
		raiz = n;
	}

	public Nodo getDer() {
		return getDer();
	}

	public void setDer(Nodo n) {
		raiz = n;
	}
	/* Funcion para contar los nodos */
	public int contarNodos() {
		return contarNodos(raiz);
	}

	/* funcion para contar los nodods de manera recursiva */
	private int contarNodos(Nodo raiz) {
		if (raiz == null)
			return 0;
		else {
			int l = 1;
			l += contarNodos(raiz.getIzq());
			l += contarNodos(raiz.getDer());
			return l;
		}
	}
	public boolean es_Vacio() {
		return raiz == null;
	}

	public boolean Borrar(int id) {
		Nodo padre = raiz;
		Nodo aux = raiz;
		boolean esHijoIzq = false;
		while (aux.dato != id) {
			padre = aux;
			if (aux.dato > id) {
				esHijoIzq = true;
				aux = aux.Izq;
			} else {
				esHijoIzq = false;
				aux = aux.Der;
			}
			if (aux == null) {
				return false;
			}
		}
		//Se encuentraNodo
		// Caso 1: si el nodo que desea eliminar no tiene hijos
		if (aux.Izq == null && aux.Der == null) {
			if (aux == raiz) {
				raiz = null;
			}
			if (esHijoIzq == true) {
				padre.Izq = null;
			} else {
				padre.Der = null;
			}
		}
		// Case 2 : si el nodo que se desea eliminar tiene un hijo
		else if (aux.Der == null) {
			if (aux == raiz) {
				raiz = aux.Izq;
			} else if (esHijoIzq) {
				padre.Izq = aux.Izq;
			} else {
				padre.Der = aux.Izq;
			}
		} else if (aux.Izq == null) {
			if (aux == raiz) {
				raiz = aux.Der;
			} else if (esHijoIzq) {
				padre.Izq = aux.Der;
			} else {
				padre.Der = aux.Der;
			}
		} else if (aux.Izq != null && aux.Der != null) {

			// elemento mínimo de la dub rama derecha 
			Nodo sucesor = getSuccessor(aux);
			if (aux == raiz) {
				raiz = sucesor;
			} else if (esHijoIzq) {
				padre.Izq = sucesor;
			} else {
				padre.Der = sucesor;
			}
			sucesor.Izq = aux.Izq;
		}
		return true;
	}

	public Nodo getSuccessor(Nodo borrarNodo) {
		Nodo sucessor = null;
		Nodo sucessorPadre = null;
		Nodo aux = borrarNodo.Der;
		while (aux != null) {
			sucessorPadre = sucessor;
			sucessor = aux;
			aux = aux.Izq;
		}
	
		if (sucessor != borrarNodo.Der) {
			sucessorPadre.Izq = sucessor.Der;
			sucessor.Der = borrarNodo.Der;
		}
		return sucessor;
	}

	public void insertar(int id) {
		Nodo nuevo = new Nodo(id);
		if (raiz == null) {
			raiz = nuevo;
			return;
		}
		Nodo aux = raiz;
		Nodo padree = null;
		while (true) {
			padree = aux;
			if (id < padree.dato) {
				aux = aux.Izq;
				if (aux == null) {
					padree.Izq = nuevo;
					return;
				}
			} else {
				aux  = aux.Der;
				if (aux == null) {
					padree.Der = nuevo;
					return;
				}
			}
		}
	}
	
	
	
	public void inOrder(){
		inOrder(raiz);
	}
	private void inOrder(Nodo raiz){
		if(raiz != null){
			inOrder(raiz.Izq);
			System.out.print(raiz.getData()+" ; ");
			inOrder(raiz.Der);
		}
	}
	
	public void preOrden(){
		preOrden(raiz);
	}
	private void preOrden(Nodo raiz){
		if(raiz != null){
			System.out.print(raiz.getData()+" ; ");
			preOrden(raiz.Izq);
			preOrden(raiz.Der);
		}
	}
	
	public void postOrden(){
		postOrden(raiz);
	}
	private void postOrden(Nodo raiz){
		if(raiz != null){
			postOrden(raiz.Izq);
			postOrden(raiz.Der);
			System.out.print(raiz.getData()+" ; ");
		}
	}
	public void display(Nodo raiz) {
		if (raiz != null) {
			display(raiz.Izq);
			System.out.print(" ; " + raiz.dato);
			display(raiz.Der);
		}
	}

}

