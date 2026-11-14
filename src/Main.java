
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Videojuego[] videojuegos = new Videojuego[5];

        videojuegos[0] = new Videojuego("Minecraft", "PC", 2011, 29.99);
        videojuegos[1] = new Videojuego("Outlast", "PC", 2016, 15.50);
        videojuegos[2] = new Videojuego("God of War", "PlayStation", 2018, 49.99);
        videojuegos[3] = new Videojuego("Resident Evil Requiem", "Multiplataforma", 2026, 53.45);

        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\n===== CATÁLOGO DE VIDEOJUEGOS =====");
            System.out.println("1. Registrar videojuego");
            System.out.println("2. Mostrar videojuegos");
            System.out.println("3. Salir");

            boolean opcionValida = false;
            while (!opcionValida) {
                try {
                    System.out.print("Seleccione una opción: ");
                    opcion = Integer.parseInt(teclado.nextLine());

                    if (opcion >= 1 && opcion <= 3) {
                        opcionValida = true;
                    } else {
                        System.out.println("Seleccione una opción entre 1 y 3.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número válido.");
                }
            }
            switch (opcion) {
                case 1:
                    int posicion = -1;
                    for (int i = 0; i < videojuegos.length; i++) {
                        if (videojuegos[i] == null) {
                            posicion = i;
                            break;
                        }
                    }
                    if (posicion == -1) {
                        System.out.println("No hay espacio disponible.");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    while (nombre.isBlank()) {
                        System.out.println("El nombre no puede estar vacío.");
                        System.out.print("Ingrese el nombre: ");
                        nombre = teclado.nextLine();
                    }

                    System.out.print("Plataforma: ");
                    String plataforma = teclado.nextLine();

                    while (plataforma.isBlank()) {
                        System.out.println("La plataforma no puede estar vacía.");
                        System.out.print("Ingrese la plataforma: ");
                        plataforma = teclado.nextLine();
                    }

                    int anio = 0;
                    boolean anioValido = false;

                    while (!anioValido) {
                        try {
                            System.out.print("Año de lanzamiento: ");
                            anio = Integer.parseInt(teclado.nextLine());

                            if (anio > 0) {
                                anioValido = true;
                            } else {
                                System.out.println("El año debe ser mayor que cero.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un año entero válido.");
                        }
                    }

                    double precio = 0;
                    boolean precioValido = false;

                    while (!precioValido) {
                        try {
                            System.out.print("Precio: ");
                            precio = Double.parseDouble(teclado.nextLine());

                            if (Double.isFinite(precio) && precio > 0) {
                                precioValido = true;
                            } else {
                                System.out.println("El precio debe ser mayor que cero.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar una cantidad válida.");
                        }
                    }

                    videojuegos[posicion] = new Videojuego(
                            nombre,
                            plataforma,
                            anio,
                            precio
                    );
                    System.out.println("Videojuego registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n===== VIDEOJUEGOS REGISTRADOS =====");
                    boolean hayVideojuegos = false;
                    for (int i = 0; i < videojuegos.length; i++) {
                        if (videojuegos[i] != null) {
                            hayVideojuegos = true;
                            System.out.println("\nVideojuego " + (i + 1));
                            System.out.println("Nombre: " + videojuegos[i].nombre());
                            System.out.println("Plataforma: " + videojuegos[i].plataforma());
                            System.out.println("Año: " + videojuegos[i].anioLanzamiento());
                            System.out.println("Precio: $" + videojuegos[i].precio());
                        }
                    }
                    if (!hayVideojuegos) {
                        System.out.println("No hay videojuegos registrados.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        teclado.close();
    }
}
