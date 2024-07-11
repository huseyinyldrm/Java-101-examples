import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double r;
        double pi= 3.14;

        System.out.print("Dairenin yaricapini giriniz:");
        r= input.nextDouble();

        double alan= pi*r*r;
        double cevre= 2*pi*r;

        System.out.println("Dairenin alani:"+alan);
        System.out.println("Dairenin cevresi:"+cevre);

    }
}