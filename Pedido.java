public abstract class Pedido {
    // Atributos encapsulados
    private String cliente;
    private String direccion;
    private double precioBase;
    private TipoComida tipo;
    private boolean delivery;

    // Constructor
    public Pedido(String cliente, String direccion, double precioBase, TipoComida tipo, boolean delivery) {
        this.cliente = cliente;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.delivery = delivery;
    }

    // Metodo abstracto (abstracción)
    public abstract void mostrarDetallesEspeciales();

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public TipoComida getTipo() {
        return tipo;
    }

    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
}