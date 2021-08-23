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
		switch (conversionDato(strOpcionMenu)) {
		case 1:
			System.out.println("PRIMERA PARTE");
			generadorCubetas();
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

	public void generadorCubetas() {
		String strCantidadPelotas, strValorLimite, strNumeroPelota;
		int cantidadPelotas, valorLimite, numeroPelota;
		Scanner scan = new Scanner(System.in);

		// LIMPIAR CONSOLA
		do {
			System.out.println("Ingrese la cantidad de pelotas a ingresar en la cubeta");
			strCantidadPelotas = scan.next();
		} while (validacion(strCantidadPelotas) == false);

		// LIMPIAR CONSOLA
		do {
			System.out.println("Ingrese el valor limite para las pelotas\nNOTA: Debe ser mayor a cero");
			strValorLimite = scan.next();
		} while (validacion(strValorLimite) == false);

		cantidadPelotas = conversionDato(strCantidadPelotas);
		valorLimite = conversionDato(strValorLimite);

		if (valorLimite < 0 || (cantidadPelotas > 100 || cantidadPelotas <= 0)) {
			System.out.println("ERROR: INGRESE LOS VALORES NUEVAMENTE");
			tiempoEspera();
			generadorCubetas();
		} else {
			System.out.println("CANTIDAD DE PELOTAS: " + cantidadPelotas + " - VALOR LIMITE:" + valorLimite);
		}

	}

	public int conversionDato(String cadena) {
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