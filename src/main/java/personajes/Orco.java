package personajes;

import items.armas.ArmaDeClase;

public class Orco extends Personaje{
    static final int FUERZA_ORCA=70;
    static final String nombre="Orc";
    static final int VIDA=1100;
    public Orco() {
        super( nombre,FUERZA_ORCA, VIDA, new ArmaDeClase("img", FUERZA_ORCA, ArmaDeClase.ArmasDeClase.ORC));

    }

    public static int getFuerzaOrca() {
        return FUERZA_ORCA;
    }

    public static int getVIDA() {
        return VIDA;
    }
}
