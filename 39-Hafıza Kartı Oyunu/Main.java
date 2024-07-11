import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // Matrisi ekrana yazdiran metot
    public static void matris_Olustur(int satir, int sutun, char[][] matris) {

        // Matrisin ust kismina sutun numaralarini yazdirma
        System.out.print("    ");
        for (int i = 1; i <= sutun; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        System.out.print("   ");
        for (int colNumber = 0; colNumber < sutun; colNumber++) {
            System.out.print(" _ ");
        }
        System.out.println();

        // Matrisi olusturma ve satir numaralarini ekleyerek ekrana yazdirma
        for (int i = 0; i < satir; i++) {
            System.out.print((i + 1) + " | "); // Satir numarasi
            for (int j = 0; j < sutun; j++) {
                System.out.print(matris[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Gizli matrisi olusturan metot
    public static void gizliMatrisOlustur(int satir, int sutun, char[][] gizliMatris) {
        // Matrisin ust kismina sutun numaralarini yazdirma
        System.out.print("    ");
        for (int i = 1; i <= sutun; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.print("   ");
        for (int colNumber = 0; colNumber < sutun; colNumber++) {
            System.out.print(" _ ");
        }
        System.out.println();

        // Matrisi olusturma ve satir numaralarini ekleyerek ekrana yazdirma
        for (int i = 0; i < satir; i++) {
            System.out.print((i + 1) + " | "); // Satir numarasi
            for (int j = 0; j < sutun; j++) {
                gizliMatris[i][j] = '*';
                System.out.print(gizliMatris[i][j] + "  "); // Gizli hucreleri gosterme
            }
            System.out.println();
        }
    }

    // Matrise sekil veren metot
    public static void matriseSekilVer(int satir, int sutun, char[][] matris) {
        Random rand = new Random();

        // Her bölge için kullanılan karakterlerin listeleri
        ArrayList<Character> kullanilanSekiller1 = new ArrayList<>();
        ArrayList<Character> kullanilanSekiller2 = new ArrayList<>();
        ArrayList<Character> kullanilanSekiller3 = new ArrayList<>();

        // Her karakterin en fazla 3 kez kullanılması gerektiği için karakter sayacı belirlenir
        int karakterSayaci = (satir * sutun) / 3;

        // Karakter listelerini doldurma
        while (kullanilanSekiller1.size() < karakterSayaci || kullanilanSekiller2.size() < karakterSayaci
                || kullanilanSekiller3.size() < karakterSayaci) {
            char randChar;
            int randNum = rand.nextInt(3);
            switch (randNum) {
                case 0:
                    randChar = (char) (rand.nextInt(26) + 'a'); // Küçük harfler
                    break;
                case 1:
                    randChar = (char) (rand.nextInt(26) + 'A'); // Büyük harfler
                    break;
                case 2:
                    randChar = (char) (rand.nextInt(10) + '0'); // Rakamlar
                    break;
                default:
                    randChar = ' '; // Varsayılan durum, derleme hatası önlemek için
                    break;
            }
            // Her bölgeye ait karakter listelerini doldurma ve aynı karakterin tekrar eklenmemesi için kontrol
            if (kullanilanSekiller1.size() < karakterSayaci && !kullanilanSekiller1.contains(randChar)) {
                kullanilanSekiller1.add(randChar);
            }
            if (kullanilanSekiller2.size() < karakterSayaci && !kullanilanSekiller2.contains(randChar)) {
                kullanilanSekiller2.add(randChar);
            }
            if (kullanilanSekiller3.size() < karakterSayaci && !kullanilanSekiller3.contains(randChar)) {
                kullanilanSekiller3.add(randChar);
            }
        }

        // Karakter listelerini karıştırma
        Collections.shuffle(kullanilanSekiller1);
        Collections.shuffle(kullanilanSekiller2);
        Collections.shuffle(kullanilanSekiller3);

        // Karakterlerin üç bölgeye yerleştirilmesi
        int karakterIndex1 = 0, karakterIndex2 = 0, karakterIndex3 = 0;
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                if (j < (sutun / 3)) { // birinci bolge
                    matris[i][j] = kullanilanSekiller1.get(karakterIndex1);
                    karakterIndex1 = (karakterIndex1 + 1) % kullanilanSekiller1.size();
                } else if (j >= (sutun / 3) && j < (sutun / 3) * 2) { // ikinci bolge
                    matris[i][j] = kullanilanSekiller2.get(karakterIndex2);
                    karakterIndex2 = (karakterIndex2 + 1) % kullanilanSekiller2.size();//karakterlerin dizilimini saglar
                } else {  // ucuncu bolge
                    matris[i][j] = kullanilanSekiller3.get(karakterIndex3);
                    karakterIndex3 = (karakterIndex3 + 1) % kullanilanSekiller3.size();
                }
            }
        }
    }

    // Oyunu oynayan metot
    public static void oyna(char[][] matris, char[][] gizliMatris) {
        Scanner input = new Scanner(System.in);
        int puan = 0; // Oyuncunun puanini tutar
        int bulunan = 0; // Bulunan eslesmelerin sayisini tutar

        boolean[][] acilanHucres = new boolean[matris.length][matris[0].length]; // Acilmis hucreleri takip eder
        boolean[][] eslesmisHucres = new boolean[matris.length][matris[0].length]; // Eslesmis hucreleri takip eder

        while (true) { // Oyun döngüsü
            int[] satirlar = new int[3]; // Kullanicinin girdigi satirlari tutar
            int[] sutunlar = new int[3]; // Kullanicinin girdigi sutunlari tutar

            for (int i = 0; i < 3; i++) { // Kullanicidan 3 koordinat alir
                while (true) {
                    System.out.print("Satir " + (i + 1) + " degerini girin: ");
                    satirlar[i] = input.nextInt();
                    System.out.print("Sutun " + (i + 1) + " degerini girin: ");
                    sutunlar[i] = input.nextInt();

                    // Girilen satir ve sutun degerlerinin gecerli olup olmadigini kontrol eder
                    if (satirlar[i] > 0 && satirlar[i] <= matris.length && sutunlar[i] > 0 && sutunlar[i] <= matris[0].length) {
                        if (eslesmisHucres[satirlar[i] - 1][sutunlar[i] - 1]) {
                            System.out.println("Bu hucre zaten eslesmis. Lutfen baska bir hucre secin."); // Hucre zaten eslesmisse uyarir
                        } else if (acilanHucres[satirlar[i] - 1][sutunlar[i] - 1]) {
                            System.out.println("Bu hucre zaten acildi. Lutfen baska bir hucre secin."); // Hucre zaten acilmissa uyarir
                        } else {
                            break; // Gecerli ve acilmamis hucreyse donguden cikar
                        }
                    } else {
                        System.out.println("Gecersiz giris. Satir ve sutun degerleri hatali. Lutfen tekrar deneyin."); // Gecersiz giris uyarisi
                    }
                }
                acilanHucres[satirlar[i] - 1][sutunlar[i] - 1] = true; // Hucreyi acilmis olarak isaretler
                gizliMatris[satirlar[i] - 1][sutunlar[i] - 1] = matris[satirlar[i] - 1][sutunlar[i] - 1]; // Hucreyi gizli matris uzerinde acar
                matris_Olustur(gizliMatris.length, gizliMatris[0].length, gizliMatris); // Guncel gizli matrisi ekrana basar
            }

            // Secilen hucrelerdeki karakterleri alir
            char karakter1 = matris[satirlar[0] - 1][sutunlar[0] - 1];
            char karakter2 = matris[satirlar[1] - 1][sutunlar[1] - 1];
            char karakter3 = matris[satirlar[2] - 1][sutunlar[2] - 1];

            // Secilen hücrelerdeki karakterlerin ayni olup olmadigini kontrol eder
            if (karakter1 == karakter2 && karakter2 == karakter3) {
                System.out.println("Tebrikler! Uc hucrede ayni karakteri buldunuz. +5 puan!");
                System.out.println("******************************");
                System.out.println("Bulunan Karakter: " + karakter1);
                System.out.println("******************************");

                // Eslesen karakterleri ve eslerini matrislerden siler
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j < matris[i].length; j++) {
                        if (matris[i][j] == karakter1) {
                            matris[i][j] = ' ';
                            gizliMatris[i][j] = ' ';
                            eslesmisHucres[i][j] = true; // Eslesmis hucre olarak isaretler
                        }
                    }
                }
                bulunan++;
                puan += 5; // Puani arttirir
            } else {
                System.out.println("Uc hucrede ayni karakteri bulamadiniz. -2 puan.");
                // Hucreleri tekrar kapatir
                gizliMatris[satirlar[0] - 1][sutunlar[0] - 1] = '*';
                gizliMatris[satirlar[1] - 1][sutunlar[1] - 1] = '*';
                gizliMatris[satirlar[2] - 1][sutunlar[2] - 1] = '*';
                acilanHucres[satirlar[0] - 1][sutunlar[0] - 1] = false; // Hucreleri tekrar acilmamis olarak isaretler
                acilanHucres[satirlar[1] - 1][sutunlar[1] - 1] = false;
                acilanHucres[satirlar[2] - 1][sutunlar[2] - 1] = false;
                puan -= 2; // Puani dusurur
            }

            // Guncel gizli matrisi ekrana basar
            System.out.println("Guncel Gizli Matris:");
            System.out.println("---------------------");
            matris_Olustur(gizliMatris.length, gizliMatris[0].length, gizliMatris);
            System.out.println("---------------------");

            // Guncel matrisi ekrana basar
            System.out.println("Guncel Matris:");
            System.out.println("---------------------");
            matris_Olustur(matris.length, matris[0].length, matris);
            System.out.println("---------------------");

            // Oyunun bitip bitmedigini kontrol eder
            if (bulunan == (matris.length * matris[0].length) / 3) {
                break; // Eger tum eslesmeler bulunmussa donguden cikar
            }
        }

        // Oyun bittiginde toplam puani ekrana basar
        System.out.println("-----------------------------");
        System.out.println("Tebrikler!!!\nOyun bitti! Toplam puaniniz: " + puan);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int satir, sutun;
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Satir degeri 3 ve uzeri , sutun degeri  3'un kati seklinde giriniz!");
        System.out.println("-----------------------------------------------------------------------");

        while (true) {
            System.out.print("Lutfen satir degerini girin: ");
            satir = scan.nextInt();
            System.out.print("Lutfen sutun degerini girin: ");
            sutun = scan.nextInt();

            if (satir >= 3 && sutun % 3 == 0) {
                break; // Satir ve sutun degerleri 3'un katlari ise donguden cik
            } else {
                System.out.println("Satir degeri 3 ve uzeri , sutun degeri 3'un kati olmalidir.\nLutfen tekrar deneyin.");
            }
        }


        char[][] matris = new char[satir][sutun];
        char[][] gizliMatris = new char[satir][sutun];

        // Gizli matrisi ekrana yazdırma
        gizliMatrisOlustur(satir, sutun, gizliMatris);

        System.out.println("---------------------");

        // Matrise şekil verme ve matrisi ekrana yazdırma
        matriseSekilVer(satir, sutun, matris);
        matris_Olustur(satir, sutun, matris);

        System.out.println("---------------------");

        // Oyunu oynama
        oyna(matris, gizliMatris);

        scan.close();
    }
}
