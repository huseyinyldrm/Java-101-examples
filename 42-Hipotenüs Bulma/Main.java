import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double kenar1,kenar2,kenar3;
        double cevre,alan,hipotenus,ort;
        int secim;

        System.out.print("Ucgenin 1. dik kenari:");
        kenar1= input.nextDouble();

        System.out.print("Ucgenin 2. dik kenari:");
        kenar2= input.nextDouble();

        System.out.print("Ucgenin 3. kenari:");
        kenar3= input.nextDouble();

        ort=(kenar1+kenar2+kenar3)/2;

        cevre=2*ort;
        System.out.println("Ucgenin cevresi:"+cevre);

        alan=Math.sqrt(ort*(ort-kenar1)*(ort-kenar2)*(ort-kenar3));
        System.out.println("Ucgenin alani:"+alan);

        System.out.println("Hipotenus hesaplamak ister misiniz:");
        System.out.println("1-Evet        2-Hayir");
        secim=input.nextInt();

        if(secim==1){

            System.out.print("Ucgenin 1. dik kenari:");
            kenar1= input.nextDouble();

            System.out.print("Ucgenin 2. dik kenari:");
            kenar2= input.nextDouble();

            hipotenus=Math.sqrt((kenar1*kenar1)+(kenar2*kenar2));

            System.out.println("Ucgenin hipotenusu:"+hipotenus);
        }
        else{
            System.out.println("Cikis yapiliyor.");
        }










    }

}