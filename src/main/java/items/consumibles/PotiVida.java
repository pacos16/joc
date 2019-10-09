package items.consumibles;

import personajes.PersonajeEnCombate;

public class PotiVida extends Poti {

    private final static String nombre="Pocion de Vida";
    private final static String imagen="Src";
    private final static int recuperacion=50;
    private final static String descripcion="Recuperas "+recuperacion+" de vida";
    private final static int precio=150;


    public PotiVida() {
        super(nombre, imagen, descripcion);


    }

    public boolean efecto(PersonajeEnCombate p){
        p.setVidaActual(p.getVidaActual()+recuperacion);

        if(p.getVidaActual()>p.getPersonaje().getVida()){

            p.setVidaActual(p.getPersonaje().getVida());
        }
        this.setStack(this.getStack()-1);
        if(this.getStack()<=0){
            return false;
        }

        return true;
    }

}
