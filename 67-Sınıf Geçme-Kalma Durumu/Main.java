import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        float mat,fizik,turkce,kimya,muzik,biyoloji,ort;

        System.out.print("Matematik notunuzu giriniz:");
        mat=input.nextFloat();
        System.out.print("Fizik notunuzu giriniz:");
        fizik=input.nextFloat();
        System.out.print("Turkce notunuzu giriniz:");
        turkce=input.nextFloat();
        System.out.print("Kimya notunuzu giriniz:");
        kimya=input.nextFloat();
        System.out.print("Biyoloji notunuzu giriniz:");
        biyoloji=input.nextFloat();
        System.out.print("Muzik notunuzu giriniz:");
        muzik=input.nextFloat();

        ort=(mat+fizik+muzik+turkce+kimya+biyoloji)/6;

        if(ort<60){
            System.out.print("Sinifta kaldiniz.Ortalamaniz:"+ort);
        }
        else if(ort>=60 && ort<=100){
            System.out.print("Gectiniz.Ortalamaniz:"+ort);
        }
        else{
            System.out.print("Ortalama 0-100 arasinda olmalidir.\n" +
                    "Lutfen girdiğiniz degerleri kontrol ediniz.");
        }






    }
}