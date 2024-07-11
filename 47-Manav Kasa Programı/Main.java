import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double armut=45.50;
        double elma=35.50;
        double domates=60.50;
        double muz=40.0;
        double patlican=50.0;
        double salatalik=25.50;
        double tutar,tutar1,tutar2,tutar3,tutar4;
        double tutar5,tutar6;
        double kg;

        System.out.print("Armut kac kilo?:");
        kg= input.nextDouble();
        tutar1=kg*armut;

        System.out.print("Elma kac kilo?:");
        kg= input.nextDouble();
        tutar2=kg*elma;

        System.out.print("Domates kac kilo?:");
        kg= input.nextDouble();
        tutar3=kg*domates;

        System.out.print("Muz kac kilo?:");
        kg= input.nextDouble();
        tutar4=kg*muz;

        System.out.print("Patlıcan kac kilo?:");
        kg= input.nextDouble();
        tutar5=kg*patlican;

        System.out.print("Salatalik kac kilo?:");
        kg= input.nextDouble();
        tutar6=kg*salatalik;

        tutar=tutar1+tutar2+tutar3+tutar4+tutar5+tutar6;

        System.out.println("Toplam tutar:"+tutar);

    }
}