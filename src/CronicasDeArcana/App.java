package CronicasDeArcana;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		//criar os objetos das cartas:
		List<Carta> arrayCartas = new ArrayList<>();

		// Criando 20 objetos da classe Criatura
        arrayCartas.add(new Criatura("Soldado Alienígena", 5, 8.5, "Tiro de Plasma", 7.0, "Alienígena"));
        arrayCartas.add(new Criatura("Criatura de Areia", 3, 6.0, "Tempestade de Areia", 5.0, "Terreno"));
        arrayCartas.add(new Criatura("Mutante Selvagem", 4, 7.5, "Regeneração", 6.0, "Biológico"));
        arrayCartas.add(new Criatura("Sentinela de Titânio", 6, 9.0, "Barreira Metálica", 8.0, "Tecnológico"));
        arrayCartas.add(new Criatura("Parasita de Plasma", 3, 5.0, "Dreno de Energia", 4.5, "Energético"));
        arrayCartas.add(new Criatura("Guardião de Rocha", 4, 7.0, "Escudo de Terra", 6.0, "Terreno"));
        arrayCartas.add(new Criatura("Androide de Combate", 5, 8.0, "Golpe de Laser", 7.0, "Tecnológico"));
        arrayCartas.add(new Criatura("Fera Biomecânica", 6, 9.0, "Fusão Cibernética", 8.5, "Biológico"));
        arrayCartas.add(new Criatura("Espião Alienígena", 2, 4.5, "Invisibilidade", 3.0, "Alienígena"));
        arrayCartas.add(new Criatura("Dragão de Plasma", 7, 10.0, "Sopro de Fogo Estelar", 9.0, "Energético"));
        arrayCartas.add(new Criatura("Troll das Cavernas", 3, 6.5, "Regeneração", 5.5, "Terreno"));
        arrayCartas.add(new Criatura("Soldado Cibernético", 4, 7.0, "Ataque com Canhão", 6.5, "Tecnológico"));
        arrayCartas.add(new Criatura("Enguia Elétrica", 4, 7.5, "Choque Elétrico", 6.0, "Energético"));
        arrayCartas.add(new Criatura("Colosso de Metal", 8, 12.0, "Pancada de Aço", 10.0, "Tecnológico"));
        arrayCartas.add(new Criatura("Mutante Alienígena", 6, 9.0, "Transformação", 8.0, "Biológico"));
        arrayCartas.add(new Criatura("Golem de Cristal", 5, 8.5, "Rajada de Cristais", 7.5, "Terreno"));
        arrayCartas.add(new Criatura("Serpente de Plasma", 6, 9.0, "Envenenamento Energético", 8.5, "Energético"));
        arrayCartas.add(new Criatura("Fera Espacial", 7, 10.0, "Garras Cósmicas", 9.5, "Alienígena"));
        arrayCartas.add(new Criatura("Bestial da Selva", 5, 8.0, "Investida Selvagem", 7.0, "Biológico"));
        arrayCartas.add(new Criatura("Androide Psiônico", 6, 9.5, "Controle Mental", 8.5, "Tecnológico"));

        // Criando 20 objetos da classe Feitiço
        arrayCartas.add(new Feitico("Explosão de Plasma", 4, "Causa dano de energia em área", "Energético"));
        arrayCartas.add(new Feitico("Terremoto", 5, "Destrói todas as criaturas de terreno", "Terreno"));
        arrayCartas.add(new Feitico("Controle Mental", 6, "Controla a criatura inimiga por um turno", "Alienígena"));
        arrayCartas.add(new Feitico("Pulso Eletromagnético", 3, "Desativa cartas tecnológicas por um turno", "Tecnológico"));
        arrayCartas.add(new Feitico("Cura Biológica", 3, "Restaura pontos de vida", "Biológico"));
        arrayCartas.add(new Feitico("Raio de Plasma", 2, "Causa dano direto a uma criatura", "Energético"));
        arrayCartas.add(new Feitico("Explosão Sônica", 4, "Atordoa todas as criaturas do campo", "Alienígena"));
        arrayCartas.add(new Feitico("Erupção Vulcânica", 6, "Causa dano em área massivo", "Terreno"));
        arrayCartas.add(new Feitico("Regeneração Avançada", 5, "Cura completa uma criatura", "Biológico"));
        arrayCartas.add(new Feitico("Tempestade de Areia", 4, "Reduz o ataque de todas as criaturas", "Terreno"));
        arrayCartas.add(new Feitico("Escudo de Plasma", 3, "Aumenta a defesa de uma criatura", "Energético"));
        arrayCartas.add(new Feitico("Campo de Força Tecnológico", 5, "Bloqueia ataques por um turno", "Tecnológico"));
        arrayCartas.add(new Feitico("Chuva de Meteoros", 7, "Causa dano massivo em área", "Terreno"));
        arrayCartas.add(new Feitico("Transfusão de Vida", 4, "Troca pontos de vida com o oponente", "Biológico"));
        arrayCartas.add(new Feitico("Ataque Psíquico", 3, "Causa dano mental ao inimigo", "Alienígena"));
        arrayCartas.add(new Feitico("Raio Congelante", 2, "Imobiliza uma criatura por um turno", "Energético"));
        arrayCartas.add(new Feitico("Chuva Ácida", 5, "Dissolve cartas tecnológicas", "Terreno"));
        arrayCartas.add(new Feitico("Nevoeiro Biológico", 3, "Reduz a visibilidade das criaturas", "Biológico"));
        arrayCartas.add(new Feitico("Paralisia Neural", 6, "Atordoa o oponente por um turno", "Alienígena"));
        arrayCartas.add(new Feitico("Tsunami", 6, "Destrói todas as criaturas no campo", "Terreno"));

        // Criando 20 objetos da classe Encantamento
        arrayCartas.add(new Encantamento("Escudo Alienígena", 3, "Reduz o dano recebido por 50%", "Alienígena"));
        arrayCartas.add(new Encantamento("Campo de Energia", 5, "Aumenta o ataque de criaturas energéticas", "Energético"));
        arrayCartas.add(new Encantamento("Força da Natureza", 4, "Aumenta o poder de criaturas de terreno", "Terreno"));
        arrayCartas.add(new Encantamento("Barreira Cibernética", 4, "Aumenta a defesa de criaturas tecnológicas", "Tecnológico"));
        arrayCartas.add(new Encantamento("Regeneração Natural", 3, "Restaura vida das criaturas biológicas", "Biológico"));
        arrayCartas.add(new Encantamento("Campo de Força de Plasma", 5, "Cria uma barreira de plasma", "Energético"));
        arrayCartas.add(new Encantamento("Armadura de Pedra", 3, "Aumenta a resistência de criaturas de terreno", "Terreno"));
        arrayCartas.add(new Encantamento("Conexão Neural", 4, "Permite controle de outra criatura", "Alienígena"));
        arrayCartas.add(new Encantamento("Campo de Gravitons", 6, "Reduz a velocidade de criaturas adversárias", "Tecnológico"));
        arrayCartas.add(new Encantamento("Aura Bioluminescente", 2, "Aumenta a visibilidade de criaturas biológicas", "Biológico"));
        arrayCartas.add(new Encantamento("Sobrecarga de Energia", 3, "Aumenta o dano de feitiços energéticos", "Energético"));
        arrayCartas.add(new Encantamento("Escudo de Nanites", 5, "Cria uma defesa regenerativa", "Tecnológico"));
        arrayCartas.add(new Encantamento("Bênção da Terra", 4, "Aumenta a regeneração de criaturas de terreno", "Terreno"));
        arrayCartas.add(new Encantamento("Campo Psiônico", 6, "Aumenta o poder de cartas alienígenas", "Alienígena"));

		
	}


} 	
