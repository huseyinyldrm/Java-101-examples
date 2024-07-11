import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int acilisUcreti=10;
        double kmBasi=2.20;
        double km;
        double odenecekTutar;

        System.out.print("KM miktarini giriniz:");
        km=input.nextDouble();

        odenecekTutar=(km*kmBasi);
        odenecekTutar+=acilisUcreti;

         // Eger hesaplanan ucret 20'den az ise, odenecek tutari 20 olarak belirliyoruz.
        odenecekTutar=(odenecekTutar<20) ? 20 :odenecekTutar;
        System.out.println("Toplam Ucret:"+odenecekTutar);

        // km girerken ekrana virgül kullan nokta değil.



    }
}