import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        double temperature;

        System.out.print("Hava sicakligini giriniz:");
        temperature= input.nextDouble();

        if(temperature<5){
            System.out.print("Yapilacak etkinlik:Kayak");
        }
        else if (temperature>=5 && temperature<15) {
            System.out.print("Yapilacak etkinlik:Sinema");
        }
        else if (temperature>=15 && temperature<25) {
            System.out.print("Yapilacak etkinlik:Piknik");
        }
        else if (temperature>=25 && temperature<=40) {
            System.out.print("Yapilacak etkinlik:Yuzme");
        }
        else {
            System.out.print("Hava sicakligi cok yuksek!\n" +
                    "Sagliginiz icin disari fazla cikmakyin.");
        }


    }
}