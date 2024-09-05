package CronicasDeArcana;

public class Deck {

    private Carta[] cartas = new Carta[30];

    public Deck(Carta[] cartas){

        cartas = new Carta[30];

        //função pra preencher cartas

        for (int i = 0; i < 30; i++) {
            cartas[i] = new Carta("juan", 564654);
        }

        this.cartas = cartas;

    }

    //criar construtor para as 30 cartas, sendo carta uma classe abstrata que tem como classe filha outras 3 classes

    

}
