import items.Item;
import items.armas.ArmaDeClase;
import items.consumibles.PotiVida;
import personajes.Personaje;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{

    private String nombre;
    private Personaje personaje;
    //apartado a) anyadir arraylist de items a jugador. classe item, llistarElementsMochila() torna string.
    private ArrayList<Item> mochila;

    public Jugador(){}
    public Jugador(String nombre, Personaje personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.mochila = new ArrayList<>();
        mochila.add(new PotiVida());
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
                "," + personaje +
                ", Mochila=" + mochila +
                "}\n"
                ;
    }
    public String llistarElementsMochila(){

        StringBuilder stringBuilder=new StringBuilder();

        for (Item i: mochila
             ) {
            stringBuilder.append(i.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
