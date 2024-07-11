import java.util.Scanner;
public class Main {
    static double us(double a, double b){
        return Math.pow(a,b);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.print("Taban degerini giriniz:");
        double taban= input.nextDouble();

        System.out.print("Us degerini giriniz:");
        double us= input.nextDouble();

        double sonuc=us(taban,us);
        System.out.print("Sonuc:"+sonuc);
    }
}