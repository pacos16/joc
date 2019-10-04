package items.consumibles;

public class PotiDanyo extends Poti {

    private int precio;

    public PotiDanyo(String nombre, String imagen, String descripcion, int precio) {
        super(nombre, imagen, descripcion);
        this.precio = precio;
    }
}
