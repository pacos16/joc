package personajes;

import items.armas.ArmaDeClase;

import java.io.Serializable;

public abstract class Personaje implements Serializable {

    private String nombre;
    private int fuerza;
    private int vida;
    private ArmaDeClase armaDeClase;

    public Personaje(){}
    public Personaje( String nombre, int fuerza, int vida,
                     ArmaDeClase armaDeClase) {
        this.nombre=nombre;
        this.fuerza = fuerza;
        this.vida = vida;
        this.armaDeClase=armaDeClase;
    }


    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArmaDeClase getArmaDeClase() {
        return armaDeClase;
    }

    public void setArmaDeClase(ArmaDeClase armaDeClase) {
        this.armaDeClase = armaDeClase;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", fuerza=" + fuerza +
                ", vida=" + vida +
                '}';
    }
}
