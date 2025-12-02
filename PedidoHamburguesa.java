public class PedidoHamburguesa extends Pedido implements OperacionesPedido {
    private boolean comboCompleto;
    private int nivelPicante; // 0 a 5

    public PedidoHamburguesa(String cliente, String direccion, double precioBase, boolean delivery, boolean comboCompleto, int nivelPicante) {
        super(cliente, direccion, precioBase, TipoComida.HAMBURGUESA, delivery);
        this.comboCompleto = comboCompleto;
        this.nivelPicante = nivelPicante;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = getPrecioBase();
        // Costo delivery específico para Hamburguesa: $2.80
        if (isDelivery()) {
            costo += 2.80;
        }
        // Lógica adicional opcional: sumar costo si es combo
        if (comboCompleto) {
            costo += 5.00;
        }
        return costo;
    }

    @Override
    public int estimarTiempoEntrega() {
        // Tiempo base 15 min + 10 min si es delivery
        int tiempo = 15;
        if (isDelivery()) {
            tiempo += 10;
        }
        return tiempo;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("--- Resumen Pedido Hamburguesa ---");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Es combo: " + (comboCompleto ? "Sí" : "No"));
        System.out.println("Nivel de picante: " + nivelPicante);
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("Detalle Hamburguesa: Carne Angus importada. Picante nivel " + nivelPicante);
    }
}