public class Main {


    public static void main(String[] args) {


        Kia kia = new Kia();
        Skoda skoda = new Skoda();
        Ferrari ferrari = new Ferrari();

        GameController Controller = new GameController(kia, skoda, ferrari);



        Controller.playGame();








    }
}


