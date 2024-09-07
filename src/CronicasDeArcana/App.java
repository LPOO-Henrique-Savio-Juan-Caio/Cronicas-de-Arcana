package CronicasDeArcana;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		//criar os objetos das cartas:
		List<Carta> arrayCartas = new ArrayList<>();

		//criando 10 objetos da classe criatura
		arrayCartas.add(new Criatura("Dragão de Fogo", 5, 8.5, "Sopro Flamejante", 7.0));
        arrayCartas.add(new Criatura("Guerreiro Orc", 3, 6.0, "Investida", 5.0));
        arrayCartas.add(new Criatura("Elfa Arqueira", 2, 4.5, "Tiro Preciso", 3.0));
        arrayCartas.add(new Criatura("Gigante de Pedra", 6, 9.0, "Pancada de Rocha", 8.0));
        arrayCartas.add(new Criatura("Serpente Marinha", 4, 7.0, "Ataque Aquático", 6.5));
        arrayCartas.add(new Criatura("Fênix", 7, 9.5, "Ressurgir das Cinzas", 7.5));
        arrayCartas.add(new Criatura("Dragão Elétrico", 6, 8.0, "Raio de Trovão", 6.5));
        arrayCartas.add(new Criatura("Troll da Montanha", 4, 7.5, "Regeneração", 7.0));
        arrayCartas.add(new Criatura("Vampiro Sombrio", 5, 6.5, "Sugação de Vida", 5.5));
        arrayCartas.add(new Criatura("Lobo Alpha", 3, 5.5, "Uivo Aterrorizante", 4.0));

        // Criando 10 objetos da classe Feitiço
        arrayCartas.add(new Feitico("Bola de Fogo", 4, "Causa dano em área"));
        arrayCartas.add(new Feitico("Relâmpago", 3, "Causa dano a um alvo único"));
        arrayCartas.add(new Feitico("Cura", 2, "Restaura pontos de vida"));
        arrayCartas.add(new Feitico("Paralisia", 3, "Imobiliza o alvo por um turno"));
        arrayCartas.add(new Feitico("Escudo Mágico", 2, "Aumenta a defesa temporariamente"));
        arrayCartas.add(new Feitico("Invisibilidade", 4, "Torna o usuário invisível por dois turnos"));
        arrayCartas.add(new Feitico("Teleporte", 3, "Move o usuário para outro local"));
        arrayCartas.add(new Feitico("Explosão de Gelo", 5, "Causa dano de gelo em área"));
        arrayCartas.add(new Feitico("Invocação de Espíritos", 6, "Invoca criaturas auxiliares"));
        arrayCartas.add(new Feitico("Controle Mental", 7, "Controla a mente do adversário por um turno"));

        // Criando 10 objetos da classe Encantamento
        arrayCartas.add(new Encantamento("Aura de Fogo", 3, "Aumenta o poder de ataque em 20%"));
        arrayCartas.add(new Encantamento("Proteção Divina", 5, "Reduz o dano recebido em 30%"));
        arrayCartas.add(new Encantamento("Maldição Sombria", 4, "Diminui a resistência do inimigo"));
        arrayCartas.add(new Encantamento("Canto da Sereia", 2, "Atrai o inimigo e reduz sua defesa"));
        arrayCartas.add(new Encantamento("Força do Trovão", 3, "Aumenta o poder dos feitiços elétricos"));
        arrayCartas.add(new Encantamento("Chama Eterna", 5, "Concede regeneração de vida constante"));
        arrayCartas.add(new Encantamento("Escudo de Pedra", 4, "Aumenta a defesa física"));
        arrayCartas.add(new Encantamento("Aura Venenosa", 3, "Inflige veneno aos inimigos próximos"));
        arrayCartas.add(new Encantamento("Olho de Águia", 2, "Melhora a precisão de ataques à distância"));
        arrayCartas.add(new Encantamento("Fúria da Tempestade", 6, "Aumenta o dano de habilidades relacionadas ao vento e relâmpago"));

		//o jogador selecionaram 30 cartas, e essas 30 cartas seram preenchidas em um array:

		String[] nomesCartas = {
            "Dragão de Fogo", "Guerreiro Orc", "Elfa Arqueira", "Gigante de Pedra", "Serpente Marinha",
            "Fênix", "Dragão Elétrico", "Troll da Montanha", "Vampiro Sombrio", "Lobo Alpha",
            "Bola de Fogo", "Relâmpago", "Cura", "Paralisia", "Escudo Mágico",
            "Invisibilidade", "Teleporte", "Explosão de Gelo", "Invocação de Espíritos", "Controle Mental",
            "Aura de Fogo", "Proteção Divina", "Maldição Sombria", "Canto da Sereia", "Força do Trovão",
            "Chama Eterna", "Escudo de Pedra", "Aura Venenosa", "Olho de Águia", "Fúria da Tempestade"
        };


		


		Deck deck = new Deck(nomesCartas,arrayCartas);

		System.out.println(deck);



	}


} 	
