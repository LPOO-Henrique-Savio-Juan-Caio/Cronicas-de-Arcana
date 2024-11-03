package Enum;

public enum Valores {
    VIDA(50.0),
    MANA(20.0);

    private final double valor;

    Valores(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
