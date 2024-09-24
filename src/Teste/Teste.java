package Teste;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CronicasDeArcana.*;

public class Teste {
    public static void main(String[] args) {
     //lista de cartas
     List<Carta> arrayCartas = new ArrayList<>();


     // Criando 40 objetos da classe Criatura
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


     //para fazermos um teste, vamos definir 2 decks padroes, um para cada jogador
     String[] nomeDeck1 = {
             "Guerreiro Estelar", "Caminhante Lunar", "Serpente de Vênus",
             "Colosso Lunar", "Assassino Galáctico", "Guardião Estelar",
             "Espectro Espacial", "Caçador de Órion", "Titã Intergaláctico",
             "Fera Lunar", "Golem de Granito", "Elemental da Terra",
             "Serpente de Areia", "Troll Montanhoso", "Gigante da Floresta",
             "Guardião das Cavernas", "Monstro de Lava", "Fera Selvagem",
             "Colosso de Rocha", "Guardião de Terra",
             "Androide Blindado", "Sentinela Mecânica", "Escorpião de Metal",
             "Guerreiro Robótico", "Dragão de Aço", "Titã Robótico",
             "Assassino Cibernético", "Guardião Cibernético", "Mutante de Aço",
             "Serpente de Ferro", "Fênix Elétrica", "Serafim das Chamas",
             "Espírito do Trovão", "Titã do Vento", "Guardião das Tempestades",
             "Serpente de Fogo", "Dragão Elétrico", "Espírito das Chamas",
             "Colosso de Chamas", "Guardião do Trovão"
     };


     String[] nomeDeck2 = {
             "Guerreiro Estelar", "Caminhante Lunar", "Serpente de Vênus",
             "Colosso Lunar", "Assassino Galáctico", "Guardião Estelar",
             "Espectro Espacial", "Caçador de Órion", "Titã Intergaláctico",
             "Fera Lunar", "Golem de Granito", "Elemental da Terra",
             "Serpente de Areia", "Troll Montanhoso", "Gigante da Floresta",
             "Guardião das Cavernas", "Monstro de Lava", "Fera Selvagem",
             "Colosso de Rocha", "Guardião de Terra",
             "Androide Blindado", "Sentinela Mecânica", "Escorpião de Metal",
             "Guerreiro Robótico", "Dragão de Aço", "Titã Robótico",
             "Assassino Cibernético", "Guardião Cibernético", "Mutante de Aço",
             "Serpente de Ferro", "Fênix Elétrica", "Serafim das Chamas",
             "Espírito do Trovão", "Titã do Vento", "Guardião das Tempestades",
             "Serpente de Fogo", "Dragão Elétrico", "Espírito das Chamas",
             "Colosso de Chamas", "Guardião do Trovão"
     };


     Jogador jogador1 = new Jogador("juan", 20, 20, arrayCartas, nomeDeck1);
     Jogador jogador2 = new Jogador("henrique", 20, 20, arrayCartas, nomeDeck2);


     Scanner scanner = new Scanner(System.in);
     //loop improvisado do jogo:
     while (true) {
      System.out.println("Essa versao simplificada do jogo acontecera no terminal");
      System.out.println("O jogo funcionara por meio de Round, cada jogador pode colocar uma carta no determinador round");

      double mana1 = jogador1.getMana();
      double mana2 = jogador2.getMana();
      String nomeCarta;
      Carta carta;
      int opcao2;

      int contador = 1;
      //loop das batalhas
      while (true) {
       System.out.println("Round " + contador);
       contador++;

       jogador1.setMana(mana1);
       jogador2.setMana(mana2);
       for (int rodada = 0; rodada < 2; rodada++) {
        if (rodada == 0) {
         System.out.println("Jogador " + jogador1.getNome() + ", escolha a ação:\n\t 1. Jogar carta\n\t 2. Comprar carta\n\t 3. Passar vez\n");
         System.out.println("Mao Jogador1: " + jogador1.imprimirMao());
        } else {
         System.out.println("Jogador " + jogador2.getNome() + ", escolha a ação:\n\t 1. Jogar carta\n\t 2. Comprar carta\n\t 3. Passar vez\n");
         System.out.println("Mao Jogador2: " + jogador2.imprimirMao());
        }

         opcao2 = scanner.nextInt();
         scanner.nextLine();

        switch (opcao2) {
         case 1:
          System.out.println("Digite o nome da carta: ");
          nomeCarta = scanner.nextLine();
          if (rodada == 0) {
           carta = jogador1.selecionarCarta(nomeCarta);
           if(jogador1.getMana() < carta.getCustoMana()){
            System.out.println("Mana insuficiente, perdeu a vez.");
            break;
           }
           System.out.println("Carta selecionada: " + carta.getNome());
           mana1 = mana1 - carta.getCustoMana();
           jogador2.alterarVida(carta);
           jogador1.removerCarta(carta);
           System.out.println("Mana restante: " + mana1);
          } else {
           carta = jogador2.selecionarCarta(nomeCarta);
           if(jogador2.getMana() < carta.getCustoMana()){
            System.out.println("Mana insuficiente, perdeu a vez.");
            break;
           }
           System.out.println("Carta selecionada: " + carta.getNome());
           mana2 = mana2 - carta.getCustoMana();
           jogador1.alterarVida(carta);
           jogador2.removerCarta(carta);
           System.out.println("Mana restante: " + mana2);
          }
          break;

         case 2:
          if (rodada == 0) {
           if(mana1 < 1){
            System.out.println("Mana insuficiente, perdeu a vez.");
            break;
           }
           System.out.println("Digite o nome da carta para comprar: ");
           nomeCarta = scanner.nextLine();
           carta = jogador1.selecionarCarta(arrayCartas, nomeCarta);
           jogador1.adicionarCarta(carta);
           mana1--;
          } else {
           if(mana2 < 1){
            System.out.println("Mana insuficiente, perdeu a vez.");
            break;
           }
           System.out.println("Digite o nome da carta para comprar: ");
           nomeCarta = scanner.nextLine();
           carta = jogador2.selecionarCarta(arrayCartas, nomeCarta);
           jogador2.adicionarCarta(carta);
           mana2--;
          }
          break;
         case 3:
          System.out.println("Pulou a vez...\n");
          break;
         default:
          System.out.println("Opção inválida, perdeu a vez.");
          break;
        }
        if (jogador1.getVida() <= 0 || jogador2.getVida() <= 0) {
         break;
        }

       }
       if (jogador1.getVida() <= 0 || jogador2.getVida() <= 0) {
        break;
       }
       //mana regenera em 2 pontos a cada round
       mana1 = mana1 + 2;
       mana2 = mana2 + 2;
      }

      if(jogador1.getVida() > jogador2.getVida()){
       System.out.println("O vencedor foi o jogador " + jogador1.getNome());
      } else{
       System.out.println("O vencedor foi o jogador " + jogador2.getNome());
      }

      System.out.println("Deseja começar outra batalha?\n\t 1. Sim\n\t 2. Não");
      int opcao1 = scanner.nextInt();
      scanner.nextLine();
      if (opcao1 == 1) {
       jogador1.setVida(20);
       jogador1.setMana(20);

       jogador2.setVida(20);
       jogador2.setMana(20);
      }else if(opcao1 == 2){
       break;
      }
     }
    }
}