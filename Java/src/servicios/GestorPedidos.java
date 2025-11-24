package servicios;

import modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {

    private static GestorPedidos instancia;

    private List<Pedido> pedidos;

    private GestorPedidos() {
        pedidos = new ArrayList<>();
    }

    public static GestorPedidos getInstancia() {
        if (instancia == null) instancia = new GestorPedidos();
        return instancia;
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println("Pedido agregado con éxito.");
    }

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    public Pedido buscarPorId(int id) {
        return pedidos.stream()
                .filter(p -> p.getIdPedido() == id)
                .findFirst()
                .orElse(null);
    }
}
