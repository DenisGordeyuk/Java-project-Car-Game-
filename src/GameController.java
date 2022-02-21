import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.Scanner;

public class GameController {

    private Kia kia;
    private Skoda skoda;
    private Ferrari ferrari;
    private int activeCar;
    Scanner scan = new Scanner(System.in);

    public GameController(Kia kia, Skoda skoda, Ferrari ferrari) {
        this.kia = kia;
        this.skoda = skoda;
        this.ferrari = ferrari;

    }

    protected void playGame() {
        startGame();
        chooseCar();

        GameTasks gameTasks = new GameTasks();

        int speed = gameTasks.taskCityRun("Enter speed");

        if (checkSpeed(speed)) {
            gasToSpeed(speed);
            drive();
            if (checkChoiseRed(gameTasks.taskCityRun("Red"))) {

                speed = gameTasks.taskCityRun("Green");
                if (checkChoiseGreen(speed)) {
                    gasToSpeed(speed);
                    greenTraffic();
                    System.out.println("[Enter speed] :");
                    scan.nextInt();
                    System.out.println("You came back home");
                    System.out.println("==============");
                    stopGame();


                }
            } else {
                policeHarassment();
                brokenCar();
                stopGame();
                startGame();
            }

        }

    }


    private Boolean checkSpeed(int speed) {
        if (this.activeCar == 1) {
            return speed < kia.maxSpeed;
        } else if (this.activeCar == 2) {
            return speed < ferrari.maxSpeed;
        } else if (this.activeCar == 3) {
            return speed < skoda.maxSpeed;
        }
        return true;
    }

    private void gasToSpeed(int speedUp) {
        if (this.activeCar == 1) {
            kia.gas(speedUp);
        } else if (this.activeCar == 2) {
            ferrari.gas(speedUp);
        } else if (this.activeCar == 3) {
            skoda.gas(speedUp);
        }
    }

    private void drive() {
        if (this.activeCar == 1) {
            kia.drive();
        } else if (this.activeCar == 2) {
            ferrari.drive();
        } else if (this.activeCar == 3) {
            skoda.drive();
        }
    }

    private void brake() {
        if (this.activeCar == 1) {
            kia.brake();
        } else if (this.activeCar == 2) {
            ferrari.brake();
        } else if (this.activeCar == 3) ;
        skoda.brake();
    }

    private void stop() {
        if (this.activeCar == 1) {
            kia.stop();
        } else if (this.activeCar == 2) {
            ferrari.stop();
        } else if (this.activeCar == 3) ;
        skoda.stop();
    }

    protected void stopGame() {
        System.out.println("[Game Over] ");
    }

    protected void chooseCar() {
        System.out.print("Car number: ");
        try {
            String number = scan.nextLine();
            if (number.equalsIgnoreCase("1")) {
                this.activeCar = 1;
                System.out.println("You have selected : " + kia.NAME);
            } else if (number.equalsIgnoreCase("2")) {
                this.activeCar = 2;
                System.out.println("You have selected : " + ferrari.NAME);
            } else if (number.equalsIgnoreCase("3")) {
                this.activeCar = 3;
                System.out.println("You have selected : " + skoda.NAME);
            } else {
                System.out.println("You entered an invalid number, please try again");
                chooseCar();
            }
        } catch (Exception ex) {
            System.out.println("You entered an invalid number, please try again");
            chooseCar();
        }

    }

    protected void activeCar() {


    }

    protected void taskCityRun() {

    }

    public void startGame() {
        System.out.println("============================");
        System.out.println("Hello driver,let's play game");
        System.out.println("============================");
        System.out.println("Please choose car: ");
        System.out.println(" [№1] -> [KIA] - Status: " + kia.getStatus());
        System.out.println(" [№2] -> [FERRARI] - Status: " + ferrari.getStatus());
        System.out.println(" [№3] -> [SKODA] - Status: " + skoda.getStatus());
    }

    private boolean checkChoiseRed(int choice) {
        return choice == 2;
    }

    private boolean checkChoiseGreen(int speed) {
        return checkSpeed(speed);
    }


    private void policeHarassment() {
        System.out.println("Police chase after you");
    }

    private void brokenCar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число [1 / 2 ]: ");
        int i = scan.nextInt();
        if (i == 1) {
            System.out.println("You were stopped by the police");

        } else if (i == 2) {
            System.out.println("Your car broke down");
        }
    }

    private void greenTraffic() {
        System.out.println("The green light came on at the traffic light");
    }

}
















