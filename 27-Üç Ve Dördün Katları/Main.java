import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sayi;
        int toplam=0;
        int adet=0;
        double ortalama;
        System.out.print("Bir sayi giriniz:");
        sayi=input.nextInt();
        for(int i=0; i<=sayi; i++){
            if(i%4==0 && i%3==0){
                toplam=toplam+i;
                adet++;
            }
        }

        if(adet>0){
            ortalama=(double) toplam/adet;
            System.out.print("3'e ve 4'e tam bolunen sayilarin ortalamasi:"+ortalama);
        }
        else{
            System.out.print("Girilen aralikta 3'e ve 4'e bolunen sayi bulunmamaktadir.");
        }

    }
}