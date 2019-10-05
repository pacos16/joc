package items.armas;

import items.Item;

public abstract class Arma extends Item {

    int danyo;

    public Arma(String nombre, String imagen, int danyo) {
        super(nombre, imagen);
        this.danyo=danyo;
    }

    public int getDanyo() {
        return danyo;
    }

    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "Nombre: "+super.getNombre()+ " " +
                "danyo: " + danyo +
                '}';
    }
}
