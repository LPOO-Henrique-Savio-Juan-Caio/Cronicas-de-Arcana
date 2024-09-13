package CronicasDeArcana;

public class Feitico extends Carta {
    private String efeito;

    public Feitico (String nome, double custoMana, String tipoCarta, String efeito){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
    }
}
