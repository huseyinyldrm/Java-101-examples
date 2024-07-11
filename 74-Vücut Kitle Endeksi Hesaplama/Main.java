import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double kg,boy;
        double endex;
        System.out.println("*************************************");
        System.out.println("VKİ Hesaplama Programina Hoşgeldiniz");
        System.out.println("************************************");

        System.out.print("Lutfen kilonuzu giriniz:");
        kg= input.nextDouble();

        System.out.print("Lutfen boyunuzu metre cinsinden giriniz:");
        boy=input.nextDouble();

        endex=(kg)/(boy*boy);
        if(endex<18.5){
            System.out.println("Çok zayıfsınız.VKİ değeriniz:"+endex);
        }
        else if (endex>=18.5 && endex<=24.9) {
            System.out.println("Normal kilodasınız.VKİ değeriniz:"+endex);

        }
        else if (endex>=25 && endex<=29.9) {
            System.out.println("Fazla kilolusunuz.VKİ değeriniz:"+endex);
        }
        else if (endex>=30 && endex<=34.9) {
            System.out.println("1.derece obezsiniz.VKİ değeriniz:"+endex);
        }
        else if (endex>=35 && endex<=39.9) {
            System.out.println("2.derece obezsiniz.VKİ değeriniz:"+endex);
        }
        else {
            System.out.println("3.derece obezsiniz.VKİ değeriniz:"+endex);
        }


    }
}