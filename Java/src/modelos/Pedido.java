package modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private int numeroMesa;
    private List<ItemPedido> items = new ArrayList<>();
    private EstadoPedido estado;

    public Pedido(int id, int mesa, List<ItemPedido> items, EstadoPedido estado) {
        this.idPedido = id;
        this.numeroMesa = mesa;
        this.items = items;
        this.estado = estado;
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Pedido #" + idPedido + " cambiado a " + nuevoEstado);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void mostrarInfo() {
        System.out.println("\nPedido #" + idPedido + " | Mesa " + numeroMesa + " | Estado: " + estado);
        for (ItemPedido item : items) {
            item.mostrarInfo();
        }
    }
}
