package entidades.carta;

public class Encantamento extends Carta {
    private String efeito;
    private int duracao;
    private int duracaomaxima;
    
    public Encantamento (String nome, double custoMana, String tipoCarta, String efeito, int duracao){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
        this.duracao = duracao;
        this.duracaomaxima = duracao;
    }

    public int getDuracaomaxima() {
        return duracaomaxima;
    }
    
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void decresceDuracao(){
        this.duracao -= 1;
    }



    public String getEfeito() {
        return efeito;
    }
    
    @Override
    public String getTipoCarta(){
        return "Encantamento";
    }

    @Override
    public void receberDano(double dano) {
        // encantamento não tem resistência, então o método está vazio
    }

    //isso aqui é muita gambiarra
    @Override
    public double getResistencia() {
        return 0;
    }

    @Override
    public void setResistencia(double resistencia){
        
    }
    
    
    @Override
    public double getResistenciaTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
