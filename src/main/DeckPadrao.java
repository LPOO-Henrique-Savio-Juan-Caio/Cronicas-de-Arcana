package main;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckPadrao {
    //criei essa classe no intuito de armazenar os decks padroes que vou usar
    //ou seja:
    private ArrayList<String> deckPadrao1 = new ArrayList<>(Arrays.asList("Guerreiro Estelar", "Caminhante Lunar", "Serpente de Vênus", "Colosso Lunar", "Assassino Galáctico", "Guardião Estelar", "Espectro Espacial", "Caçador de Órion", "Titã Intergaláctico", "Fera Lunar", "Golem de Granito", "Elemental da Terra", "Serpente de Areia", "Troll Montanhoso", "Gigante da Floresta", "Guardião das Cavernas", "Monstro de Lava", "Fera Selvagem", "Colosso de Rocha", "Guardião de Terra", "Androide Blindado", "Sentinela Mecânica", "Escorpião de Metal", "Guerreiro Robótico", "Dragão de Aço", "Titã Robótico", "Assassino Cibernético", "Guardião Cibernético", "Mutante de Aço", "Serpente de Ferro", "Fênix Elétrica", "Serafim das Chamas", "Espírito do Trovão", "Titã do Vento", "Guardião das Tempestades", "Serpente de Fogo", "Dragão Elétrico", "Espírito das Chamas", "Colosso de Chamas", "Guardião do Trovão"));

    private ArrayList<String> deckPadrao2 = new ArrayList<>(Arrays.asList("Guerreiro Estelar", "Caminhante Lunar", "Serpente de Vênus", "Colosso Lunar", "Assassino Galáctico", "Guardião Estelar", "Espectro Espacial", "Caçador de Órion", "Titã Intergaláctico", "Fera Lunar", "Golem de Granito", "Elemental da Terra", "Serpente de Areia", "Troll Montanhoso", "Gigante da Floresta", "Guardião das Cavernas", "Monstro de Lava", "Fera Selvagem", "Colosso de Rocha", "Guardião de Terra", "Androide Blindado", "Sentinela Mecânica", "Escorpião de Metal", "Guerreiro Robótico", "Dragão de Aço", "Titã Robótico", "Assassino Cibernético", "Guardião Cibernético", "Mutante de Aço", "Serpente de Ferro", "Fênix Elétrica", "Serafim das Chamas", "Espírito do Trovão", "Titã do Vento", "Guardião das Tempestades", "Serpente de Fogo", "Dragão Elétrico", "Espírito das Chamas", "Colosso de Chamas", "Guardião do Trovão"));

    public ArrayList<String> getDeckPadrao1() {
        return deckPadrao1;
    }

    public ArrayList<String> getDeckPadrao2() {
        return deckPadrao2;
    }
    //dessa forma posso utilizar esses decks padroes no menu
}
