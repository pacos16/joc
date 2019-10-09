
import items.consumibles.PotiDanyo;
import items.consumibles.PotiVida;
import personajes.Mago;
import personajes.Orco;
import personajes.Personaje;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static DataBase dataBase;
    private static Scanner lector=new Scanner(System.in);
    private static File file =new File ("Fichero.dat");

    public static void main(String[] args) {
        cargarDatos();
        int opcion=0;
        boolean datosCorrectos;
        boolean salir=false;
        do {
            do {
                datosCorrectos = true;
                showMenu();
                try {
                    opcion = Integer.parseInt(lector.nextLine());
                    if (opcion > 8 || opcion < 1) {
                        System.out.println("Por favor introduzca un numero en el rango");
                        datosCorrectos = false;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Por favor introduzca un valor numerico");
                    datosCorrectos = false;
                }
            } while (!datosCorrectos);


            switch (opcion) {
                case 1:
                    for (Jugador j : dataBase.getJugadores()
                    ) {
                        System.out.print(j.toString());
                    }
                    pausa();

                    break;
                case 2:
                    crarNuevoJugador();
                    break;
                case 3:
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                        objectOutputStream.writeObject(dataBase);
                        objectOutputStream.close();
                        System.out.println("Datos guardados satisfactoriamente");
                        System.out.println("Hasta la proxima");
                        salir=true;
                        pausa();
                    } catch (Exception e) {
                        System.out.println("No se ha podido guardar");
                        System.out.println("Si desea salir pulse s");
                        if (lector.nextLine().equals("s")){
                            salir=true;
                        }else {
                            System.out.println("volviendo al menu");
                            pausa();
                        }
                    }
                    break;

                case 4:

                    do{
                        opcion=0;
                        datosCorrectos=true;
                        System.out.println("Dime un jugador");
                        for(int i=0;i< dataBase.getJugadores().size();i++){
                            System.out.println((i+1)+" "+ dataBase.getJugadores().get(i).getNombre());
                        }
                        try {
                            opcion= Integer.parseInt(lector.nextLine());
                            if(opcion<1 || opcion>dataBase.getJugadores().size()){
                                System.out.println("Introduzca un numero en el rango");
                                datosCorrectos=false;
                            }
                        }catch (NumberFormatException nfe){
                            System.out.println("Introduzca solo digitos");
                            datosCorrectos=false;
                        }


                    }while (!datosCorrectos);
                    if(dataBase.getJugadores().remove(dataBase.getJugadores().get(opcion-1))){
                        System.out.println("Jugador eliminado con exito");
                        pausa();
                    }else{
                        System.out.println("Jugador no eliminado");
                        pausa();
                    }
                    break;
                case 5:
                    do {
                        datosCorrectos=true;
                        opcion=0;
                        String nombre=null;
                        Personaje personaje=null;
                        System.out.println("Que desea modificar?");
                        System.out.println("1.Nombre");
                        System.out.println("2.Personaje");
                        try {
                            opcion = Integer.parseInt(lector.nextLine());
                            if (opcion < 1 || opcion > 2) {
                                datosCorrectos = false;
                                System.out.println("Introduzca un numero en el rango");
                            }else{
                                if(opcion==1){
                                    do{
                                        System.out.println("Dime el nuevo nombre");
                                        nombre= lector.nextLine();
                                    }while (nombre==null);

                                }else{
                                    personaje=elejirPersonaje();
                                }
                            }
                        }catch (NumberFormatException nfe){
                            System.out.println("Introduzca solo digitos");
                            datosCorrectos=false;
                        }



                    }while (!datosCorrectos);
                    break;
                case 6:


                    Combate combate=new Combate(dataBase.getJugadores().get(1), dataBase.getJugadores().get(0),true);
                    combate.combatir();
                    dataBase.getCombates().add(combate);
                    break;
                case 7:

                    System.out.println("Elije el jugador 1");
                    Jugador jugador1=elejirJugador();
                    Jugador jugador2;
                    do{
                        System.out.println("Elije al jugador 2");
                        jugador2=elejirJugador();
                        if(jugador1.equals(jugador2)){
                            System.out.println("El jugador no puede ser el mismo");
                        }
                    }while(jugador1.equals(jugador2));
                    combate=new Combate(jugador1,jugador2,false);
                    combate.combatir();
                    dataBase.getCombates().add(combate);
                    break;
                case 8:
                    do {
                        opcion=0;
                        datosCorrectos=true;
                        for (int i = 0; i < dataBase.getCombates().size(); i++) {
                            System.out.print((i + 1)+" " + dataBase.getCombates().get(i).getJugador1().getNombre() +
                                    "vs" +
                                    dataBase.getCombates().get(i).getJugador2().getNombre());
                            if(dataBase.getCombates().get(i).isAleatorio()){
                                System.out.print("(Aleatorio)");
                            }
                            System.out.println("");
                        }
                        try {
                            opcion = Integer.parseInt(lector.nextLine());
                            if(opcion<1|| opcion> dataBase.getCombates().size()){
                                System.out.println("Introduzca numeros en el rango");
                                datosCorrectos=false;
                            }
                        }catch (NumberFormatException nfe){
                            datosCorrectos=false;
                            System.out.println("Introduzca solo digitos");
                        }

                    }while(!datosCorrectos);
                    System.out.println(dataBase.getCombates().get(opcion-1));
                    pausa();
            }
        }while(!salir);

    }
    private static Jugador elejirJugador(){
        boolean datosCorrectos;
        int opcion;
        do {
            opcion=0;
            datosCorrectos=true;
            for (int i = 0; i < dataBase.getJugadores().size(); i++) {
                System.out.println((i + 1) + " " + dataBase.getJugadores().get(i).getNombre());
            }
            try{
                opcion= Integer.parseInt(lector.nextLine());
                if(opcion<1 || opcion> dataBase.getJugadores().size()){
                    System.out.println("Introduzca un numero en el rango");
                    datosCorrectos=false;
                }
            }catch (NumberFormatException nfe){
                System.out.println("Introduzca digitos");
                datosCorrectos=false;
            }
        }while(!datosCorrectos);
        return dataBase.getJugadores().get(opcion-1);
    }
    private static void pausa(){
        System.out.println("Pulsa intro para continuar");
        lector.nextLine();
    }
    private static void cargarDatos(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            dataBase = (DataBase) objectInputStream.readObject();
            System.out.println("S'han carregat "+dataBase.getJugadores().size()+" jugadors");
        }catch (ClassNotFoundException cnfe){
            dataBase=new DataBase();
            System.out.println("Clase no encontrada");
            cargarPordefecto();

        }catch (IOException ioe){
            dataBase=new DataBase();
            System.out.println("Fichero no encontrado");
            cargarPordefecto();
        }
        dataBase.anyadirPersonajes();
        pausa();
    }
    private static void cargarPordefecto(){
        System.out.println("Se cargaran los valores por defecto");
        Personaje personaje1=new Orco();
        Personaje personaje2=new Mago();
        Jugador jugador1=new Jugador("Paco",personaje1);
        Jugador jugador2=new Jugador("Miquel",personaje2);

        jugador1.anyadirAMochila(new PotiVida());
        jugador1.anyadirAMochila(new PotiDanyo());
        jugador2.anyadirAMochila(new PotiVida());
        jugador2.anyadirAMochila(new PotiDanyo());
        dataBase.getJugadores().add(jugador1);
        dataBase.getJugadores().add(jugador2);

    }

    private static void showMenu(){
        System.out.println("   _____                 __         .__                       \n" +
                "  /     \\   ____________/  |______  |  |                      \n" +
                " /  \\ /  \\ /  _ \\_  __ \\   __\\__  \\ |  |                      \n" +
                "/    Y    (  <_> )  | \\/|  |  / __ \\|  |__                    \n" +
                "\\____|__  /\\____/|__|   |__| (____  /____/                    \n" +
                "        \\/                        \\/                          \n" +
                "  _________            .__       .__  .__                     \n" +
                " /   _____/ ___________|__|____  |  | |__|_______ ___________ \n" +
                " \\_____  \\_/ __ \\_  __ \\  \\__  \\ |  | |  \\___   // __ \\_  __ \\\n" +
                " /        \\  ___/|  | \\/  |/ __ \\|  |_|  |/    /\\  ___/|  | \\/\n" +
                "/_______  /\\___  >__|  |__(____  /____/__/_____ \\\\___  >__|   \n" +
                "        \\/     \\/              \\/              \\/    \\/       \n" +
                "       ____                                                   \n" +
                "___  _/_   |                                                  \n" +
                "\\  \\/ /|   |                                                  \n" +
                " \\   / |   |                                                  \n" +
                "  \\_/  |___|                                                  \n" +
                "                ");

        System.out.println("1.Llistar jugadors");
        System.out.println("2.Afejir jugador");
        System.out.println("3.Eixir");
        System.out.println("4.Eliminar Jugador");
        System.out.println("5.Modificar Jugador");
        System.out.println("6.Combate aleatorio");
        System.out.println("7.Combate 1v1");
        System.out.println("8.Listar combates");

    }


    private static void crarNuevoJugador(){
        String nombre=null;
        Personaje personaje;
        System.out.println("Crear Nuevo Jugador");
        boolean nombreRepetido;
        do {
            nombreRepetido=false;
            System.out.println("Dime el nombre");
            nombre= lector.nextLine();
            for (Jugador j: dataBase.getJugadores()
                 ) {
                if(j.getNombre().equals(nombre)){
                    nombreRepetido=true;
                }
            }
            if(nombreRepetido){
                System.out.println("Este nombre ya existe");
                pausa();
            }
        }while (nombre!=null && nombreRepetido);
        personaje=elejirPersonaje();
        dataBase.getJugadores().add(new Jugador(nombre,personaje));
        System.out.println("Personaje creado satisfactoriamente");
        pausa();
    }

    public static Personaje elejirPersonaje(){
        int eleccion;
        boolean datosCorrectos;
        do{
            eleccion=0;
            datosCorrectos=true;
            System.out.println("Dime el personaje");
            for(int i=0;i<dataBase.getPersonajes().size();i++){
                System.out.println((i+1)+ dataBase.getPersonajes().get(i).toString());
            }
            try {
                eleccion = Integer.parseInt(lector.nextLine());
                if (eleccion < 1 || eleccion > dataBase.getPersonajes().size()) {
                    System.out.println("Introduzca un numero en el rango");
                    datosCorrectos = false;
                }
            }catch (NumberFormatException nfe){
                datosCorrectos=false;
                System.out.println("Introduzca solo digitos");
            }

        }while (!datosCorrectos);
        return dataBase.getPersonajes().get(eleccion-1);
    }





}
