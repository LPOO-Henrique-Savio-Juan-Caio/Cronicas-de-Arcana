package entidades.carta;

public class Feitico extends Carta {
    private String efeito;

    public Feitico (String nome, double custoMana, String tipoCarta, String efeito){
        super(nome, custoMana, tipoCarta);
        this.efeito = efeito;
    }
    public String getEfeito() {
        return efeito;
    }

    @Override
    public void receberDano(double dano) {
    }

    @Override
    public double getResistencia() {
        return 0;
    }
    
    @Override
    public String getTipoCarta(){
        return "Feitiço";
    }

    @Override
    public void setResistencia(double resistencia){
        
    }
    
    @Override
    public double getResistenciaTotal() {
        return 0;
    }
    
}
