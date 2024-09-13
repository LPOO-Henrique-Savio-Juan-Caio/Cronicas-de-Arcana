package CronicasDeArcana;

public class Encantamento extends Carta {
    private String efeito;
    
    public Encantamento (String nome, double custoMana, String tipoCarta, String efeito){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
    }
}
