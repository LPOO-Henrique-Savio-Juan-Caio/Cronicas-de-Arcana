package CronicasDeArcana;

public abstract class Carta {
    private String nome;
    private double custoMana;

    public Carta(String nome, double custoMana){
        this.nome = nome;
        this.custoMana = custoMana;
    }

    private void alterarVida(double resistencia, double alterarVida){
        resistencia += alterarVida;
    }

    public void setDano(double resistencia, double alterarVida){
        alterarVida(resistencia, alterarVida);
    }

    private void alterarMana(double alterarMana, double mana){
        mana += alterarMana;
    }

    public void setMana(double alterarMana, double mana){
        alterarMana(alterarMana, mana);
    }
}
