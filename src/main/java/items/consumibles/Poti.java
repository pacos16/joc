package items.consumibles;

import items.Item;
import personajes.PersonajeEnCombate;

public abstract class Poti extends Item {
    private int stack=MAX_STACK;
    private static final int MAX_STACK=5;
    private String descripcion;


    public Poti(String nombre, String imagen, String descripcion) {
        super(nombre, imagen);
        this.descripcion=descripcion;
        stack=MAX_STACK;
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

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public static int getMaxStack() {
        return MAX_STACK;
    }

    @Override
    public String toString() {
        return "Poti{" +
                "Nombre "+super.getNombre()+" "+
                "stack=" + stack +
                ", descripcion='" + descripcion + '\'' +
                "}";
    }

    public abstract boolean efecto(PersonajeEnCombate p);

}
