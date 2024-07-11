import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("Ogrenci Bilgi Sistemine Hosgeldiniz");
        System.out.println("***************************************");

        int secim;
        do {
           System.out.println("""
                    1-Ogrenci Bilgileri Adresi
                    2-Ogrenci Bilgileri Okuma
                    3-Ogrenci Butunleme Durumu
                    4-Cikis
                    """);
            System.out.println("***************************************");
            System.out.print("Yapmak istediginiz islemi giriniz:");
            secim = input.nextInt();
            System.out.println("***************************************");
            try {


                switch (secim) {
                    case 1:
                        // Öğrenci bilgilerini oluştur ve dosyaya kaydet
                        olusturKaydet("OgrenciBilgi.txt", 50); // Örneğin 50 öğrenci için
                        break;
                    case 2:
                        // Dosyadan öğrenci bilgilerini oku
                        dosyaIceriginiOku("OgrenciBilgi.txt");
                        break;
                    case 3:
                        // Dosyadan öğrenci bilgilerini oku ve bütünleme durumunu kontrol et
                        butunlemeKontrolu("OgrenciBilgi.txt", "ButunlemeDurumu.txt");

                        break;
                    case 4:
                        System.out.println("Sistemden cikis yapiliyor.Iyi gunler.");
                        break;
                    default:
                        System.out.println("Gecerli bir deger giriniz.");
                        break;
                }
            } catch (IOException e) {
               // e.printStackTrace();
            }
        } while (secim != 4);

        input.close();
    }

    // Verilen isim ve soyisim listelerinden rastgele öğrenci bilgileri oluştur
    public static void olusturKaydet(String dosyaAdi, int ogrenciSayisi) {
        String[] isimler = {"Veli", "Ahmet", "Mehmet", "Abubekir", "Omer", "Osman", "Ali", "Murat", "Mert", "Nur"};
        String[] soyisimler = {"Ak", "Pak", "Tak", "Hak", "Yak", "Sak", "Bak", "Yilmaz", "Sari", "Al"};
        try (PrintWriter writer = new PrintWriter(new FileWriter(dosyaAdi))) {
            Random random = new Random();


            for (int i = 1; i <= ogrenciSayisi; i++) {
                String isim = isimler[random.nextInt(isimler.length)];
                String soyisim = soyisimler[random.nextInt(soyisimler.length)];
                int vize; // 50-100 arası
                int odev; // 50-100 arası
                int finalNotu;

                // Yarı yarıya geçen ve kalan öğrencileri oluştur
                if (i <= ogrenciSayisi / 2) {
                    finalNotu = random.nextInt(51) + 50; // 50-100 arası geçmiş öğrenci
                    odev = random.nextInt(51) + 50;
                    vize = random.nextInt(51) + 50;
                } else {
                    finalNotu = random.nextInt(50); // 0-49 arası kalmış öğrenci
                    odev = random.nextInt(50);
                    vize = random.nextInt(50);
                }

                // Öğrenci bilgilerini dosyaya yaz
                writer.println(isim + " " + soyisim + "," + vize + "," + odev + "," + finalNotu);
            }
            System.out.println("""
                    Olusturulan icerikler basarili bir sakilde kaydedildi.
                    Ogrenci bilgilerinin kaydedildigi dosya adi: OgrenciBilgi.txt
                    Bu dosyayi goruntulemek icin 2 tusuna basin.
                    Butunleme durumunun kaydedildigi dosya adi:ButunlemeDurumu.txt
                    Bu dosyayi goruntulemek icin 3 tusuna basin.
                    """);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    // Dosya içeriğini oku ve konsola yazdir
    public static void dosyaIceriginiOku(String dosyaAdi) throws IOException {
        System.out.println("Dosya İçeriği:");
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                System.out.println(satir);
            }
        }
        System.out.println("Dosya İçeriği Okundu.\n");
    }

    // Dosyadan öğrenci bilgilerini oku ve bütünleme durumunu kontrol et
    public static void butunlemeKontrolu(String okumaDosyasi, String yazmaDosyasi) {
        try (BufferedReader reader = new BufferedReader(new FileReader(okumaDosyasi));
             PrintWriter writer = new PrintWriter(new FileWriter(yazmaDosyasi))) {

            String satir;
            int ogrenciSayisi = 50;
            int gecenSayisi = 0;
            int kalanSayisi = 0;
            //int sartliGecenler = 0;

            while ((satir = reader.readLine()) != null) {
                String[] bilgiler = satir.split(",");
                String adSoyad = bilgiler[0];
                int vize = Integer.parseInt(bilgiler[1]);
                int odev = Integer.parseInt(bilgiler[2]);
                int finalNotu = Integer.parseInt(bilgiler[3]);

                // Bütünleme durumunu kontrol et
                double ortalama = (vize * 0.24 + odev * 0.16 + finalNotu * 0.6);


                if (ortalama >= 60 && finalNotu >= 50) {
                    String tebrikMesaji = adSoyad + " - Tebrikler, gectiniz. Ortalama: " + ortalama;
                    System.out.println(tebrikMesaji);
                    writer.println(tebrikMesaji);
                    gecenSayisi++;

                }/* else if (finalNotu >= 50 && ortalama < 60) {
                    String tebrikMesaji = adSoyad + "-Sartli gectiniz.Ortalama:" + ortalama;
                    System.out.println(tebrikMesaji);
                    writer.println(tebrikMesaji);
                    sartliGecenler++;
                } */else {
                    double minimumPuan = (60 - ortalama) / 0.6;
                    String mesaj = adSoyad + " - Kaldiniz.Butunlemeden gecebilmek icin gereken minimum puan: " + minimumPuan +
                            " Ortalama: " + ortalama;
                    System.out.println(mesaj);
                    writer.println(mesaj);
                    kalanSayisi++;
                }
            }
            System.out.println();
            System.out.println("Ogrenci Sayisi: " + ogrenciSayisi);
            System.out.println("Direkt Gecenlerin Sayisi: " + gecenSayisi);
            //System.out.println("Sartli Gecenlerin Sayisi: " + sartliGecenler);
            System.out.println("Kalanlarin Sayisi: " + kalanSayisi);
        } catch (IOException ignored){}
    }
}