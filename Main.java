package personas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("**********************************");
		System.out.println("TRABAJO PRACTICO MODULO Nº 1 UNLAM");
		System.out.println("**********************************");

		Scanner entrada = new Scanner(System.in);

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
			clearScanner(entrada);

			switch (ciclo) {

			case 1:

				for (int i = 0; i < cantidadPersonas; i++) {
					System.out.println("[" + i + "]" + " Ingrese el nombre de la persona numero " + (i + 1));
					nombre = entrada.nextLine();
					clearScanner(entrada);

					while (nombre == "") {

						System.out.println("Error !!! Nombre invalido. Ingrese el nombre nuevamente");
						nombre = entrada.nextLine();
						clearScanner(entrada);
					}

					nombre = nombre.trim();

					System.out.println("[" + i + "]" + " Ingrese el apellido de la persona numero " + (i + 1));
					apellido = entrada.nextLine();
					clearScanner(entrada);

					while (apellido == "") {

						System.out.println("Error !!! Apellido invalido. Ingrese el apellido nuevamente");
						apellido = entrada.nextLine();
						clearScanner(entrada);
					}

					apellido = apellido.trim();

					System.out.println("[" + i + "]" + " Ingrese el dni de la persona numero " + (i + 1));
					dni = entrada.nextLong();
					clearScanner(entrada);

					System.out.println("[" + i + "]" + " Ingrese la edad de la persona numero " + (i + 1));
					edad = entrada.nextInt();
					clearScanner(entrada);

					do {
						System.out.println("\n" + "[" + i + "]" + " Ingrese localidad de la persona numero " + (i + 1));
						System.out.println("\n1 - HAEDO");
						System.out.println("2 - RAMOS MEJIA");
						System.out.println("3 - SAN JUSTO");
						System.out.println("4 - MORON \n");
						ciclo = entrada.nextInt();
						clearScanner(entrada);

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
					clearScanner(entrada);

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
						System.out.println("\nNombre y apellido: " + vectorPersonas[i].getNombre() + " "
								+ vectorPersonas[i].getApellido());
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
					System.out.println("\nEl dni de la persona mas grande es: " + auxMayorDni);
				}
				break;

			case 4:

				do {
					System.out.println("\nIndique de que localidad son las personas que quiere listar");
					System.out.println("\n1 - HAEDO");
					System.out.println("2 - RAMOS MEJIA");
					System.out.println("3 - SAN JUSTO");
					System.out.println("4 - MORON \n");
					ciclo = entrada.nextInt();
					clearScanner(entrada);

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

				if (vectorPersonas[0] == null) {
					System.out.println("Error !!! No hay personas cargadas");
				} else {

					System.out.println("************************");
					System.out.println("INFO. PERSONAS DE " + localidad.toUpperCase());
					System.out.println("************************");

					for (int i = 0; i < cantidadPersonas; i++) {
						if (localidad == vectorPersonas[i].getLocalidad()) {
							System.out.println("\nNombre y apellido: " + vectorPersonas[i].getNombre() + " "
									+ vectorPersonas[i].getApellido());
							System.out.println("DNI: " + vectorPersonas[i].getDni());
							System.out.println("Telefono: " + vectorPersonas[i].getTelefono());
							System.out.println("Edad: " + vectorPersonas[i].getEdad());
							// VER POR QUE AUNQUE ENCUENTRE RESULTADO SE EJECUTA EL ELSE
						} else {
							System.out.println("No se encontraron personas en la localidad indicada");
						}
					}
				}

				break;
			case 5:
				System.out.println("Ingrese el documento de la persona que desea buscar");
				long dniPersona = entrada.nextLong();
				clearScanner(entrada);

				if (vectorPersonas[0] == null) {
					System.out.println("Error !!! No hay personas cargadas");
				} else {
					for (int i = 0; i < cantidadPersonas; i++) {
						if (dniPersona == vectorPersonas[i].getDni()) {
							System.out.println("\nNombre y apellido: " + vectorPersonas[i].getNombre() + " "
									+ vectorPersonas[i].getApellido());
							System.out.println("DNI: " + vectorPersonas[i].getDni());
							System.out.println("Telefono: " + vectorPersonas[i].getTelefono());
							System.out.println("Edad: " + vectorPersonas[i].getEdad());
							System.out.println("Localidad : " + vectorPersonas[i].getLocalidad());
							// VER POR QUE AUNQUE ENCUENTRE RESULTADO SE EJECUTA EL ELSE
						} else {
							System.out.println("No hay personas cargadas con el dni " + dniPersona);
						}
					}
				}

				break;
			case 6:
				System.out.println("\nORDENANDO PERSONAS Y MOSTRANDOLAS");
				
				do {
					System.out.println("Como desea ordenar a las personas cargadas");
					System.out.println("\n1 - MAYOR A MENOR");
					System.out.println("2 - MENOR A MAYOR");
					ciclo = entrada.nextInt();
					clearScanner(entrada);

					switch (ciclo) {
					case 1:
						System.out.println("Ordenaste de mayor a menor");
						
						
						break;

					case 2:
						System.out.println("ordenaste de menor a mayor");
						break;

					default:
						System.out.println("entro al default");
						break;
					}
				} while (ciclo != 1 && ciclo != 2);

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

	public static void clearScanner(Scanner entrada) {
		String line = null;
		while (!(line = entrada.nextLine()).isEmpty())
			;
	}

}
