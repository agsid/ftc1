import java.util.Scanner;
import java.util.ArrayList;

public class ball_sorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ball1 : ");
        String ball1 = scanner.nextLine();

        System.out.print("Ball2 : ");
        String ball2 = scanner.nextLine();

        System.out.print("Ball3 : ");
        String ball3 = scanner.nextLine();

        System.out.print("Sequence: ");
        String sequence = scanner.nextLine();

        scanner.close();

        String green_ball = "None";
        ArrayList<String> purple = new ArrayList<String>();
        ArrayList<String> shoot = new ArrayList<String>();

        // which ball = green
        if (ball1.equals("Green")) {
            green_ball = "ball1";
            purple.add("ball2");
            purple.add("ball3");
        } 
        else if (ball2.equals("Green")) {
            green_ball = "ball2";
            purple.add("ball1");
            purple.add("ball3");
        } 
        else if (ball3.equals("Green")) {
            green_ball = "ball3";
            purple.add("ball1");
            purple.add("ball2");
        } 
        else {
            green_ball = "None";
            purple.add("ball1");
            purple.add("ball2");
            purple.add("ball3");
        }

        //  SEQUENCE LOGIC (PGP,GPP,PPG)
        if (sequence.equals("GPP")) {
            shoot.add(green_ball);
            shoot.add(purple.get(0));
            shoot.add(purple.get(1));
        } 
        else if (sequence.equals("PGP")) {
            shoot.add(purple.get(0));
            shoot.add(green_ball);
            shoot.add(purple.get(1));
        } 
        else if (sequence.equals("PPG")) {
            shoot.add(purple.get(0));
            shoot.add(purple.get(1));
            shoot.add(green_ball);
        } 
        else {
            System.out.println("Invalid sequence!");
        }
      
        System.out.println("Green Ball: " + green_ball);
        System.out.println("Purple Balls: " + purple);
        System.out.println("Shoot Order: " + shoot);
        
        if(gamepad2.x=1){
            System.out.println(green_ball);
        }
        if(gamepad2.a=1){
            System.out.println(shoot);
        }
        if(gamepad2.b=1){
            System.out.println(purple);
        }
    }
}
