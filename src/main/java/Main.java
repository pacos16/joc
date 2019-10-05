
import items.consumibles.PotiVida;
import personajes.Orco;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Jugador jugador=new Jugador("Paco", new Orco());
        jugador.anyadirAMochila(new PotiVida());

        System.out.println(jugador);

        File file =new File ("Fichero.dat");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(jugador);
            objectOutputStream.close();
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
            Jugador jugador1= (Jugador) objectInputStream.readObject();
            System.out.println(jugador1.toString());
        }catch (FileNotFoundException fnfe){
            System.out.println("fnfe");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            System.out.println("Class not found exception");
        }


    }

}
