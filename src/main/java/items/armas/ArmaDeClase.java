package items.armas;

public class ArmaDeClase extends Arma {

    public enum ArmasDeClase{

        ORC("Hacha de Guerra"),
        MAGE("Baculo Helado"),
        ELF("Arco de guerra");

        private final String name;

        ArmasDeClase(String name){
            this.name=name;
        }
    }
    ArmasDeClase arma;
    public ArmaDeClase(String imagen, int danyo,ArmasDeClase arma) {
        super(arma.name, imagen, danyo);
        this.arma=arma;
    }

    public ArmasDeClase getArma() {
        return arma;
    }

    public void setArma(ArmasDeClase arma) {
        this.arma = arma;
    }
}
