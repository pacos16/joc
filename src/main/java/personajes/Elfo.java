package personajes;

import items.armas.ArmaDeClase;

public class Elfo extends Personaje{

    static final int FUERZA_ELFICA=50;
    private ArmaDeClase armaDeClase;
    static final int VIDA=150;
    public Elfo() {
        super(ArmaDeClase.ArmasDeClase.ELF.name(), FUERZA_ELFICA, VIDA);
        this.armaDeClase = new ArmaDeClase("null",FUERZA_ELFICA, ArmaDeClase.ArmasDeClase.ELF);
    }

    public static int getFuerzaElfica() {
        return FUERZA_ELFICA;
    }

    public ArmaDeClase getArmaDeClase() {
        return armaDeClase;
    }

    public void setArmaDeClase(ArmaDeClase armaDeClase) {
        this.armaDeClase = armaDeClase;
    }

    public static int getVIDA() {
        return VIDA;
    }
}
