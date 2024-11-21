package cartas;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckPadrao {
    //criei essa classe no intuito de armazenar os decks padroes que vou usar
    //ou seja:
    private ArrayList<String> deckPadrao1 = new ArrayList<>(Arrays.asList(
            // Criaturas (20)
            "Mago de Fogo", "Mago de Gelo", "Dragao de Fogo", "Dragao de Gelo", "Goblin",
            "Boneco de Neve", "Arqueiro", "Arqueiro de Fogo", "Assassino", "Homem da Caverna",
            "Guardia do Inferno", "Forjador", "Lobo", "Colosso", "Golem",
            "Golem de Fogo", "Aguia", "Cavaleiro dos Ventos", "Feiticeiro Maligno", "Fenix Branca",

            // Feitiços (5)
            "Bola de Fogo", "Tempestade de Gelo", "Necromancia", "Regeneracao Profunda", "Toque de Vida",

            // Encantamentos (5)
            "Faíscas", "Estalagmites", "Inferno", "Concentração", "Cura Superior"
    ));

    private ArrayList<String> deckPadrao2 = new ArrayList<>(Arrays.asList(
            // Criaturas (20)
            "Tritao", "Salamandra", "Urso da Montanha", "Sereia", "Boto-cor-de-rosa",
            "Minotauro", "Gargula", "Yeti", "Anciao da Floresta", "Fada da Neve",
            "Demonio", "Dragao da Tempestade", "Sombra", "Guerreiro", "Curandeira",
            "Fada Madrinha", "Arqueiro de Gelo", "Ceifador", "Bruxa do Pantano", "Bruxa de Fogo",

            // Feitiços (5)
            "Tempestade", "Espinhos Selvagens", "Furia Vulcanica", "Energizar", "Raio de Esperanca",

            // Encantamentos (5)
            "Temporal", "Terremoto", "Raios", "Agonia", "Aura de Proteção"
    ));

    public ArrayList<String> getDeckPadrao1() {
        return deckPadrao1;
    }

    public ArrayList<String> getDeckPadrao2() {
        return deckPadrao2;
    }
    //dessa forma posso utilizar esses decks padroes no menu
}
