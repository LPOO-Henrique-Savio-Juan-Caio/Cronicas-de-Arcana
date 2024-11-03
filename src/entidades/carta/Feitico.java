package entidades.carta;

public class Feitico extends Carta {
    private String efeito;

    public Feitico (String nome, double custoMana, String tipoCarta, String efeito){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
    }

    @Override
    public void receberDano(double dano) {
        // Feitiço não tem resistência, então o método está vazio
    }

    //isso aqui é muita gambiarra
    @Override
    public double getResistencia() {
        return 0;
    }
    
}
