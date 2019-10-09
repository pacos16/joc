import items.Item;
import personajes.PersonajeEnCombate;

import java.io.Serializable;

public class Turno implements Serializable {

    private int vidaP1;
    private int vidaP2;
    private Item itemP1;
    private Item itemP2;

    public Turno() {
    }

    public Turno(int vidaP1, int vidaP2, Item itemP1, Item itemP2) {
        this.vidaP1 = vidaP1;
        this.vidaP2 = vidaP2;
        this.itemP1 = itemP1;
        this.itemP2 = itemP2;
    }

    public int getVidaP1() {
        return vidaP1;
    }

    public void setVidaP1(int vidaP1) {
        this.vidaP1 = vidaP1;
    }

    public int getVidaP2() {
        return vidaP2;
    }

    public void setVidaP2(int vidaP2) {
        this.vidaP2 = vidaP2;
    }

    public Item getItemP1() {
        return itemP1;
    }

    public void setItemP1(Item itemP1) {
        this.itemP1 = itemP1;
    }

    public Item getItemP2() {
        return itemP2;
    }

    public void setItemP2(Item itemP2) {
        this.itemP2 = itemP2;
    }

}
