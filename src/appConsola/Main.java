package appConsola;

import java.io.IOException;
import java.util.Iterator;
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

	// ACCIONES
	public void limpiar() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public void tiempoEspera() {
		try {
			Thread.sleep(2 * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}
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

	public int conversionDato(String cadena) {
		int dato;
		dato = Integer.parseInt(cadena);
		return dato;
	}

	public void menu() {
		String strOpcion;
		int opcion;
		Scanner scan = new Scanner(System.in);

		do {
			// ENTRADA DE LA OPCION
			do {
				System.out.println("--------------ORDENADOR DE CUBETAS--------------"
						+ "\n1. GENRADOR MANUAL\n2. GENERADOR ALEATORIO\n3. SALIR");
				strOpcion = scan.next();
			} while (validacion(strOpcion) == false);
			opcion = conversionDato(strOpcion);

			// MENU
			switch (opcion) {
			case 1:
				System.out.println("PRIMERA PARTE");
				// generarCubetas();
				break;

			case 2:
				cubetas(1, 8, 5);
				break;

			case 3:
				System.exit(0);
				break;

			default:
				menu();
				break;
			}
		} while (opcion != 3);
	}

	public void generarCubetas() {
		int numMayor, cantPelotas;

		// limpiar();
		numMayor = numeroMayor();
		cantPelotas = cantidadPelotas();

		if (numMayor < 0 || (cantPelotas > 100 || cantPelotas <= 0)) {
			System.out.println("ERROR: INGRESE LOS VALORES NUEVAMENTE");
			tiempoEspera();
			menu();
		} else {
			System.out.println("CANTIDAD DE PELOTAS: " + cantPelotas + " - VALOR LIMITE:" + numMayor);
		}

	}

	public int numeroMayor() {
		int resultado;
		String strNumero;

		// SCANNER PARA ENTRADA DE DATOS
		Scanner scan = new Scanner(System.in);

		// VALIDACION
		do {
			System.out.println("INGRESE EL NUMERO LIMITE DEL VALOR DE LAS PELOTAS\nNOTA: DEBE SER MAYOR A CERO");
			strNumero = scan.next();
		} while (validacion(strNumero) == false);

		resultado = conversionDato(strNumero);
		return resultado;
	}

	public int cantidadPelotas() {
		int resultado;
		String strCantidad;

		// SCANNER PARA ENTRADA DE DATOS
		Scanner scan = new Scanner(System.in);

		// VALIDACION
		do {
			System.out.println("INGRESE LA CANTIDAD DE PELOTAS QUE DESEA EN LA CUBETA");
			strCantidad = scan.next();
		} while (validacion(strCantidad) == false);

		resultado = conversionDato(strCantidad);
		return resultado;
	}

	public void cubetas(int metodo, int numMayor, int cantPelotas) {
		Scanner scan = new Scanner(System.in);

		int[] num = new int[cantPelotas];
		int[] contar = new int[cantPelotas + 1];

		if (metodo == 1) {
			for (int i = 0; i < cantPelotas; i++) {
				num[i] = scan.nextInt();
			}

			for (int j = 0; j < cantPelotas; j++) {
				contar[num[j]] += 1;
			}

			for (int i = 0; i < numMayor; i++) {
				System.out.println("#: " + (i + 1) + " repite: " + contar[i + 1]);
			}
		}
	}

}