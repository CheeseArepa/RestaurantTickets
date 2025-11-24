package builders;

import modelos.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    private int numeroMesa;
    private List<ItemPedido> items = new ArrayList<>();

    public PedidoBuilder setMesa(int mesa) {
        this.numeroMesa = mesa;
        return this;
    }

    public PedidoBuilder agregarItem(String nombre, int cantidad) {
        this.items.add(new ItemPedido(nombre, cantidad));
        return this;
    }

    public Pedido build(int id) {
        return new Pedido(id, numeroMesa, items, EstadoPedido.PENDIENTE);
    }
}