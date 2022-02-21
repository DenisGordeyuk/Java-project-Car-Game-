
import java.util.Scanner;

public class GameTasks {
    protected int taskCityRun(String action) {
        Scanner scan = new Scanner(System.in);

        switch (action) {
            case "Enter speed":
                System.out.println("[Enter speed] :");
                return scan.nextInt();
            case "Red":
                System.out.println(" [!!!!] : [The [R E D] light came on at the traffic light] -  |*| -- |*| -- [*] ");
                System.out.println("[Your actions] ");
                System.out.println("===============");
                System.out.println("[1] - Go further");  //ехать дальше
                System.out.println("[2] - STOP");
                System.out.println("[Choice] : ");
                return scan.nextInt();
            case "[Green]":
                System.out.println("[Green light on traffic light]");
                System.out.println("[Enter speed]");
                return scan.nextInt();

        }
        return -1;
    }


}


//method taskRun





