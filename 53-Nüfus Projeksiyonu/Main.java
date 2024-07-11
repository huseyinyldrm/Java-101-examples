import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter the number of years:");
        int years= input.nextInt();

        int population=312032486+(((31536000/7)-(31536000/13)+(31536000/45))*years);

        System.out.print("The population in "+years + " is "+population);

    }
}