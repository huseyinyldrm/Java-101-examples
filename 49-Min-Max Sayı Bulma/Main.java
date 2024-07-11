import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayiAdedi;
        int sayi;

        System.out.print("Sayı adedini giriniz:");
        sayiAdedi=input.nextInt();

        // İlk değerleri kullanıcıdan alınan sayıya eşitleyelim
        System.out.print("1.sayiyi giriniz:");
        sayi= input.nextInt();

        int max=sayi;
        int min=sayi;

        for (int i=2; i<=sayiAdedi; i++){
            System.out.print(i+".sayiyi giriniz:");
            sayi= input.nextInt();
            if(sayi>max){
                max=sayi;
            }
            if(sayi<min){
                min=sayi;
            }
        }
        //sonuçları ekrana bastıralım
        System.out.println("En buyuk sayi:"+max);
        System.out.println("En kucuk sayi:"+min);

        // Scanner'ı kapatmayı unutmayın
        input.close();

    }
}