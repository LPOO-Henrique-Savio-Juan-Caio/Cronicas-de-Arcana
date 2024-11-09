package entidades.carta;

public class Encantamento extends Carta {
    private String efeito;
    
    public Encantamento (String nome, double custoMana, String tipoCarta, String efeito){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
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
}
