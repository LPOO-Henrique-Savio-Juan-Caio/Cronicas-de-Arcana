package cartas;

import entidades.carta.*;
import java.util.ArrayList;

public class CartasJogo {
    //essa classe vai armazenar todas as cartas do jogo
    private ArrayList<Carta> arrayCartas;

    public CartasJogo() {
        arrayCartas = new ArrayList<>();

        // Adicionando 40 objetos da classe Criatura.
        arrayCartas.add(new Criatura("Mago de Fogo", 5.0, "Fogo", 7.0, "Explosao Ignea", 6.0));
        arrayCartas.add(new Criatura("Mago de Gelo", 5.0, "Gelo", 7.0, "Congelamento Absoluto", 6.0));
        arrayCartas.add(new Criatura("Dragao de Fogo", 8.0, "Fogo", 10.0, "Sopro Flamejante", 9.0));
        arrayCartas.add(new Criatura("Dragao de Gelo", 8.0, "Gelo", 10.0, "Sopro Congelante", 9.0));
        arrayCartas.add(new Criatura("Goblin", 3.0, "Terra", 5.0, "Emboscada Surpresa", 4.5));
        arrayCartas.add(new Criatura("Boneco de Neve", 3.5, "Gelo", 5.0, "Escudo Congelado", 5.5));
        arrayCartas.add(new Criatura("Arqueiro", 4.0, "Ar", 6.0, "Tiro Preciso", 5.0));
        arrayCartas.add(new Criatura("Arqueiro de Fogo", 5.0, "Fogo", 7.0, "Flecha Incandescente", 6.0));
        arrayCartas.add(new Criatura("Assassino", 4.0, "Ar", 6.5, "Golpe Silencioso", 5.5));
        arrayCartas.add(new Criatura("Homem da Caverna", 4.0, "Terra", 6.5, "Forca Primordial", 5.0));
        arrayCartas.add(new Criatura("Guardia do Inferno", 6.0, "Fogo", 8.0, "Labareda Infernal", 7.0));
        arrayCartas.add(new Criatura("Forjador", 5.5, "Fogo", 7.5, "Martelo Flamejante", 6.5));
        arrayCartas.add(new Criatura("Lobo", 4.0, "Gelo", 6.0, "Uivo Gelido", 5.0));
        arrayCartas.add(new Criatura("Colosso", 6.5, "Terra", 8.5, "Tremor de Terra", 7.5));
        arrayCartas.add(new Criatura("Golem", 6.0, "Terra", 8.0, "Pele de Pedra", 7.0));
        arrayCartas.add(new Criatura("Golem de Fogo", 6.5, "Fogo", 8.5, "Fogo da Terra", 7.5));
        arrayCartas.add(new Criatura("Aguia", 4.5, "Ar", 6.5, "Visao Aguacada", 5.5));
        arrayCartas.add(new Criatura("Cavaleiro dos Ventos", 5.5, "Ar", 7.5, "Lamina Veloz", 6.5));
        arrayCartas.add(new Criatura("Feiticeiro Maligno", 7.0, "Fogo", 9.0, "Reviver", 8.0));
        arrayCartas.add(new Criatura("Fenix Branca", 8.0, "Gelo", 9.0, "Reviver", 8.0));
        arrayCartas.add(new Criatura("Tritao", 5.0, "Gelo", 7.5, "Onda Explosiva", 6.5));
        arrayCartas.add(new Criatura("Salamandra", 5.5, "Fogo", 7.0, "Chama Vital", 6.0));
        arrayCartas.add(new Criatura("Urso da Montanha", 4.5, "Terra", 7.0, "Abraco de Urso", 6.5));
        arrayCartas.add(new Criatura("Sereia", 4.0, "Gelo", 6.0, "Canto", 5.0));
        arrayCartas.add(new Criatura("Boto-cor-de-rosa", 3.5, "Gelo", 5.5, "Conto", 4.5));
        arrayCartas.add(new Criatura("Minotauro", 6.0, "Terra", 8.5, "Investida", 7.5));
        arrayCartas.add(new Criatura("Gargula", 5.5, "Fogo", 7.5, "Garras de Lava", 6.5));
        arrayCartas.add(new Criatura("Yeti", 6.0, "Gelo", 8.0, "Avalanche", 7.0));
        arrayCartas.add(new Criatura("Anciao da Floresta", 7.0, "Terra", 9.0, "Cura Natural", 8.0));
        arrayCartas.add(new Criatura("Fada da Neve", 5.0, "Gelo", 7.0, "Restauracao de Poder", 6.0));
        arrayCartas.add(new Criatura("Demonio", 6.5, "Fogo", 8.5, "Sombra Veloz", 7.5));
        arrayCartas.add(new Criatura("Dragao da Tempestade", 7.0, "Ar", 9.5, "Raio Destrutivo", 8.5));
        arrayCartas.add(new Criatura("Sombra", 4.5, "Ar", 6.5, "Morte Silenciosa", 5.5));
        arrayCartas.add(new Criatura("Guerreiro", 4.0, "Terra", 6.5, "Lealdade", 5.5));
        arrayCartas.add(new Criatura("Curandeira", 5.0, "Terra", 6.0, "Cura", 5.0));
        arrayCartas.add(new Criatura("Fada Madrinha", 3.5, "Ar", 5.0, "Balde de Mana", 4.5));
        arrayCartas.add(new Criatura("Arqueiro de Gelo", 4.0, "Gelo", 6.0, "Flechas Congelantes", 5.5));
        arrayCartas.add(new Criatura("Ceifador", 5.5, "Ar", 7.5, "Execucao", 6.5));
        arrayCartas.add(new Criatura("Bruxa do Pantano", 4.5, "Terra", 6.5, "Cura Sombria", 5.5));
        arrayCartas.add(new Criatura("Bruxa de Fogo", 5.5, "Fogo", 7.0, "Feitico de Vida", 6.0));

        // Adicionando 10 objetos da classe Feitico.
        arrayCartas.add(new Feitico("Bola de Fogo", 4.0, "Fogo", "muito_dano"));
        arrayCartas.add(new Feitico("Tempestade de Gelo", 5.0, "Gelo", "dano"));
        arrayCartas.add(new Feitico("Tempestade", 6.0, "Ar", "dano"));
        arrayCartas.add(new Feitico("Espinhos Selvagens", 4.5, "Terra", "dano"));
        arrayCartas.add(new Feitico("Furia Vulcanica", 7.0, "Fogo", "muito_dano"));
        arrayCartas.add(new Feitico("Necromancia", 6.5, "Reviver", "REVIVER"));
        arrayCartas.add(new Feitico("Regeneracao Profunda", 5.5, "Vida", "muita_vida"));
        arrayCartas.add(new Feitico("Energizar", 4.0, "Mana", "muita_mana"));
        arrayCartas.add(new Feitico("Raio de Esperanca", 3.5, "Vida", "vida"));
        arrayCartas.add(new Feitico("Toque de Vida", 3.0, "Vida", "vida"));

        // Adicionando 10 objetos da classe Encantamento.
        arrayCartas.add(new Encantamento("Faiscas", 3.0, "Fogo", "dano", 2));
        arrayCartas.add(new Encantamento("Estalagmites", 4.0, "Gelo", "muito_dano", 3));
        arrayCartas.add(new Encantamento("Temporal", 4.5, "Ar", "dano", 4));
        arrayCartas.add(new Encantamento("Terremoto", 5.0, "Terra", "muito_dano", 2));
        arrayCartas.add(new Encantamento("Inferno", 7.0, "Fogo", "muito_dano", 5));
        arrayCartas.add(new Encantamento("Raios", 6.0, "Ar", "dano", 6));
        arrayCartas.add(new Encantamento("Concentracao", 2.5, "Mana", "muita_mana", 1));
        arrayCartas.add(new Encantamento("Agonia", 5.0, "Fogo", "muito_dano", 7));
        arrayCartas.add(new Encantamento("Cura Superior", 4.5, "Vida", "vida", 8));
        arrayCartas.add(new Encantamento("Aura de Protecao", 3.5, "Vida", "vida", 6));

    }

    public ArrayList<Carta> getArrayCartas() {
        return arrayCartas;
    }
}
