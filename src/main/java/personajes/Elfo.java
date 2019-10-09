package personajes;

import items.armas.ArmaDeClase;

public class Elfo extends Personaje{
    static final String nombre="Elf";
    static final int FUERZA_ELFICA=50;
    static final int VIDA=1300;
    public Elfo() {
        super(nombre,FUERZA_ELFICA, VIDA, new ArmaDeClase("img", FUERZA_ELFICA, ArmaDeClase.ArmasDeClase.ELF));
    }

    public static int getFuerzaElfica() {
        return FUERZA_ELFICA;
    }

    public static int getVIDA() {
        return VIDA;
    }
}
