package entidades.zonas;

import entidades.carta.Carta;
import java.util.ArrayList;

public interface AcoesZonas {
    Carta selecionarCarta(ArrayList<Carta> arrayCartas, String nomeCarta);
    void adicionarCarta(Carta carta);
    void removerCarta(Carta carta);
}
