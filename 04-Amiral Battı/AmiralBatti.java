import java.util.Random;
import java.util.Scanner;

/*
private static=bir degiskenin veya metotun sinifa ait oldugunu ve sinifin herhangi bir ornegi olusturulmadan kullanilabilecegini belirtir.
private final=Bir degiskenin sadece bir kez atanabilecegini ve daha sonra degistirilemeyecegini belirtir.
yani dizi referansı ve elemanları başka bir yerde değiştirilemez.
Bu constructor, bir "AmiralBatti" oyununun baslangic durumunu hazirlamak icin kullanilir.
Oyunun boyutunu belirler ve iki boyutlu diziler olan tahta ve gizliTahta'nin boyutunu belirler.
Bu diziler, oyunun oynandigi tahtalari temsil eder.
Bir sinifin nesnelerini olusturmak ve baslangic degerlerini atamak icin ozel bir metoddur.
*/
public class AmiralBatti {
    private static int boyut;
    private final int[][] tahta;
    private final boolean[][] gizliTahta;
    private final Random random = new Random();
    private static final int amiralGemiBoyutu = 5;
    private static final int destroyerGemiBoyutu = 4;
    private static final int kruvazorGemiBoyutu = 3;
    private static final int denizaltiBoyutu = 2;
    private int kullaniciHak = 1;
    private int bilgisayarHak = 1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Amiral Batti Oyununa Hosgeldiniz");
        System.out.println("================================");
        System.out.println("1-Kolay Seviye(10x10)");
        System.out.println("2-Zor Seviye(14x14)");
        System.out.print("Seviye Seciniz:");
        int secim = input.nextInt();

