package arbolBB;

import java.util.Scanner;
public class ArbolMain {
	public static Nodo raiz;

	public static void main(String arg[]) {
		Arbol b = new Arbol();
			Scanner scan = new Scanner(System.in);
			int insert;
			int searchh;
			String ch = null;
			do {
				System.out.println("Selecione una Opción");
				System.out.println("1. Insertar");//listo
				System.out.println("2. Buscar");//listo
				System.out.println("3. Borrar");//listo
				System.out.println("4. Contar Nodos");//listo
				System.out.println("5. Estado del Árbol");//listo
				System.out.println("6. Salir");

				int opcion = scan.nextInt();
				switch (opcion) {
				case 1://insertar
					System.out.println("Ingrese un elemento entero positvo para Insertar");
					insert = scan.nextInt();
					b.insertar(insert);					
					
					break;
				case 2://buscar
					System.out.println("Ingrese un elemento Entero positivo para Buscar");
					searchh = scan.nextInt();
					System.out.println("El elemento buscado existe? : " + b.Buscar(searchh));
					break;
				case 3: //Borrar
					System.out.println("Por favor ingrese el elemento a eliminar ");
					Scanner del = new Scanner(System.in);
					int borrar = del.nextInt();
					System.out.println("Árbol después de eliminar el nodo : " + b.Borrar(borrar));
					b.display(raiz);
					
					break;
				case 4://contar Nodos
					System.out.println("Número de Nodos = " + b.contarNodos());

					break;
				case 5://estado del Árbol
					System.out.println("El Árbol es Vacio: " + b.es_Vacio());
					break;
				case 6:
					System.out.println("Hasta Luego.....");
					System.exit(6);
					break;
				default:
					System.out.println("Entrada erronea\n ");
					break;
				}
				System.out.print("\nPre order : ");
				b.preOrden();
				System.out.print("\nIn order : ");
				b.inOrder();
				System.out.print("\nPost order : ");
				b.postOrden();

				System.out.println("\n\n¿Quiere continuar? (Escriba <si> o <no>) \n");
				ch = new Scanner(System.in).nextLine();
			} while (ch.equals("si"));
		}
		
		
	}

