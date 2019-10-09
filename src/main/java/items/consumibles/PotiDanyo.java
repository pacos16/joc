package items.consumibles;

import personajes.PersonajeEnCombate;

public class PotiDanyo extends Poti {
    private final static String nombre="Pocion de daño";
    private final static String imagen="Src";
    private final static String descripcion="Aumenta tu daño en 10";
    private final static int precio=150;
    private final static int aumentoDanyo=10;

    public PotiDanyo() {
        super(nombre, imagen, descripcion);

    }

    public boolean efecto(PersonajeEnCombate p){
        p.setFuerzaActual(p.getFuerzaActual()+aumentoDanyo);

        this.setStack(this.getStack()-1);
        if(this.getStack()<=0){
            return false;
        }

        return true;
    }
}
