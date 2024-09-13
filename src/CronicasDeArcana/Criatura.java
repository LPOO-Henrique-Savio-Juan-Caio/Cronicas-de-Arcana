package CronicasDeArcana;

public class Criatura extends Carta {
    private double poder;
    private String habilidade;
    private double resistencia;

    public Criatura (String nome, double custoMana,String tipoCarta, double poder, String habilidade, double resistencia){
        super(nome, custoMana, tipoCarta);
        this.poder = poder;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
    }
}
