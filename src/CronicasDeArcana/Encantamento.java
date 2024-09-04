package CronicasDeArcana;

public class Encantamento extends Carta {
    private String efeito;
    
    public Encantamento (String nome, double custoMana, String efeito){
        super(nome, custoMana);
        this.efeito = efeito;
    }
}
