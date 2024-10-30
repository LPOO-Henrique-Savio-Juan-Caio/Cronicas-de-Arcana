package main;

public class Teste{
    public static void main(String[] args) {
        Progressao progressao = new Progressao();
        progressao.addJogador("Juan");
        progressao.addVitoria("Juan");
        progressao.addVitoria("Juan");
        //add jogador so funciona se o jogador n existir ainda na lista
        progressao.addJogador("Juan");
        progressao.addVitoria("Juan");
        System.out.println(progressao.getVitoriaJogador("Juan"));
    }
}
