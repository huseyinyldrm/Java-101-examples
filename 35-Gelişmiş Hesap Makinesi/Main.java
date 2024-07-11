import  java.util.Scanner;
public class Main {
    static void sum() {
        Scanner input=new Scanner(System.in);
        System.out.print("1.sayi:");
        int a= input.nextInt();
        System.out.print("2.sayi:");
        int b= input.nextInt();

        int result = a + b;
        System.out.print("Toplam:" + result);
    }

    static void minus() {
        Scanner input=new Scanner(System.in);
        System.out.print("1.sayi:");
        int a=input.nextInt();
        System.out.print("2.sayi:");
        int b= input.nextInt();

        int result = a - b;
        System.out.print("Fark:" + result);
    }

    static void times() {
        Scanner input=new Scanner(System.in);
        System.out.print("1.sayi:");
        int a=input.nextInt();
        System.out.print("2.sayi:");
        int b=input.nextInt();

        int result = a * b;
        System.out.print("Carpim:" + result);
    }

    static void divided() {
        Scanner input=new Scanner(System.in);
        System.out.print("Bolunecek sayi:");
        int a=input.nextInt();
        System.out.print("Bolen sayi:");
        int b=input.nextInt();
        double result = (double) a / b;
        System.out.print("Bolum:" + result);
        if (b == 0) {
            System.out.print("0'a bolunme hatasi.");
        }
    }

    static void us() {
        Scanner input = new Scanner(System.in);
        System.out.print("Taban degeri:");
        int a = input.nextInt();
        System.out.print("Us degeri:");
        int b = input.nextInt();

        double result = Math.pow(a, b);
        System.out.print(a + " sayisinin " + b + ". mertebeden us degeri:" + result);
    }
    static void karekok(){
        Scanner input=new Scanner(System.in);
        System.out.print("Karekoku hesaplanacak sayiyi giriniz:");
        double sayi= input.nextDouble();

        System.out.print("Karekok degeri:"+Math.sqrt(sayi));
    }

    static void mod() {
        Scanner input=new Scanner(System.in);
        System.out.print("1.sayi:");
        int a=input.nextInt();
        System.out.print("2.sayi:");
        int b=input.nextInt();
        int result = a % b;
        System.out.print(a + " sayisinin" + b + " sayisine bolumunden kalan:" + result);
    }

    static void factorial() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Sonuç : " + result);
    }

    static void dikAlanCevre() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kisa kenar:");
        int kisa = input.nextInt();
        System.out.print("Uzun kenar:");
        int uzun = input.nextInt();

        double alan = (kisa * uzun);
        double cevre = (2 * (kisa + uzun));

        System.out.println("Dikdortgen alani:"+alan);
        System.out.println("Dikdortgen cevresi:"+cevre);
    }
    static void daireHesabi(){
        Scanner input=new Scanner(System.in);
        System.out.print("Dairenin yari capini giriniz:");
        double yariCap=input.nextDouble();

        double alan=(Math.PI*yariCap*yariCap);
        double cevre=(2*Math.PI*yariCap);
        double cap=(yariCap*2);

        System.out.println("Dairenin alani:"+alan);
        System.out.println("Dairenin cevresi:"+cevre);
        System.out.println("Dairenin capi:"+cap);
    }
    static  void trigonometri(){
        Scanner input=new Scanner(System.in);
        System.out.print("aci degerini giriniz:");
        double aci= input.nextDouble();

        System.out.println("Acinin cosinus degeri:"+Math.cos(aci));
        System.out.println("Acinin sinus degeri:"+Math.sin(aci));
        System.out.println("Acinin tanjant degeri:"+Math.tan(aci));
        System.out.println("Acinin cotanjant degeri:"+(Math.cos(aci)/Math.sin(aci)));
    }
    static void logaritma(){
        Scanner input=new Scanner(System.in);
        System.out.print("Hesaplanacak degeri giriniz:");
        double sayi= input.nextDouble();

        System.out.println("Dogal logaritma degeri:"+Math.log(sayi));
        System.out.println("normal logaritma degeri:"+Math.log10(sayi));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



            int select;
            String menu=("""
                    \n1-Toplama Islemi
                    2-Cikarma Islemi
                    3-Carpma Islemi
                    4-Bolme Islemi
                    5-Kalan Bulma Islemi
                    6-Us Bulma Islemi
                    7-Karekok Bulma Islemi
                    8-Logaritmik Islemler
                    9-Trigonometrik Islemler
                    10-Dairesel Islemler
                    11-Dikortgen Islemleri
                    12-Factorial Bulma
                    0-Cikis Islemi
                    """);
        do{
            System.out.println(menu);
            System.out.print("Lutfen bir islem seciniz:");
            select = input.nextInt();
            switch (select) {
                case 1:
                    sum();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    mod();
                    break;
                case 6:
                    us();
                    break;
                case 7:
                    karekok();
                    break;
                case 8:
                    logaritma();
                    break;
                case 9:
                    trigonometri();
                    break;
                case 10:
                    daireHesabi();
                    break;
                case 11:
                    dikAlanCevre();
                    break;
                case 12:
                    factorial();
                    break;
                case 0:
                    System.out.print("Cikis yapiliyor.");
                    break;
                default:
                    System.out.print("Gecerli deger giriniz.");
                    break;
            }
        }while (select!=0);

    }
}