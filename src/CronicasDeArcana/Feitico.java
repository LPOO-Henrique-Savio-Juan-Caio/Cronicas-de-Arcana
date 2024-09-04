package CronicasDeArcana;

public class Feitico extends Carta {
    private String efeito;

    public Feitico (String nome, double custoMana, String efeito){
        super(nome, custoMana);
        this.efeito = efeito;
    }
}
