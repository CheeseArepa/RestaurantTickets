package modelos;

public class ItemPedido {
    private String nombre;
    private int cantidad;

    public ItemPedido(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void mostrarInfo() {
        System.out.println("- " + nombre + " x" + cantidad);
    }
}
