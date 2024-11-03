package main;

import entidades.carta.Carta;
import entidades.carta.Criatura;
import java.util.ArrayList;

public class CartasJogo {
    //essa classe vai armazenar todas as cartas do jogo
    private ArrayList<Carta> arrayCartas;


    public CartasJogo() {
        arrayCartas = new ArrayList<>();

        // Adicionando 40 objetos da classe Criatura.
        arrayCartas.add(new Criatura("Guerreiro Estelar", 4, "Alienígena", 7.0, "Rajada Cósmica", 6.5));
        arrayCartas.add(new Criatura("Caminhante Lunar", 3, "Alienígena", 5.5, "Salto Espacial", 4.5));
        arrayCartas.add(new Criatura("Serpente de Vênus", 5, "Alienígena", 8.0, "Veneno Galáctico", 7.0));
        arrayCartas.add(new Criatura("Colosso Lunar", 6, "Alienígena", 9.5, "Soco Estelar", 8.5));
        arrayCartas.add(new Criatura("Assassino Galáctico", 3, "Alienígena", 6.5, "Ataque Sombrio", 5.5));
        arrayCartas.add(new Criatura("Guardião Estelar", 5, "Alienígena", 8.5, "Barreira de Plasma", 7.5));
        arrayCartas.add(new Criatura("Espectro Espacial", 4, "Alienígena", 7.0, "Invisibilidade Cósmica", 6.0));
        arrayCartas.add(new Criatura("Caçador de Órion", 6, "Alienígena", 9.0, "Golpe Celestial", 8.0));
        arrayCartas.add(new Criatura("Titã Intergaláctico", 7, "Alienígena", 10.5, "Impacto Estelar", 9.5));
        arrayCartas.add(new Criatura("Fera Lunar", 5, "Alienígena", 8.0, "Garras de Plasma", 7.0));

        arrayCartas.add(new Criatura("Golem de Granito", 5, "Terrestre", 8.5, "Soco Rochoso", 7.5));
        arrayCartas.add(new Criatura("Elemental da Terra", 6, "Terrestre", 9.0, "Tremor de Terra", 8.0));
        arrayCartas.add(new Criatura("Serpente de Areia", 4, "Terrestre", 7.0, "Tempestade de Areia", 6.5));
        arrayCartas.add(new Criatura("Troll Montanhoso", 5, "Terrestre", 8.0, "Golpe de Pedra", 7.0));
        arrayCartas.add(new Criatura("Gigante da Floresta", 7, "Terrestre", 10.0, "Machado de Carvalho", 9.0));
        arrayCartas.add(new Criatura("Guardião das Cavernas", 6, "Terrestre", 9.5, "Escudo de Rocha", 8.5));
        arrayCartas.add(new Criatura("Monstro de Lava", 8, "Terrestre", 11.0, "Erupção Vulcânica", 10.0));
        arrayCartas.add(new Criatura("Fera Selvagem", 4, "Terrestre", 7.5, "Investida Bestial", 6.5));
        arrayCartas.add(new Criatura("Colosso de Rocha", 7, "Terrestre", 10.5, "Sopro de Montanha", 9.5));
        arrayCartas.add(new Criatura("Guardião de Terra", 5, "Terrestre", 8.5, "Escudo de Pedras", 7.5));

        arrayCartas.add(new Criatura("Androide Blindado", 6, "Cibernético", 9.0, "Barreira de Aço", 8.0));
        arrayCartas.add(new Criatura("Sentinela Mecânica", 5, "Cibernético", 8.0, "Tiro Laser", 7.0));
        arrayCartas.add(new Criatura("Escorpião de Metal", 4, "Cibernético", 7.5, "Ferrão Cibernético", 6.5));
        arrayCartas.add(new Criatura("Guerreiro Robótico", 5, "Cibernético", 8.0, "Corte de Aço", 7.0));
        arrayCartas.add(new Criatura("Dragão de Aço", 7, "Cibernético", 10.5, "Sopro de Metal", 9.5));
        arrayCartas.add(new Criatura("Titã Robótico", 8, "Cibernético", 11.0, "Pancada de Ferro", 10.0));
        arrayCartas.add(new Criatura("Assassino Cibernético", 5, "Cibernético", 8.5, "Golpe Preciso", 7.5));
        arrayCartas.add(new Criatura("Guardião Cibernético", 6, "Cibernético", 9.5, "Proteção de Metal", 8.5));
        arrayCartas.add(new Criatura("Mutante de Aço", 7, "Cibernético", 10.0, "Fusão Metálica", 9.0));
        arrayCartas.add(new Criatura("Serpente de Ferro", 6, "Cibernético", 9.0, "Esmagamento Mecânico", 8.0));

        arrayCartas.add(new Criatura("Fênix Elétrica", 6, "Elementar", 9.0, "Renascimento Elétrico", 8.0));
        arrayCartas.add(new Criatura("Serafim das Chamas", 7, "Elementar", 10.0, "Explosão de Fogo", 9.0));
        arrayCartas.add(new Criatura("Espírito do Trovão", 5, "Elementar", 8.0, "Golpe de Relâmpago", 7.0));
        arrayCartas.add(new Criatura("Titã do Vento", 6, "Elementar", 9.5, "Tornado Devastador", 8.5));
        arrayCartas.add(new Criatura("Guardião das Tempestades", 7, "Elementar", 10.5, "Fúria dos Ventos", 9.5));
        arrayCartas.add(new Criatura("Serpente de Fogo", 5, "Elementar", 8.5, "Chamas Vorazes", 7.5));
        arrayCartas.add(new Criatura("Dragão Elétrico", 8, "Elementar", 11.0, "Choque de Trovão", 10.0));
        arrayCartas.add(new Criatura("Espírito das Chamas", 6, "Elementar", 9.0, "Fogo Espiritual", 8.0));
        arrayCartas.add(new Criatura("Colosso de Chamas", 7, "Elementar", 10.0, "Erupção de Fogo", 9.0));
        arrayCartas.add(new Criatura("Guardião do Trovão", 6, "Elementar", 9.5, "Escudo Elétrico", 8.5));
    }

    public ArrayList<Carta> getArrayCartas() {
        return arrayCartas;
    }
}
