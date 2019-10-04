package items.armas;

public class ArmaStandard extends Arma {

    private int durabilidad;
    private int precio;

    public ArmaStandard(String nombre, String imagen, int danyo, int durabilidad, int precio) {
        super(nombre, imagen, danyo);
        this.durabilidad = durabilidad;
        this.precio = precio;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
