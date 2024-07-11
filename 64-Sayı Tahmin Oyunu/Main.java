import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        Random rand=new Random();
        int number=rand.nextInt(100);
        //int number=(int) (Math.random()*100); // 0-100 arasi sayi üretir
        int[] wrong=new int[5];

        int right=0;
        int selected;
        while (right<5){
            System.out.print("Lutfen tahmininizi giriniz:");
            selected= input.nextInt();
            if(selected<0 || selected>100){
                System.out.println("0-100 arasi sayi giriniz.");
                continue;
            }

            if(selected==number){
                System.out.println("Tebrikler dogru bildiniz.");
            }
            else {
                if (selected > number) {
                    System.out.println(selected + " sayisi tahminden buyuktur.");
                } else {
                    System.out.println(selected + " sayisi tahminden kucuktur.");
                }
            }
            System.out.println("Kalan hak:"+(5-right));
            wrong[right++]=selected;

            if(right==5){
                System.out.println("\nHakkiniz bitti.Tekrar deneyiniz.");
                System.out.println("Tahnimleriniz:"+ Arrays.toString(wrong));
            }
        }
    }
}