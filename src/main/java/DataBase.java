import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Combate> combates;

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
}
