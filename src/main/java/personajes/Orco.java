package personajes;

import items.armas.ArmaDeClase;

public class Orco extends Personaje{
    static final int FUERZA_ORCA=70;
    private ArmaDeClase armaDeClase;
    static final int VIDA=200;
    public Orco() {
        super(ArmaDeClase.ArmasDeClase.ORC.name(), FUERZA_ORCA, VIDA);
        this.armaDeClase = new ArmaDeClase("null",FUERZA_ORCA, ArmaDeClase.ArmasDeClase.ORC);
    }

    public static int getFuerzaOrca() {
        return FUERZA_ORCA;
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
