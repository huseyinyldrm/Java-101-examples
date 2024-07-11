import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sayi;
        int toplam=0;

        System.out.print("Bir sayi giriniz:");
        sayi= input.nextInt();

        for(int i=1; i<=sayi/2; i++){
            if(sayi%i==0){
                toplam+=i;
            }
        }
        if(sayi==toplam){
            System.out.print(sayi+" sayisi mükemmel sayidir.");
        }
        else{
            System.out.print(sayi+" sayisi mukemmel sayi degildir.");
        }

    }
}