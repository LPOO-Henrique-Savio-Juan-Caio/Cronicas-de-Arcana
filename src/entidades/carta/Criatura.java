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
        setResistencia(getResistencia() - dano);
        if (getResistencia() < 0) {
            setResistencia(0); // Evitar resistência negativa
        }
    }

    public void setResistencia(double resistencia){
        this.resistencia = resistencia;
    }
    
    @Override
    public double getResistencia() {
        return resistencia;
    }

    public String getHabilidade(){
        return this.habilidade;
    }
}
