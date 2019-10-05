import java.io.Serializable;
import java.util.ArrayList;

public class Combate implements Serializable {

    private Jugador jugador1;
    private Jugador jugador2;
    ArrayList<Turno> turnos;

    public Combate(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        turnos=new ArrayList<>();
    }


}
