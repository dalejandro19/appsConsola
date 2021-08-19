package appConsola;

import java.io.IOException;
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

	public void limpiar() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public void menu() {
		String strOpcionMenu;
		Scanner scan = new Scanner(System.in);
		// strCantPelotas, strLimValor,
		// cantPelotas, limValor,

		// ENTRADA DE LA OPCION
		do {
			System.out.println("--------------MENU DE OPCIONES--------------"
					+ "\n1. Ingreso manual de numeros\n2. Ingreso aleatorio\n3. Salir");
			strOpcionMenu = scan.next();
		} while (validacion(strOpcionMenu) == false);

		// MENU
		switch (Integer.parseInt(strOpcionMenu)) {
		case 1:

			System.out.println("HOLA MUNDO");
			break;

		case 3:
			System.exit(0);
			break;

		default:
			menu();
			break;
		}
		scan.close();
	}

	public Object conversionDato(String cadena) {
		int dato;
		dato = Integer.parseInt(cadena);
		return dato;
	}

	public boolean validacion(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR 404");
			tiempoEspera();
			return false;
		}
	}

	public void tiempoEspera() {
		try {
			Thread.sleep(2 * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}