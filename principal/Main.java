package principal;  // Declara el paquete principal donde se encuentra esta clase

import calculos.ConversorMoneda;  // Importa la clase ConversorMoneda del paquete calculos
import java.util.Scanner;  // Importa la clase Scanner para la entrada de datos del usuario

public class Main {

    public static void main(String[] args) {
        // Crea una instancia de la clase ConversorMoneda que manejará las conversiones
        ConversorMoneda conversorMoneda = new ConversorMoneda();
        Scanner scanner = new Scanner(System.in);  // Crea un objeto Scanner para leer la entrada del usuario
        int opcion;  // Variable para almacenar la opción elegida por el usuario

        // Bucle do-while para mostrar el menú hasta que el usuario decida salir
        do {
            mostrarMenu(conversorMoneda);  // Muestra el menú de opciones
            opcion = scanner.nextInt();  // Lee la opción elegida por el usuario

            // Verifica si la opción elegida es válida (entre 1 y el número de conversiones)
            if (opcion >= 1 && opcion <= conversorMoneda.getConversiones().size()) {
                System.out.print("Ingresa el valor que deseas convertir: ");  // Solicita el valor a convertir
                double valor = scanner.nextDouble();  // Lee el valor ingresado por el usuario
                realizarConversion(opcion - 1, valor, conversorMoneda);  // Realiza la conversión
            } else if (opcion == conversorMoneda.getConversiones().size() + 1) {
                // Si el usuario elige la opción de salir
                System.out.println("Saliendo del programa...");
            } else {
                // Opción no válida, informa al usuario
                System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (opcion != conversorMoneda.getConversiones().size() + 1);  // Continúa hasta que el usuario elija salir

        scanner.close();  // Cierra el objeto Scanner para liberar recursos
    }

    // Método para mostrar el menú de conversiones disponibles
    private static void mostrarMenu(ConversorMoneda conversorMoneda) {
        System.out.println("***************************");  // Imprime el encabezado del menú
        // Itera sobre las conversiones disponibles y las imprime
        for (int i = 0; i < conversorMoneda.getConversiones().size(); i++) {
            System.out.println((i + 1) + ". " + conversorMoneda.getConversiones().get(i));  // Muestra la opción
        }
        // Muestra la opción para salir del programa
        System.out.println((conversorMoneda.getConversiones().size() + 1) + ". Salir");
        System.out.println("***************************");  // Imprime el pie del menú
        System.out.print("Elige una opción: ");  // Solicita al usuario que elija una opción
    }

    // Método para realizar la conversión
    private static void realizarConversion(int indice, double valor, ConversorMoneda conversorMoneda) {
        // Llama al método convertir del objeto ConversorMoneda y almacena el resultado
        double resultado = conversorMoneda.convertir(valor, indice);
        // Muestra el resultado de la conversión
        System.out.printf("El resultado de la conversión es: %.2f\n", resultado);
    }
}
