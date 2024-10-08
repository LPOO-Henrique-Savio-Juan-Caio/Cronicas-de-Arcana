package CronicasDeArcana;

import java.util.ArrayList;
import java.util.List;

public abstract  class Carta {
    private String nome;
    private double custoMana;
    private String tipoCarta;
    private double poder;

    //construtor de Criatura
    public Carta(String nome, double custoMana, String tipoCarta, double poder){
        this.tipoCarta = tipoCarta;
        this.nome = nome;
        this.custoMana = custoMana;
        this.poder = poder;
    }
    //construtor de Feitiço/Encantamento
    public Carta(String nome, double custoMana, String tipoCarta){
        this.tipoCarta = tipoCarta;
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

    public double getCustoMana(){
       return this.custoMana;
    }

    public String getNome(){
        return this.nome;
    }
    
    public double getPoder(){
        return this.poder;
    }

    
}
				   
