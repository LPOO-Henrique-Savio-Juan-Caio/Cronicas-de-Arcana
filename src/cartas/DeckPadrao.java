package cartas;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckPadrao {
    //criei essa classe no intuito de armazenar os decks padroes que vou usar
    //ou seja:
    private ArrayList<String> deckPadrao1 = new ArrayList<>(Arrays.asList(
            // Criaturas (20)
            "Mago de Fogo", "Mago de Gelo", "Dragão de Fogo", "Dragão de Gelo", "Goblin",
            "Boneco de Neve", "Arqueiro", "Arqueiro de Fogo", "Assassino", "Homem da Caverna",
            "Guardiã do Inferno", "Forjador", "Lobo", "Colosso", "Golem",
            "Golem de Fogo", "Águia", "Cavaleiro dos Ventos", "Feiticeiro Maligno", "Fênix Branca",

            // Feitiços (5)
            "Bola de Fogo", "Tempestade de Gelo", "Necromancia", "Regeneração Profunda", "Toque de Vida",

            // Encantamentos (5)
            "Faíscas", "Estalagmites", "Temporal", "Regeneração Contínua", "Carregar Energia"
    ));

    private ArrayList<String> deckPadrao2 = new ArrayList<>(Arrays.asList(
            // Criaturas (20)
            "Tritão", "Salamandra", "Urso da Montanha", "Sereia", "Boto-cor-de-rosa",
            "Minotauro", "Gárgula", "Yeti", "Ancião da Floresta", "Fada da Neve",
            "Demônio", "Dragão da Tempestade", "Sombra", "Guerreiro", "Curandeira",
            "Fada Madrinha", "Arqueiro de Gelo", "Ceifador", "Bruxa do Pântano", "Bruxa de Fogo",

            // Feitiços (5)
            "Tempestade", "Espinhos Selvagens", "Fúria Vulcânica", "Energizar", "Raio de Esperança",

            // Encantamentos (5)
            "Terremoto", "Chuva de Lava", "Vida em Prestacao", "Sorte Divina", "Bateria Fraca"
    ));

    public ArrayList<String> getDeckPadrao1() {
        return deckPadrao1;
    }

    public ArrayList<String> getDeckPadrao2() {
        return deckPadrao2;
    }
    //dessa forma posso utilizar esses decks padroes no menu
}
