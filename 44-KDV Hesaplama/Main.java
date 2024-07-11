import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        double kdv1=0.18;
        double kdv2=0.08;
        double miktar;
        double tutar;
        double sonMiktar;

        System.out.print("Para miktarini giriniz:");
        miktar= input.nextDouble();

        if(miktar>=0 && miktar<=1000){
            tutar=miktar*kdv1;
            sonMiktar=miktar+tutar;
            System.out.println("Girilen paranin KDV Orani:"+tutar);
            System.out.print("Girilen paranin KDV'li Orani:"+sonMiktar);
        }
        else{
            tutar=miktar*kdv2;
            sonMiktar=miktar+tutar;
            System.out.println("Girilen paranin KDV Orani:"+tutar);
            System.out.print("Girilen paranin KDV'li Orani:"+sonMiktar);
        }


    }
}