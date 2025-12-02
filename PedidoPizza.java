import java.util.Arrays;

public class PedidoPizza extends Pedido implements OperacionesPedido {
    private String tamanio;
    private String[] ingredientesExtras;

    public PedidoPizza(String cliente, String direccion, double precioBase, boolean delivery, String tamanio, String[] ingredientesExtras) {
        super(cliente, direccion, precioBase, TipoComida.PIZZA, delivery);
        this.tamanio = tamanio;
        this.ingredientesExtras = ingredientesExtras;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = getPrecioBase();
        // Costo delivery específico para Pizza: $3.50
        if (isDelivery()) {
            costo += 3.50;
        }
        return costo;
    }

    @Override
    public int estimarTiempoEntrega() {
        // Tiempo base 25 min + 10 min si es delivery
        int tiempo = 25;
        if (isDelivery()) {
            tiempo += 10;
        }
        return tiempo;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("--- Resumen Pedido Pizza ---");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Ingredientes: " + Arrays.toString(ingredientesExtras));
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("Detalle Pizza: Masa artesanal en tamaño " + tamanio);
    }
}