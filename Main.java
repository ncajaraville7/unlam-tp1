package personas;

import java.util.Scanner;

public class Main {

	private static Scanner entrada;

	public static void main(String[] args) {

		System.out.println("**********************************");
		System.out.println("TRABAJO PRACTICO MODULO Nº 1 UNLAM");
		System.out.println("**********************************");

		entrada = new Scanner(System.in);

		int cantidadPersonas;

		System.out.println("Ingresa la cantidad de personas a ingresar. El mismo debe ser entre 10 y 20");
		// cantidadPersonas = entrada.nextInt();
		cantidadPersonas = 2;

//		while (cantidadPersonas < 10 || cantidadPersonas > 20) {
//			System.out.println("Error !!! Debe ingresar un numero entre el 10 y el 20\n");
//			System.out.println("Ingresa la cantidad de personas a ingresar. El mismo debe ser entre 10 y 20");
//			cantidadPersonas = entrada.nextInt();
//		}

		Persona[] vectorPersonas = new Persona[cantidadPersonas];

		String nombre = "";
		String apellido = "";
		long dni = 0;
		int edad = 0;
		long telefono = 0;
		String localidad = "";

		int ciclo = 0;

		do {
			System.out.println("\nIngrese la opcion que desea realizar");
			System.out.println("\n1 - CARGAR PERSONA AL SISTEMA");
			System.out.println("2 - MOSTRAR TODAS LAS PERSONAS AGREGADAS");
			System.out.println("3 - MOSTRAR LA PERSONA MAS GRANDE");
			System.out.println("4 - MOSTRAR LAS PERSONAS QUE VIVAN EN LA LOCALIDAD INDICADA");
			System.out.println("5 - BUSCAR PERSONA POR DNI");
			System.out.println("6 - ORDERNAR LAS PERSONAS POR DNI Y MOSTRARLAS");
			System.out.println("7 - SALIR");
			ciclo = entrada.nextInt();

			switch (ciclo) {

			case 1:
				// ¿ HAY QUE CARGAR UNA SOLA PERSONA O TODAS LAS PERSONAS QUE INDICAMOS QUE IBAN
				// A ESTAR EN EL VECTOR ?
				// VER VALIDACIONES Y  COMO VALIDAR LAS VARIABLES CON NUMEROS

				for (int i = 0; i < cantidadPersonas; i++) {
					System.out.println("[" + i + "]" + " Ingrese el nombre de la persona numero " + (i + 1));
					nombre = entrada.next();

					while (nombre == "") {

						System.out.println("Error !!! Nombre invalido. Ingrese el nombre nuevamente");
						nombre = entrada.nextLine();
					}
					
					nombre = nombre.trim();
					entrada.nextLine();

					System.out.println("[" + i + "]" + " Ingrese el apellido de la persona numero " + (i + 1));
					apellido = entrada.next();

					while (apellido == "") {

						System.out.println("Error !!! Apellido invalido. Ingrese el apellido nuevamente");
						apellido = entrada.nextLine();
					}
					
					apellido = apellido.trim();

					System.out.println("[" + i + "]" + " Ingrese el dni de la persona numero " + (i + 1));
					dni = entrada.nextLong();

					System.out.println("[" + i + "]" + " Ingrese la edad de la persona numero " + (i + 1));
					edad = entrada.nextInt();

					do {
						System.out.println("\n" + "[" + i + "]" + " Ingrese localidad de la persona numero " + (i + 1));
						System.out.println("\n1 - HAEDO");
						System.out.println("2 - RAMOS MEJIA");
						System.out.println("3 - SAN JUSTO");
						System.out.println("4 - MORON \n");
						ciclo = entrada.nextInt();

						switch (ciclo) {
						case 1:
							localidad = "Haedo";
							break;
						case 2:
							localidad = "Ramos Mejia";
							break;
						case 3:
							localidad = "San Justo";
							break;
						case 4:
							localidad = "Moron";
							break;
						default:
							System.out.println("No ingreso una localidad valida");
						}
					} while (ciclo != 1 && ciclo != 2 && ciclo != 3 && ciclo != 4);

					System.out.println("[" + i + "]" + " Ingrese el telefono de la persona numero " + (i + 1));
					telefono = entrada.nextLong();

					vectorPersonas[i] = new Persona(nombre, apellido, dni, edad, localidad, telefono);
				}
				break;

			case 2:

				System.out.println("\n*****************************");
				System.out.println("LISTADO DE PERSONAS AGREGADAS");
				System.out.println("*****************************");

				if (vectorPersonas[0] == null) {
					System.out.println("Error !!! No hay personas cargadas");
				} else {
					for (int i = 0; i < cantidadPersonas; i++) {
						System.out.println("\n" + "[" + i + "]" + " Persona numero " + (i + 1));
						System.out.println("Nombre: " + vectorPersonas[i].getNombre());
						System.out.println("Apellido: " + vectorPersonas[i].getApellido());
						System.out.println("DNI: " + vectorPersonas[i].getDni());
						System.out.println("Telefono: " + vectorPersonas[i].getTelefono());
						System.out.println("\n-----------------------");
					}
				}
				break;

			case 3:

				if (vectorPersonas[0] == null) {
					System.out.println("Error !!! No hay personas cargadas");
				} else {
					long auxMayorDni = vectorPersonas[0].getDni();

					for (int i = 0; i < cantidadPersonas; i++) {
						if (auxMayorDni > vectorPersonas[i].getDni()) {
							auxMayorDni = vectorPersonas[i].getDni();
						}
					}
					System.out.println("El dni de la persona mas grande es: " + auxMayorDni);
				}
				break;

			case 4:
				System.out.println("\nMOSTRANDO PERSONAS QUE VIVEN EN LA LOCALIDAD INDICADA");
				break;
			case 5:
				System.out.println("\nBUSCANDO PERSONA POR DNI");
				break;
			case 6:
				System.out.println("\nORDENANDO PERSONAS Y MOSTRANDOLAS");
				break;
			case 7:
				System.out.println("\nSALIENDO DEL PROGRAMA");
				break;
			default:
				System.out.println("\nNo ingresaste una opcion valida");
				break;
			}
		} while (ciclo != 7);

	}

}
