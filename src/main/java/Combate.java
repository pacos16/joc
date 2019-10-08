import items.Item;
import items.armas.Arma;
import items.consumibles.Poti;
import personajes.PersonajeEnCombate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combate implements Serializable {

    private Jugador jugador1;
    private Jugador jugador2;
    ArrayList<Turno> turnos;
    private PersonajeEnCombate personajeEnCombate1;
    private PersonajeEnCombate personajeEnCombate2;
    private static Scanner lector= new Scanner(System.in);

    public Combate(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        turnos=new ArrayList<>();
        personajeEnCombate1=new PersonajeEnCombate(jugador1.getNombre(),jugador1.getPersonaje(), jugador1.getMochila());
        personajeEnCombate2=new PersonajeEnCombate(jugador2.getNombre(),jugador2.getPersonaje(), jugador2.getMochila());
    }

    public void combatir(){

        while(personajeEnCombate1.getVidaActual()>0 && personajeEnCombate2.getVidaActual()>0){


            turnos.add(new Turno(personajeEnCombate1.getVidaActual(),personajeEnCombate2.getVidaActual(), Item itemP1, Item itemP2));
        }
    }

    public void atacarOItem(PersonajeEnCombate p){
        int eleccion=0;
        boolean entradaCorrectaDeDatos;
        do {
            entradaCorrectaDeDatos=true;
            System.out.println(p.getNombreJugador());
            System.out.println("1.Atacar");
            System.out.println("2.Mochila");
            try {
                eleccion = Integer.parseInt(lector.nextLine());
                if(eleccion<1 || eleccion>2){
                    entradaCorrectaDeDatos=false;
                }
            }catch (NumberFormatException nfe){
                entradaCorrectaDeDatos=false;
            }
        }while(!entradaCorrectaDeDatos);
        switch (eleccion){
            case 1:
            if(p.equals(personajeEnCombate1)){
                personajeEnCombate2.setVidaActual(personajeEnCombate2.getVidaActual()-calcularDanyo(p));
            }else{
                personajeEnCombate2.setVidaActual(personajeEnCombate1.getVidaActual()-calcularDanyo(p));
            }
            break;
            case 2:
                eleccion=0;
                do {
                    System.out.println("Elije un item");
                    for (int i = 0; i < p.getMochila().size(); i++) {
                        System.out.println((i + 1) + " " + p.getMochila().get(i).toString());
                    }
                    try {
                        eleccion = Integer.parseInt(lector.nextLine());
                        if (eleccion < 1 || eleccion > p.getMochila().size()) {
                            entradaCorrectaDeDatos = false;
                        }
                    } catch (NumberFormatException nfe) {
                        entradaCorrectaDeDatos = false;
                    }

                }while(!entradaCorrectaDeDatos);

                Item i=p.getMochila().get(eleccion);
                if(i instanceof Arma){

                }else if( i instanceof Poti){

                }
        }

    }

    private int calcularDanyo(int fuerza){

        Random rand= new Random();
        return fuerza+rand.nextInt(21)-10;
    }


}
