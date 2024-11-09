package Enum;

public enum Efeito {
    DANO(5.0),
    MUITO_DANO(10.0),
    VIDA(-5.0),
    MUITA_VIDA(-10.0),
    MANA(5.0),
    MUITA_MANA(10.0),
    REVIVER(0.0);

    private final double efeito;

    Efeito(double efeito){
        this.efeito = efeito;
    }

    public double getEfeito(){
        return this.efeito;
    }
}
