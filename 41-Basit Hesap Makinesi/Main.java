import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sayi1,sayi2,select;

        System.out.print("1.sayiyi giriniz:");
        sayi1= input.nextInt();

        System.out.print("2.sayiyi giriniz:");
        sayi2= input.nextInt();

        System.out.println("Yapmak istediginiz islemi seciniz:");
        System.out.println("1-Toplama\n2-Cikarma\n3-Carpma\n4-Bolme\n5-Mod(Kalan) Bulma");
        select= input.nextInt();

        switch (select){
            case 1:
                System.out.print("Toplam:"+(sayi1+sayi2));
                break;
            case 2:
                System.out.print("Fark:"+(sayi1-sayi2));
                break;
            case 3:
                System.out.print("Carpim:"+(sayi1*sayi2));
                break;
            case 4:
                if(sayi2>0){
                    System.out.print("Bolum:"+((float)sayi1/sayi2));
                }
                else{
                    System.out.print("0'a bolum hatasi !!!");
                }
                break;
            case 5:
                System.out.print("Mod degeri:"+(sayi1%sayi2));

        }

    }
}