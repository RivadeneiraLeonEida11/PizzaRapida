public enum TipoComida {
    // Definimos las constantes invocando al constructor personalizado
    PIZZA("Pizza Artesanal"),
    HAMBURGUESA("Hamburguesa Gourmet"),
    SUSHI("Sushi Fresco"),
    ENSALADA("Ensalada Saludable"),
    POSTRE("Postre de la Casa"),
    BEBIDA("Bebida Refrescante");

    // Atributo del Enum
    private final String descripcion;

    // Constructor privado (los enums siempre tienen constructores privados o de paquete)
    TipoComida(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método getter para obtener el dato extra
    public String getDescripcion() {
        return descripcion;
    }
}