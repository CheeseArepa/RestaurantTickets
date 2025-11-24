import usuarios.Mesero;
import usuarios.Cocinero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mesero mesero = new Mesero("Juan");
        Cocinero cocinero = new Cocinero("Carlos");

        int opcion;

        do {
            System.out.println("\n=== SISTEMA RESTAURANTE MEXICANO ===");
            System.out.println("1. Crear Pedido (Mesero)");
            System.out.println("2. Ver Todos los Pedidos");
            System.out.println("3. Ver Pedidos Pendientes (Cocinero)");
            System.out.println("4. Cambiar Estado de Pedido (Cocinero)");
            System.out.println("5. Entregar Pedido (Mesero)");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mesero.crearPedido();
                    break;
                case 2:
                    mesero.verPedidos();
                    break;
                case 3:
                    cocinero.verPedidosPendientes();
                    break;
                case 4:
                    cocinero.actualizarEstadoPedido();
                    break;
                case 5:
                    mesero.entregarPedido();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
