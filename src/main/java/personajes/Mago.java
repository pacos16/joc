package personajes;

import items.armas.ArmaDeClase;

public class Mago extends Personaje {
    static final int FUERZA_MAGICA = 80;
    private ArmaDeClase armaDeClase;
    static final int VIDA=100;
    public Mago() {
        super(ArmaDeClase.ArmasDeClase.MAGE.name(), FUERZA_MAGICA, VIDA);
        this.armaDeClase = new ArmaDeClase("null", FUERZA_MAGICA, ArmaDeClase.ArmasDeClase.MAGE);
    }

    public static int getFuerzaMagica() {
        return FUERZA_MAGICA;
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
