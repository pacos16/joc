import personajes.Elfo;
import personajes.Mago;
import personajes.Orco;
import personajes.Personaje;

import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Combate> combates;
    private ArrayList<Personaje> personajes;


    public DataBase(){
        jugadores=new ArrayList<>();
        combates=new ArrayList<>();


    }

    public DataBase(ArrayList<Jugador> jugadores, ArrayList<Combate> combates) {
        this.jugadores = jugadores;
        this.combates = combates;

    }


    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Combate> getCombates() {
        return combates;
    }

    public void setCombates(ArrayList<Combate> combates) {
        this.combates = combates;
    }
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }


    public String combatesToString(){
        StringBuilder stringBuilder=new StringBuilder();
        for (Combate c:combates
             ) {
            stringBuilder.append(c.toString());
        }
        return stringBuilder.toString();
    }
    public  void anyadirPersonajes(){
        personajes=new ArrayList<>();
        personajes.add(new Orco());
        personajes.add(new Mago());
        personajes.add(new Elfo());
    }
}
