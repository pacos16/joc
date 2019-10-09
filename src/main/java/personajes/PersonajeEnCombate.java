package personajes;

import items.Item;
import items.consumibles.PotiDanyo;
import items.consumibles.PotiVida;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonajeEnCombate  implements Serializable {

    private int vidaActual;
    private int fuerzaActual;
    private Personaje personaje;
    private String nombreJugador;
    private ArrayList<Item> mochila;
    public PersonajeEnCombate(){    }


    public PersonajeEnCombate(String nombreJugador, Personaje personaje, ArrayList<Item> mochila) {
        this.nombreJugador=nombreJugador;
        this.personaje = personaje;
        vidaActual=personaje.getVida();
        fuerzaActual= personaje.getFuerza();
        this.mochila=mochila;

    }

    public ArrayList<Item> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Item> mochila) {
        this.mochila = mochila;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getFuerzaActual() {
        return fuerzaActual;
    }

    public void setFuerzaActual(int fuerzaActual) {
        this.fuerzaActual = fuerzaActual;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
