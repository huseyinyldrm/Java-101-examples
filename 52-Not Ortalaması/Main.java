import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int mat,fizik,kimya,tar,muz,turkce;

        System.out.print("Matematik notunu giriniz:");
        mat= input.nextInt();

        System.out.print("Turkce notunuzu giriniz:");
        turkce=input.nextInt();

        System.out.print("fizik notunu giriniz:");
        fizik= input.nextInt();

        System.out.print("Kimya notunuzu giriniz:");
        kimya= input.nextInt();

        System.out.print("Tarih notunu giriniz:");
        tar=input.nextInt();

        System.out.print("Muzik notunuzu giriniz:");
        muz=input.nextInt();

        int toplam=(mat+turkce+tar+fizik+kimya+muz);
        double ort=toplam/6.0;

        if(ort>=60){
            System.out.println("Gectiniz.Ortalamaniz:"+ort);
        }
        else {
            System.out.print("Kaldiniz.Ortalamaniz:"+ort);
        }

    }
}