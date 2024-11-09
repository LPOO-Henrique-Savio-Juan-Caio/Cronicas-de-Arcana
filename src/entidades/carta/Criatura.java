package entidades.carta;

public class Criatura extends Carta {
    private double poder;
    private String habilidade;
    private double resistencia;
    private final double resistenciaTotal;

    public Criatura (String nome, double custoMana,String tipoCarta, double poder, String habilidade, double resistencia){
        super(nome, custoMana, tipoCarta, poder);
        this.habilidade = habilidade;
        this.resistencia = resistencia;
        this.resistenciaTotal = resistencia;
    }

    //implementação do metodo abstrato
    @Override
    public void receberDano(double dano) {
        setResistencia(getResistencia() - dano);
        if (getResistencia() < 0) {
            setResistencia(0); // Evitar resistência negativa
        }
    }
    
    @Override
    public void setResistencia(double resistencia){
        this.resistencia = resistencia;
    }
    
    @Override
    public double getResistencia() {
        return resistencia;
    }
    @Override
    public double getResistenciaTotal() {
        return resistenciaTotal;
    }

    public String getHabilidade(){
        return this.habilidade;
    }

    @Override
    public String getTipoCarta(){
        return "Criatura";
    }
}
