// package CronicasDeArcana;

// import java.util.ArrayList;
// import java.util.List;

// public class App {
// 	public static void main(String[] args) {
// 		//criar os objetos das cartas:
// 		List<Carta> arrayCartas = new ArrayList<>();
		

// 		// Criando 20 objetos da classe Criatura
// arrayCartas.add(new Criatura("Soldado Alienígena", 5, "Alienígena", 8.5, "Tiro de Plasma", 7.0));
// arrayCartas.add(new Criatura("Criatura de Areia", 3, "Terreno", 6.0, "Tempestade de Areia", 5.0));
// arrayCartas.add(new Criatura("Mutante Selvagem", 4, "Biológico", 7.5, "Regeneração", 6.0));
// arrayCartas.add(new Criatura("Sentinela de Titânio", 6, "Tecnológico", 9.0, "Barreira Metálica", 8.0));
// arrayCartas.add(new Criatura("Parasita de Plasma", 3, "Energético", 5.0, "Dreno de Energia", 4.5));
// arrayCartas.add(new Criatura("Guardião de Rocha", 4, "Terreno", 7.0, "Escudo de Terra", 6.0));
// arrayCartas.add(new Criatura("Androide de Combate", 5, "Tecnológico", 8.0, "Golpe de Laser", 7.0));
// arrayCartas.add(new Criatura("Fera Biomecânica", 6, "Biológico", 9.0, "Fusão Cibernética", 8.5));
// arrayCartas.add(new Criatura("Espião Alienígena", 2, "Alienígena", 4.5, "Invisibilidade", 3.0));
// arrayCartas.add(new Criatura("Dragão de Plasma", 7, "Energético", 10.0, "Sopro de Fogo Estelar", 9.0));
// arrayCartas.add(new Criatura("Troll das Cavernas", 3, "Terreno", 6.5, "Regeneração", 5.5));
// arrayCartas.add(new Criatura("Soldado Cibernético", 4, "Tecnológico", 7.0, "Ataque com Canhão", 6.5));
// arrayCartas.add(new Criatura("Enguia Elétrica", 4, "Energético", 7.5, "Choque Elétrico", 6.0));
// arrayCartas.add(new Criatura("Colosso de Metal", 8, "Tecnológico", 12.0, "Pancada de Aço", 10.0));
// arrayCartas.add(new Criatura("Mutante Alienígena", 6, "Biológico", 9.0, "Transformação", 8.0));
// arrayCartas.add(new Criatura("Golem de Cristal", 5, "Terreno", 8.5, "Rajada de Cristais", 7.5));
// arrayCartas.add(new Criatura("Serpente de Plasma", 6, "Energético", 9.0, "Envenenamento Energético", 8.5));
// arrayCartas.add(new Criatura("Fera Espacial", 7, "Alienígena", 10.0, "Garras Cósmicas", 9.5));
// arrayCartas.add(new Criatura("Bestial da Selva", 5, "Biológico", 8.0, "Investida Selvagem", 7.0));
// arrayCartas.add(new Criatura("Androide Psiônico", 6, "Tecnológico", 9.5, "Controle Mental", 8.5));

