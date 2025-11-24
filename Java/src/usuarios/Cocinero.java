package usuarios;

import modelos.EstadoPedido;
import servicios.GestorPedidos;

import java.util.Scanner;

public class Cocinero extends Usuario {

    public Cocinero(String nombre) {
        super(nombre);
    }

    public void verPedidosPendientes() {
        GestorPedidos.getInstancia().obtenerPedidos()
                .stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                .forEach(p -> {
                    System.out.println("Pedido #" + p.getIdPedido());
                });
    }

    public void actualizarEstadoPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID pedido a actualizar: ");
        int id = sc.nextInt();

        var pedido = GestorPedidos.getInstancia().buscarPorId(id);

        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        System.out.println("1. EN_PREPARACION");
        System.out.println("2. LISTO");
        System.out.print("Nuevo estado: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> pedido.cambiarEstado(EstadoPedido.EN_PREPARACION);
            case 2 -> pedido.cambiarEstado(EstadoPedido.LISTO);
            default -> System.out.println("Estado inválido.");
        }
    }
}
