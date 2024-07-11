import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int yas, km;
        int yolculukTipi;
        double mesafeBasi = 0.10;
        double normalTutar, yasIndirimi, gidisDonusIndirimi = 0, toplamTutar = 0, indirimli;


        System.out.print("Lutfen yasinizi giriniz:");
        yas = input.nextInt();

        System.out.print("Lutfen mesafeyi KM cinsinden giriniz:");
        km = input.nextInt();

        System.out.println("Yolculuk tipini giriniz:\n1-Tek Yon\n2-Gidis-Donuş");
        yolculukTipi = input.nextInt();


        if (yas < 0 && km < 0) {
            System.out.print("Yas degerinin ve km degerinin 0'dan buyuk olmasina dikkat edin.");
        }

        if (yas >= 0 && yas < 12) {
            if (yolculukTipi == 2) {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.50;
                indirimli = normalTutar - yasIndirimi;
                gidisDonusIndirimi = indirimli * 0.20;
                toplamTutar = (indirimli - gidisDonusIndirimi) * 2;
            } else {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.50;
                indirimli = normalTutar - yasIndirimi;
                toplamTutar = (indirimli - gidisDonusIndirimi);
            }
        } else if (yas >= 12 && yas <= 24) {
            if (yolculukTipi == 2) {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.10;
                indirimli = normalTutar - yasIndirimi;
                gidisDonusIndirimi = indirimli * 0.20;
                toplamTutar = (indirimli - gidisDonusIndirimi) * 2;

            } else {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.10;
                indirimli = normalTutar - yasIndirimi;
                toplamTutar = (indirimli - gidisDonusIndirimi);

            }
        } else if (yas >= 25 && yas <= 64) {
            if (yolculukTipi == 2) {
                normalTutar = km * mesafeBasi;
                gidisDonusIndirimi = normalTutar * 0.20;
                toplamTutar = (normalTutar - gidisDonusIndirimi) * 2;

            } else {
                normalTutar = km * mesafeBasi;
                toplamTutar = normalTutar;

            }


        } else if (yas >= 65) {
            if (yolculukTipi == 2) {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.30;
                indirimli = normalTutar - yasIndirimi;
                gidisDonusIndirimi = indirimli * 0.20;
                toplamTutar = (indirimli - gidisDonusIndirimi) * 2;

            } else {
                normalTutar = km * mesafeBasi;
                yasIndirimi = normalTutar * 0.30;
                indirimli = normalTutar - yasIndirimi;
                toplamTutar = (indirimli - gidisDonusIndirimi);

            }
        }
        System.out.println("toplam bilet fiyatiniz:" + toplamTutar);


    }
}