import com.google.gson.Gson;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class conversorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********Bienvenido al conversor de monedas********");
        System.out.println("1. Dólares a pesos colombianos");
        System.out.println("2. Dólares a pesos mexicanos");
        System.out.println("3. Dólares a pesos argentinos");
        System.out.println("4. Dólares a euros");
        System.out.println("5. Dólares a soles peruanos");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");

        int opcion = 0;
        while (opcion < 1 || opcion > 6) {
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consume la línea nueva
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entre 1 y 6.");
                scanner.next(); // Limpia el buffer de entrada
            }
        }

        TasaDeCambio conversor = new TasaDeCambio();
        double cantidadDolares;

        try {
            ApiResponse tasas = conversor.obtenerTasasDeCambio();
            if (tasas == null || tasas.conversion_rates == null) {
                System.err.println("Error al obtener las tasas de cambio. Intenta de nuevo más tarde.");
                return;
            }
            switch (opcion) {
                case 1:
                    cantidadDolares = obtenerCantidadDolares(scanner);
                    System.out.println("El resultado es: " + cantidadDolares * tasas.conversion_rates.getCOP() + " COP");
                    break;
                case 2:
                    cantidadDolares = obtenerCantidadDolares(scanner);
                    System.out.println("El resultado es: " + cantidadDolares * tasas.conversion_rates.getMXN() + " MXN");
                    break;
                case 3:
                    cantidadDolares = obtenerCantidadDolares(scanner);
                    System.out.println("El resultado es: " + cantidadDolares * tasas.conversion_rates.getARS() + " ARS");
                    break;
                case 4:
                    cantidadDolares = obtenerCantidadDolares(scanner);
                    System.out.println("El resultado es: " + cantidadDolares * tasas.conversion_rates.getEUR() + "EUR");
                    break;
                case 5:
                    cantidadDolares = obtenerCantidadDolares(scanner);
                    System.out.println("El resultado es: " + cantidadDolares * tasas.conversion_rates.getPEN() + "PEN");
                    break;
                // ... otros casos ...
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double obtenerCantidadDolares(Scanner scanner) {
        double cantidadDolares;
        while (true) {
            try {
                System.out.print("Ingresa la cantidad de dólares: ");
                cantidadDolares = scanner.nextDouble();
                scanner.nextLine(); // Consume la línea nueva
                return cantidadDolares;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.next(); // Limpia el buffer de entrada
            }
        }
    }
}