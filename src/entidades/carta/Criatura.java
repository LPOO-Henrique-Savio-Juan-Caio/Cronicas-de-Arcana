package entidades.carta;

public class Criatura extends Carta {
    private double poder;
    private String habilidade;
    private double resistencia;

    public Criatura (String nome, double custoMana,String tipoCarta, double poder, String habilidade, double resistencia){
        super(nome, custoMana, tipoCarta, poder);
        this.habilidade = habilidade;
        this.resistencia = resistencia;
    }

    //implementação do metodo abstrato
    @Override
    public void receberDano(double dano) {
        this.resistencia -= dano;
        if (this.resistencia < 0) {
            this.resistencia = 0; // Evitar resistência negativa
        }
    }
    
    @Override
    public double getResistencia() {
        return resistencia;
    }
}
