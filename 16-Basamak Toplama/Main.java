import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayi;
        int toplam=0;
        System.out.print("Bir sayi giriniz:");
        sayi= input.nextInt();

        while (sayi!=0){
            toplam+=sayi%10;//sayının birler basamağını toplam değişkenine ekle
            sayi/=10;//sayıların birler basamağını atla
        }
        System.out.println("Sayinin basamaklari toplami: " + toplam);
    }
}