        if (secim == 1) {
            int boyut = 10;
            AmiralBatti oyun = new AmiralBatti(boyut);
            oyun.basla();
        } else if (secim == 2) {
            int boyut = 14;
            AmiralBatti oyun = new AmiralBatti(boyut);
            oyun.basla();

        } else {
            System.out.println("Gecerli bir deger giriniz.");
        }
        input.close();
    }

    // Constructor
    public AmiralBatti(int boyut) {
        this.boyut = boyut;
        tahta = new int[boyut][boyut];
        gizliTahta = new boolean[boyut][boyut];
    }

    //oyunu baslatan metot
    public void basla() {
        tahtalariOlustur();
        gemileriYerlestir();
        mayinlariYerlestir();
        while (!oyunBittiMi()) {
            //haritayiGoster();// bu harita acilirsa gemi ve mayinlarin konumunu gosterir.
            tahtalariGoster();
            kullaniciOyunHamlesi();
            tahtalariGoster();
            bilgisayarOyunHamlesi();
            tahtalariGoster();
        }
    }

    // tahtalari olusturan metot
    private void tahtalariOlustur() {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                tahta[i][j] = 0;
                gizliTahta[i][j] = true;
            }
        }
    }

    //gemileri yerlestiren metot
    private void gemileriYerlestir() {

        gemiYerlestir(amiralGemiBoyutu);

        gemiYerlestir(destroyerGemiBoyutu);
        gemiYerlestir(destroyerGemiBoyutu);

        gemiYerlestir(kruvazorGemiBoyutu);
        gemiYerlestir(kruvazorGemiBoyutu);
        gemiYerlestir(kruvazorGemiBoyutu);

        gemiYerlestir(denizaltiBoyutu);
        gemiYerlestir(denizaltiBoyutu);
        gemiYerlestir(denizaltiBoyutu);
        gemiYerlestir(denizaltiBoyutu);
    }

    //tek bir gemiyi yerlestiren metot
    private void gemiYerlestir(int gemiBoyutu) {
        boolean yerlestirildi = false;
        while (!yerlestirildi) {
            int x = random.nextInt(boyut);
            int y = random.nextInt(boyut);
            boolean yatay = random.nextBoolean();

            boolean gemiCakisiyor = false;
            // yatayda random gemi yerlestirme
            if (yatay && x + gemiBoyutu <= boyut) {
                for (int i = x - 1; i < x + gemiBoyutu + 1; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (i >= 0 && i < boyut && j >= 0 && j < boyut && tahta[i][j] != 0) {
                            gemiCakisiyor = true;
                            break;
                        }
                    }
                    if (gemiCakisiyor) break;
                }
                if (!gemiCakisiyor) {
                    for (int i = x; i < x + gemiBoyutu; i++) {
                        tahta[i][y] = gemiBoyutu;
                        gizliTahta[i][y] = true;
                    }
                    yerlestirildi = true;
                }
                // dikeyde gemi yerlestirme
            } else if (!yatay && y + gemiBoyutu <= boyut) {
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y - 1; j < y + gemiBoyutu + 1; j++) {
                        if (i >= 0 && i < boyut && j >= 0 && j < boyut && tahta[i][j] != 0) {
                            gemiCakisiyor = true;
                            break;
                        }
                    }
                    if (gemiCakisiyor) break;
                }
                if (!gemiCakisiyor) {
                    for (int j = y; j < y + gemiBoyutu; j++) {
                        tahta[x][j] = gemiBoyutu;
                        gizliTahta[x][j] = true;
                    }
                    yerlestirildi = true;
                }
            }
        }
    }

    //mayinlari yerlestiren metot
    private void mayinlariYerlestir() {
        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = random.nextInt(boyut);
                y = random.nextInt(boyut);
            } while (tahta[x][y] != 0);

            tahta[x][y] = -1; //mayin
            gizliTahta[x][y] = true;
        }
    }

    //tahtalari gosteren metot
    private void tahtalariGoster() {
        System.out.println("=================");
        System.out.println("Oyun Haritasi:");
        System.out.println("=================");
        System.out.print("   ");
        for (int colNumber = 0; colNumber < boyut; colNumber++) {
            if (colNumber < 10) {
                System.out.print("  " + colNumber);
            } else {
                System.out.print(" " + colNumber);
            }
        }
        System.out.println();

        System.out.print("    ");
        for (int colNumber = 0; colNumber < boyut; colNumber++) {
            System.out.print(" _ ");
        }
        System.out.println();

        for (int i = 0; i < boyut; i++) {
            if (i < 10) {
                System.out.print(" " + i + " |");
            } else {
                System.out.print(i + " |");
            }
            for (int j = 0; j < boyut; j++) {
                if (gizliTahta[i][j]) {
                    System.out.print(" ~ ");
                } else {
                    if (tahta[i][j] == -1) {
                        System.out.print(" * ");
                    } else if (tahta[i][j] == 0) {
                        System.out.print(" O ");
                    } else {
                        System.out.print(" X ");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    // haritayi gosteren metot
    private void haritayiGoster() {
        System.out.println("=================");
        System.out.println("Gemilerin ve Mayinlarin Konumu:");
        System.out.println("=================");
        System.out.print("   ");
        for (int colNumber = 0; colNumber < boyut; colNumber++) {
            if (colNumber < 10) {
                System.out.print("  " + colNumber);
            } else {
                System.out.print(" " + colNumber);
            }
        }
        System.out.println();

        System.out.print("    ");
        for (int colNumber = 0; colNumber < boyut; colNumber++) {
            System.out.print(" _ ");
        }
        System.out.println();

        for (int i = 0; i < boyut; i++) {
            if (i < 10) {
                System.out.print(" " + i + " |");
            } else {
                System.out.print(i + " |");
            }
            for (int j = 0; j < boyut; j++) {
                if (tahta[i][j] == -1) {
                    System.out.print(" * ");
                } else if (tahta[i][j] == 0) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    // oyunun bittigini kontrol eden metot
    private boolean oyunBittiMi() {
        // amiral gemisi batarsa oyun biter
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (tahta[i][j] == amiralGemiBoyutu && gizliTahta[i][j]) {
                    return false; // amiral gemisi henuz batmadi
                }
            }
        }
        System.out.println("Tebrikler.Amiral gemisi batirildi Kazandiniz!");
        return true;
    }

    // kullanicinin oyun hamlesini kontrol eden metot
    private void kullaniciOyunHamlesi() {
        Scanner input = new Scanner(System.in);

        boolean tekrarAtis = true;

        while (tekrarAtis) {
            System.out.println("Sira sizde.Koordinatlari giriniz");
            System.out.print("Satir degeri:");
            int satir = input.nextInt();
            System.out.print("Sutun degeri:");
            int sutun = input.nextInt();

            if (satir >= 0 && satir <= boyut && sutun >= 0 && sutun <= boyut) {
                if (gizliTahta[satir][sutun]) {
                    if (tahta[satir][sutun] == -1) {
                        System.out.println("Atisiniz mayina denk geldi.Hakkiniz bitti.");

                        gizliTahta[satir][sutun] = false;

                        kullaniciHak = 0;
                        bilgisayarHak += 2;
                        tekrarAtis = false;

                    } else if (tahta[satir][sutun] > 0) {
                        System.out.println("Tebrikler bir gemi vurdunuz.Bir hak daha kazandiniz.");
                        gizliTahta[satir][sutun] = false;
                        kullaniciHak++;

                    } else {
                        System.out.println("Isabet yok.");
                        gizliTahta[satir][sutun] = false;
                        kullaniciHak--;
                        tekrarAtis = false;
                    }
                } else {
                    System.out.println("Onceden vuruldu.Tekrar deneyin.");
                    kullaniciHak--;
                }
            } else {
                System.out.println("Gecersiz koordinatlar.Tekrar deneyin.");
                kullaniciHak--;
            }
        }
    }

    //bilgisayarin oyun hamlesini kontrol eden metot
    private void bilgisayarOyunHamlesi() {

        boolean tekrarAtis = true;

        while (tekrarAtis) {
            System.out.println("Sira bilgisayarda.");

            int satir = random.nextInt(boyut);
            int sutun = random.nextInt(boyut);
            System.out.println("Bilgisayarin vurdugu koordinatlar:" + satir + " " + sutun);

            if (gizliTahta[satir][sutun]) {
                if (tahta[satir][sutun] == -1) {
                    System.out.println("Bilgisayar mayina denk geldi.Hakki bitti.");
                    bilgisayarHak = 0;
                    kullaniciHak += 2;
                    gizliTahta[satir][sutun] = false;
                    tekrarAtis = false;

                } else if (tahta[satir][sutun] > 0) {
                    System.out.println("Bilgisayar bir gemi vurdu.");
                    bilgisayarHak++;
                    gizliTahta[satir][sutun] = false;
                    oyunBittiMi();

                } else {
                    System.out.println("Bilgisayarin atisi isabetli degil.");
                    bilgisayarHak--;
                    gizliTahta[satir][sutun] = false;
                    tekrarAtis = false;
                }
            } else {
                System.out.println("Onceden vuruldu.Tekrar deneyin");
                return;
            }
        }
    }
}