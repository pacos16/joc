package items.consumibles;

public class PotiVida extends Poti {

    private int precio;

    public PotiVida(String nombre, String imagen, String descripcion, int precio) {
        super(nombre, imagen, descripcion);
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
