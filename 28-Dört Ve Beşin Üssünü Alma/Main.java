import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayi;
        System.out.print("Sayi sinirini giriniz:");
        sayi= input.nextInt();

        for(int i=1; i<=sayi; i++){

            int kuvvet4=(int) Math.pow(4,i);
            System.out.println("4^" + i + " = " + kuvvet4);
            
            int kuvvet5=(int) Math.pow(5,i);
            System.out.println("5^" + i + " = " + kuvvet5);

            System.out.println("-------------------------");



        }

    }
}