// // Criando 20 objetos da classe Feitiço
// arrayCartas.add(new Feitico("Explosão de Plasma", 4, "Energético", "Causa dano de energia em área"));
// arrayCartas.add(new Feitico("Terremoto", 5, "Terreno", "Destrói todas as criaturas de terreno"));
// arrayCartas.add(new Feitico("Controle Mental", 6, "Alienígena", "Controla a criatura inimiga por um turno"));
// arrayCartas.add(new Feitico("Pulso Eletromagnético", 3, "Tecnológico", "Desativa cartas tecnológicas por um turno"));
// arrayCartas.add(new Feitico("Cura Biológica", 3, "Biológico", "Restaura pontos de vida"));
// arrayCartas.add(new Feitico("Raio de Plasma", 2, "Energético", "Causa dano direto a uma criatura"));
// arrayCartas.add(new Feitico("Explosão Sônica", 4, "Alienígena", "Atordoa todas as criaturas do campo"));
// arrayCartas.add(new Feitico("Erupção Vulcânica", 6, "Terreno", "Causa dano em área massivo"));
// arrayCartas.add(new Feitico("Regeneração Avançada", 5, "Biológico", "Cura completa uma criatura"));
// arrayCartas.add(new Feitico("Tempestade de Areia", 4, "Terreno", "Reduz o ataque de todas as criaturas"));
// arrayCartas.add(new Feitico("Escudo de Plasma", 3, "Energético", "Aumenta a defesa de uma criatura"));
// arrayCartas.add(new Feitico("Campo de Força Tecnológico", 5, "Tecnológico", "Bloqueia ataques por um turno"));
// arrayCartas.add(new Feitico("Chuva de Meteoros", 7, "Terreno", "Causa dano massivo em área"));
// arrayCartas.add(new Feitico("Transfusão de Vida", 4, "Biológico", "Troca pontos de vida com o oponente"));
// arrayCartas.add(new Feitico("Ataque Psíquico", 3, "Alienígena", "Causa dano mental ao inimigo"));
// arrayCartas.add(new Feitico("Raio Congelante", 2, "Energético", "Imobiliza uma criatura por um turno"));
// arrayCartas.add(new Feitico("Chuva Ácida", 5, "Terreno", "Dissolve cartas tecnológicas"));
// arrayCartas.add(new Feitico("Nevoeiro Biológico", 3, "Biológico", "Reduz a visibilidade das criaturas"));
// arrayCartas.add(new Feitico("Paralisia Neural", 6, "Alienígena", "Atordoa o oponente por um turno"));
// arrayCartas.add(new Feitico("Tsunami", 6, "Terreno", "Destrói todas as criaturas no campo"));

// // Criando 20 objetos da classe Encantamento
// arrayCartas.add(new Encantamento("Escudo Alienígena", 3, "Alienígena", "Reduz o dano recebido por 50%"));
// arrayCartas.add(new Encantamento("Campo de Energia", 5, "Energético", "Aumenta o ataque de criaturas energéticas"));
// arrayCartas.add(new Encantamento("Força da Natureza", 4, "Terreno", "Aumenta o poder de criaturas de terreno"));
// arrayCartas.add(new Encantamento("Barreira Cibernética", 4, "Tecnológico", "Aumenta a defesa de criaturas tecnológicas"));
// arrayCartas.add(new Encantamento("Regeneração Natural", 3, "Biológico", "Restaura vida das criaturas biológicas"));
// arrayCartas.add(new Encantamento("Campo de Força de Plasma", 5, "Energético", "Cria uma barreira de plasma"));
// arrayCartas.add(new Encantamento("Armadura de Pedra", 3, "Terreno", "Aumenta a resistência de criaturas de terreno"));
// arrayCartas.add(new Encantamento("Conexão Neural", 4, "Alienígena", "Permite controle de outra criatura"));
// arrayCartas.add(new Encantamento("Campo de Gravitons", 6, "Tecnológico", "Reduz a velocidade de criaturas adversárias"));
// arrayCartas.add(new Encantamento("Aura Bioluminescente", 2, "Biológico", "Aumenta a visibilidade de criaturas biológicas"));
// arrayCartas.add(new Encantamento("Sobrecarga de Energia", 3, "Energético", "Aumenta o dano de feitiços energéticos"));
// arrayCartas.add(new Encantamento("Escudo de Nanites", 5, "Tecnológico", "Cria uma defesa regenerativa"));
// arrayCartas.add(new Encantamento("Bênção da Terra", 4, "Terreno", "Aumenta a regeneração de criaturas de terreno"));
// arrayCartas.add(new Encantamento("Campo Psiônico", 6, "Alienígena", "Aumenta o poder de cartas alienígenas"));



// } 	
