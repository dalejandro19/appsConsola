package appConsola;

import java.util.Scanner;

public class Main {
	/*
	 * Imprimir el número y la cantidad de pelotas que hay de ese tipo, si no hay
	 * ninguna de ese color, debes imprimir 0, el número de colores no excederá de
	 * 100.
	 */
	// N<=100 Cantidad de pelotas que hay
	// M>=1 Numero mayor de pelotas que puedes encontrar

	public static void main(String[] argumentos) {
		Main cubeta = new Main();
		cubeta.menu();
	}

	public void menu() {
		String cantPelotas, limValor, opcionMenu;
		/*
		 * Scanner scan; scan = new Scanner(System.in); cantPelotas = scan.nextInt();
		 * System.out.println(cantPelotas); scan.close();
		 */
		System.out.println(
				"--------------MENU DE OPCIONES--------------\n1. Ingreso manual de numeros\n2. Ingreso aleatorio");

		/*
		 * VALIDACION PARA LA CANTIDAD DE PELOTAS do {
		 * 
		 * }while();
		 */
	}

	public boolean validacion(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR 404");
			return false;
		}
	}
}
