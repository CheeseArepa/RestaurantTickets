package usuarios;

import builders.PedidoBuilder;
import modelos.Pedido;
import servicios.GestorPedidos;

import java.util.Scanner;

public class Mesero extends Usuario {

    public Mesero(String nombre) {
        super(nombre);
    }

    public void crearPedido() {
        Scanner sc = new Scanner(System.in);
        PedidoBuilder builder = new PedidoBuilder();

        System.out.print("Número de mesa: ");
        int mesa = sc.nextInt();
        builder.setMesa(mesa);

        System.out.print("¿Cuántos items?: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del plato: ");
            String nombre = sc.next();
            System.out.print("Cantidad: ");
            int cant = sc.nextInt();

            builder.agregarItem(nombre, cant);
        }

        int nuevoId = GestorPedidos.getInstancia().obtenerPedidos().size() + 1;
        Pedido nuevo = builder.build(nuevoId);
        GestorPedidos.getInstancia().agregarPedido(nuevo);
    }

    public void verPedidos() {
        GestorPedidos.getInstancia().obtenerPedidos()
                .forEach(Pedido::mostrarInfo);
    }

    public void entregarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID de pedido a entregar: ");
        int id = sc.nextInt();

        var pedido = GestorPedidos.getInstancia().buscarPorId(id);

        if (pedido != null) pedido.cambiarEstado(modelos.EstadoPedido.ENTREGADO);
        else System.out.println("Pedido no encontrado.");
    }
}
