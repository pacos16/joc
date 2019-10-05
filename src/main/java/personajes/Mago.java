package personajes;

import items.armas.ArmaDeClase;

public class Mago extends Personaje {
    static final int FUERZA_MAGICA = 80;
    static final String nombre="Mage";
    static final int VIDA=100;
    public Mago() {
        super(nombre,FUERZA_MAGICA, VIDA,new ArmaDeClase("null",FUERZA_MAGICA,
                ArmaDeClase.ArmasDeClase.MAGE));

    }

    public static int getFuerzaMagica() {
        return FUERZA_MAGICA;
    }

    public static int getVIDA() {
        return VIDA;
    }
}
