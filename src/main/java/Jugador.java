import items.Item;
import items.armas.ArmaDeClase;
import personajes.Personaje;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{

    private String nombre;
    private Personaje personaje;
    private ArrayList<Item> mochila;

    public Jugador(){}
    public Jugador(String nombre, Personaje personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.mochila = new ArrayList<>();
        mochila.add(personaje.getArmaDeClase());
    }

    public boolean anyadirAMochila(Item item){
        return mochila.add(item);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public ArrayList<Item> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Item> mochila) {
        this.mochila = mochila;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", personaje=" + personaje +
                ", mochila=" + mochila +
                '}';
    }
}
