import java.util.ArrayList;
import java.util.List;

public class MainPizzeria {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();

        // 1. Pedido de Pizza (Con Delivery)
        // Precio base 12.50 + 3.50 (delivery) = 16.00
        String[] ingredientes = {"Pepperoni", "Queso Azul", "Aceitunas"};
        PedidoPizza pizza = new PedidoPizza(
                "Edu Rivadeneira",
                "Codesa, Calle D y Jaime Hurtado",
                12.50,
                true, // CON DELIVERY
                "Familiar",
                ingredientes
        );
        pedidos.add(pizza);

        // 2. Pedido de Hamburguesa (Sin Delivery)
        // Precio base 7.00 + 5.00 (Combo) = 12.00
        PedidoHamburguesa hamburguesa = new PedidoHamburguesa(
                "Amada Valentina Del Carmen",
                "Nuevos Horizontes, Calle 5 de Agosto",
                7.00,
                false, // SIN DELIVERY
                true,  // Con Combo
                2
        );
        pedidos.add(hamburguesa);

        System.out.println("=== SISTEMA DE GESTIÓN DE PEDIDOS PIZZA RÁPIDA ===\n");

        for (Pedido p : pedidos) {
            System.out.println("-------------------------------------------------");
            // 1. Mostrar Categoría (Enum compuesto)
            System.out.println("Categoría: " + p.getTipo().getDescripcion());

            if (p instanceof OperacionesPedido) {
                OperacionesPedido operacion = (OperacionesPedido) p;

                // 2. Mostrar Resumen y Detalles
                operacion.mostrarResumenPedido();
                p.mostrarDetallesEspeciales();

                // 3. CÁLCULO DEL DESGLOSE PARA EL PRINT (Lo que pediste)
                double total = operacion.calcularCostoTotal();
                double costoDelivery = 0.0;

                // Identificamos cuánto cuesta el delivery según la clase
                if (p.isDelivery()) {
                    if (p instanceof PedidoPizza) {
                        costoDelivery = 3.50;
                    } else if (p instanceof PedidoHamburguesa) {
                        costoDelivery = 2.80;
                    }
                }

                // El subtotal es el total menos lo que hayamos detectado de delivery
                double subtotal = total - costoDelivery;
                String etiquetaDelivery = p.isDelivery() ? "Delivery" : "Sin Delivery";

                // 4. Imprimir Tiempos
                System.out.println("\n>> Tiempo Estimado: " + operacion.estimarTiempoEntrega() + " min");

                // 5. IMPRESIÓN DEL TOTAL DETALLADO
                // Formato: Total = Subtotal + Costo (Etiqueta)
                System.out.printf(">> TOTAL A PAGAR: $%.2f = $%.2f + $%.2f (%s)%n",
                        total, subtotal, costoDelivery, etiquetaDelivery);
            }
        }
        System.out.println("-------------------------------------------------");
    }
}