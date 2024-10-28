package CronicasDeArcana;

public abstract  class Carta {
    private String nome;
    private double custoMana;
    private String tipoCarta;
    private double poder;

    //Construtor default
    public Carta(){
    }
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

    public void alterarVida(double resistencia, double alterarVida){
        resistencia += alterarVida;
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

    //metodo abstrato
    public abstract void receberDano(double dano);

    public abstract double getResistencia();

    @Override
    public String toString() {
        return "Carta: " + nome + ", Resistência: " + getResistencia();
    }

}

