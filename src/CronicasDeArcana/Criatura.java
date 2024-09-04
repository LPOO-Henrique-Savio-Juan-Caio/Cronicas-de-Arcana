package CronicasDeArcana;

public class Criatura extends Carta {
    private double poder;
    private String habilidade;
    private double resistencia;

    public Criatura (String nome, double custoMana, double poder, String habilidade, double resistencia){
        super(nome, custoMana);
        this.poder = poder;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
    }
}
