import java.util.Scanner;

public class Main {
    static void  desen(int number) {
        System.out.print(number+" ");
        if(number<=0){
            return;
        }
        desen(number-5);
        System.out.print(number+" ");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayi giriniz:");
        int sayi = input.nextInt();
        System.out.print("Sonuc:");
        desen(sayi);



    }
}