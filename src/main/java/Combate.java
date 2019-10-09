import items.Item;
import items.armas.Arma;
import items.consumibles.Poti;
import personajes.PersonajeEnCombate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combate implements Serializable {
    private Random random=new Random();
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Turno> turnos;
    private PersonajeEnCombate personajeEnCombate1;
    private PersonajeEnCombate personajeEnCombate2;
    private static Scanner lector= new Scanner(System.in);
    private int danyoPj1;
    private int danyoPj2;
    private boolean aleatorio;

    public Combate(){
        turnos=new ArrayList<>();
        danyoPj1=0;
        danyoPj2=0;
    }
    public Combate(Jugador jugador1, Jugador jugador2, boolean aleatorio) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        turnos=new ArrayList<>();
        personajeEnCombate1=new PersonajeEnCombate(jugador1.getNombre(),jugador1.getPersonaje(), jugador1.getMochila());
        personajeEnCombate2=new PersonajeEnCombate(jugador2.getNombre(),jugador2.getPersonaje(), jugador2.getMochila());
        danyoPj1=0;
        danyoPj2=0;
        this.aleatorio=aleatorio;
    }

    public void combatir(){

        while(personajeEnCombate1.getVidaActual()>0 && personajeEnCombate2.getVidaActual()>0){
            Item itemP1=atacarOItem(personajeEnCombate1);
            Item itemP2=null;
            if(personajeEnCombate2.getVidaActual()>0){
                itemP2=atacarOItem(personajeEnCombate2);
            }
            turnos.add(new Turno(personajeEnCombate1.getVidaActual(),personajeEnCombate2.getVidaActual(),itemP1, itemP2));
        }
        if(personajeEnCombate1.getVidaActual()>0){
            System.out.println("Fin del combate ha ganado "+personajeEnCombate1.getNombreJugador());
        }else{
            System.out.println("Fin del combate ha ganado "+personajeEnCombate2.getNombreJugador());
        }
    }

    private Item atacarOItem(PersonajeEnCombate p){
        int eleccion=0;
        boolean entradaCorrectaDeDatos;
        do {
            entradaCorrectaDeDatos=true;
            System.out.println(p.getNombreJugador()+"  Vida:"+p.getVidaActual());
            System.out.println("1.Atacar (Daño= "+p.getFuerzaActual()+")");
            System.out.println("2.Mochila");
            if(aleatorio){
                eleccion=random.nextInt(2)+1;
                sleep();
            }else {
                try {
                    eleccion = Integer.parseInt(lector.nextLine());
                    if (eleccion < 1 || eleccion > 2) {
                        entradaCorrectaDeDatos = false;
                        System.out.println("Mal");
                    }
                } catch (NumberFormatException nfe) {
                    entradaCorrectaDeDatos = false;
                }
            }
        }while(!entradaCorrectaDeDatos);
        switch (eleccion){
            case 1:
            atacar(p);
            return null;

            case 2:
                eleccion=0;
                if(p.getMochila().size()>=1) {
                    do {
                        entradaCorrectaDeDatos=true;
                        System.out.println("Elije un item");
                        for (int i = 0; i < p.getMochila().size(); i++) {
                            System.out.println((i + 1) + " " + p.getMochila().get(i).toString());
                        }
                        if(aleatorio){
                            eleccion=random.nextInt(p.getMochila().size())+1;
                            sleep();
                        }else {
                            try {
                                eleccion = Integer.parseInt(lector.nextLine());
                                if (eleccion < 1 || eleccion > p.getMochila().size()) {
                                    entradaCorrectaDeDatos = false;
                                }
                            } catch (NumberFormatException nfe) {
                                entradaCorrectaDeDatos = false;
                            }
                        }



                    }while(!entradaCorrectaDeDatos);

                    Item i=p.getMochila().get(eleccion-1);
                    if(i instanceof Arma){
                        int danyoAux=p.getFuerzaActual()-p.getPersonaje().getFuerza();
                        p.setFuerzaActual(((Arma) i).getDanyo()+danyoAux);
                        atacar(p);
                        p.setFuerzaActual(p.getPersonaje().getFuerza()+danyoAux);
                    }else if( i instanceof Poti){
                        System.out.println("Has tomado "+i.getNombre());
                        System.out.println("Pulsa intro para continuar");
                        lector.nextLine();
                        if(!((Poti) i).efecto(p)){
                            p.getMochila().remove(i);
                        }
                    }

                    return i;
                }
                System.out.println("La mochila esta vacia");
                return atacarOItem(p);

        }
        return null;
    }

    private int calcularDanyo(int fuerza){

        Random rand= new Random();
        return fuerza+rand.nextInt(21)-10;
    }

    private void atacar(PersonajeEnCombate p){
        int danyoEsteTurno=calcularDanyo(p.getFuerzaActual());
        if(p.equals(personajeEnCombate1)){
            personajeEnCombate2.setVidaActual(personajeEnCombate2.getVidaActual()-danyoEsteTurno);
            danyoPj1+=danyoEsteTurno;
        }else{
            personajeEnCombate1.setVidaActual(personajeEnCombate1.getVidaActual()-danyoEsteTurno);
            danyoPj2+=danyoEsteTurno;
        }
        System.out.println("Has inflijido "+danyoEsteTurno+" danyo");
        System.out.println("Pulsa intro para continuar");
        lector.nextLine();

    }
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append(jugador1.getNombre()).append(" vs ").append(jugador2.getNombre()).append("\n\n");
        for (int i=0;i<turnos.size();i++
             ) {
            stringBuilder.append("Turno:  ").append(i+1).append("\n");
            stringBuilder.append(jugador1.getNombre()).append(" ").append(turnos.get(i).getVidaP1()).append("\n");

            stringBuilder.append(jugador2.getNombre()).append(" ").append(turnos.get(i).getVidaP2()).append("\n");

        }
        return stringBuilder.toString();


    }

    public boolean isAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(boolean aleatorio) {
        this.aleatorio = aleatorio;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public PersonajeEnCombate getPersonajeEnCombate1() {
        return personajeEnCombate1;
    }

    public void setPersonajeEnCombate1(PersonajeEnCombate personajeEnCombate1) {
        this.personajeEnCombate1 = personajeEnCombate1;
    }

    public PersonajeEnCombate getPersonajeEnCombate2() {
        return personajeEnCombate2;
    }

    public void setPersonajeEnCombate2(PersonajeEnCombate personajeEnCombate2) {
        this.personajeEnCombate2 = personajeEnCombate2;
    }

    public static Scanner getLector() {
        return lector;
    }

    public static void setLector(Scanner lector) {
        Combate.lector = lector;
    }

    public int getDanyoPj1() {
        return danyoPj1;
    }

    public void setDanyoPj1(int danyoPj1) {
        this.danyoPj1 = danyoPj1;
    }

    public int getDanyoPj2() {
        return danyoPj2;
    }

    public void setDanyoPj2(int danyoPj2) {
        this.danyoPj2 = danyoPj2;
    }
    private void sleep(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

