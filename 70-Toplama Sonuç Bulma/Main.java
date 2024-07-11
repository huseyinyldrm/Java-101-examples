import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int digit1=(int)(Math.random()*10);
        int digit2=(int)(Math.random()*10);
        int digit3=(int)(Math.random()*10);

        System.out.print("What is "+digit1+" + "+digit2+" + "+digit3+" =? ");

        int answer=input.nextInt();

        System.out.println(digit1+" + "+digit2+" + "+digit3+" = "+answer+" is "
        +(digit1+digit2+digit3==answer));

    }
}