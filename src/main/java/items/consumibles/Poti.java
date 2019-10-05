package items.consumibles;

import items.Item;

public abstract class Poti extends Item {

    private final int MAX_STACK=5;
    private String descripcion;
    public Poti(String nombre, String imagen,String descripcion) {
        super(nombre, imagen);
        this.descripcion=descripcion;
    }

    public int getMAX_STACK() {
        return MAX_STACK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Poti{" +
                "nombre: "+super.getNombre()+ " "+
                "descripcion: '" + descripcion + '\'' +
                '}';
    }
}
