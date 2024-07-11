import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HafizaOyunu {

    private JFrame ilkPencere;
    private JFrame oyunPenceresi;
    private JFrame sonucPenceresi;
    private JButton[][] dugmeler;
    private Character[][] matris;
    private boolean[][] gizliMatris;
    private int puan;
    private int bulunan;
    private char[] secilenKarakterler;
    private int secilenKarakterSayisi;
    private Timer timer;

    // Ana constructor
    public HafizaOyunu() {
        ilkPencere = new JFrame("Oyun Ayarlari");
        ilkPencere.setSize(350, 350);
        ilkPencere.setLocationRelativeTo(null); //Pencerenin konumu, ekranin ortasina yerlestirilir.
        ilkPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Pencere kapatildiginda program da sonlanir.
        ilkPencere.setLayout(new GridLayout(6, 1));// bilesenleri bir tablo gibi düzenler.Bu durumda,6 satir ve 1 sutun olacak sekilde duzenlenir.

        JLabel hosgeldinizLabel = new JLabel("Oyuna Hosgeldiniz!");// Kullaniciyi karsilamak icin bir metin etiketi olusturulur.
        hosgeldinizLabel.setHorizontalAlignment(SwingConstants.CENTER);//Metin etiketinin yatay hizalamasi, etiketin icindeki metnin ortalanmasini saglar.
        JLabel satirLabel = new JLabel("Satir Sayisi:");
        JTextField satirField = new JTextField(1);//  Kullanicidan satir sayisini girmesi icin bir metin alani olusturulur.
        JLabel sutunLabel = new JLabel("Sutun Sayisi (3'un kati olmali):");
        JTextField sutunField = new JTextField(1);
        JButton baslatButton = new JButton("Oyunu Baslat");// Buton olusturur ve icine metin yazar.

        ilkPencere.add(hosgeldinizLabel); // burada acilan ilk pencereye isstenen seyler eklenir.
        ilkPencere.add(satirLabel);
        ilkPencere.add(satirField);
        ilkPencere.add(sutunLabel);
        ilkPencere.add(sutunField);
        ilkPencere.add(baslatButton);

        baslatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  // kullanicinin butona tikladiginda gerceklesen olaylari icerir.
                String satirStr = satirField.getText();// ustte girilen satirField degerini burada getirir.
                String sutunStr = sutunField.getText();

                try {
                    int satirSayisi = Integer.parseInt(satirStr);// Baslangicta metin olan degerleri burada intagere donusturduk.
                    int sutunSayisi = Integer.parseInt(sutunStr);
                    if (sutunSayisi>0 && sutunSayisi % 3 == 0) {
                        ilkPencere.setVisible(false); // Önceki pencereyi kapat
                        oyunuBaslat(satirSayisi, sutunSayisi); // Oyun penceresini başlat
                    } else {
                        JOptionPane.showMessageDialog(null, "Sutun sayisi 3'un kati olmalidir.");// uyari mesajlari gosterir.
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Gecersiz giris! Lutfen bir tam sayi girin.");
                }
            }
        });

        ilkPencere.setVisible(true);//ilk pencerenin kullaniciya gorunur hale gelmesini saglar.
    }

    // Oyun penceresini başlatma
    private void oyunuBaslat(int satirSayisi, int sutunSayisi) {
        oyunPenceresi = new JFrame("Hafiza Oyunu");
        oyunPenceresi.setSize(600, 600);
        oyunPenceresi.setLocationRelativeTo(null);
        oyunPenceresi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyunPenceresi.setLayout(new GridLayout(satirSayisi, sutunSayisi));

        dugmeler = new JButton[satirSayisi][sutunSayisi];
        matris = new Character[satirSayisi][sutunSayisi];
        gizliMatris = new boolean[satirSayisi][sutunSayisi];
        puan = 0;
        bulunan = 0;
        secilenKarakterler = new char[3];
        secilenKarakterSayisi = 0;

        matriseSekilVer(satirSayisi, sutunSayisi,matris);
        gizliMatrisOlustur(satirSayisi, sutunSayisi);


        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                JButton button = new JButton("*"); // Baslangicta tum dugmeler * karakteriyle baslar
                final int satir = i;
                final int sutun = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ac(satir, sutun);
                    }
                });
                oyunPenceresi.add(button);
                dugmeler[i][j] = button;
            }
        }

        oyunPenceresi.setVisible(true);
    }

    // Oyun matrisini oluşturma
    private void matriseSekilVer(int satir, int sutun, Character[][] matris) {// dikkat matris turu Character
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


    // Gizli matrisi oluşturma
    private void gizliMatrisOlustur(int satirSayisi, int sutunSayisi) {
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                gizliMatris[i][j] = true;
            }
        }
    }

    // Dugme tiklama islemi
    private void ac(int satir, int sutun) {
        if (!gizliMatris[satir][sutun]) {
            JOptionPane.showMessageDialog(oyunPenceresi, "Bu hucre zaten secildi!"); // uyari mesaji gosterir.
            return;
        }
        dugmeler[satir][sutun].setText(String.valueOf(matris[satir][sutun]));
        gizliMatris[satir][sutun] = false;
        secilenKarakterler[secilenKarakterSayisi] = matris[satir][sutun];
        secilenKarakterSayisi++;
        if (secilenKarakterSayisi == 3) {
            eslesmeleriKontrolEt();
            secilenKarakterSayisi = 0;
        }
    }

    // Eşleşmeleri kontrol etme
    private void eslesmeleriKontrolEt() {
        boolean eslesmeBulundu = false;
        char ilkKarakter = secilenKarakterler[0];

        // Seçilen karakterlerin aynı olup olmadığını kontrol et
        if (secilenKarakterler[1] == ilkKarakter && secilenKarakterler[2] == ilkKarakter) {
            eslesmeBulundu = true;
            JOptionPane.showMessageDialog(oyunPenceresi, "Tebrikler! Uc hucrede ayni karakteri buldunuz. +5 puan!");
            for (int i = 0; i < matris.length; i++) {
                for (int j = 0; j < matris[0].length; j++) {
                    if (matris[i][j] != null && matris[i][j] == ilkKarakter) {
                        matris[i][j] = null;
                        dugmeler[i][j].setEnabled(false);
                        dugmeler[i][j].setText("");
                        bulunan++;
                    }
                }
            }
            puan += 5;
        }

        if (!eslesmeBulundu) {
            JOptionPane.showMessageDialog(oyunPenceresi, "Uc hucrede ayni karakteri bulamadiniz. -2 puan.");
            puan -= 2;

            // 1 saniye bekleyip acik karakterleri kapatma
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < matris.length; i++) {
                        for (int j = 0; j < matris[0].length; j++) {
                            if (!gizliMatris[i][j] && matris[i][j] != null) {
                                gizliMatris[i][j] = true;
                                dugmeler[i][j].setText("*");
                            }
                        }
                    }
                    timer.stop();
                }
            });
            timer.start();
        }
        oyunSonunuKontrolEt(); // Her eslesme sonrasi oyun sonunu kontrol et
    }

    private void oyunSonunuKontrolEt() {
        int toplamKarakter = (matris.length * matris[0].length) / 3;
        if (bulunan == toplamKarakter * 3) {
            sonucPenceresi = new JFrame("Oyun Sonucu");
            sonucPenceresi.setSize(600, 600); // Yükseklik 600 olarak ayarlandı, alt alta sığması için
            sonucPenceresi.setLocationRelativeTo(null);
            sonucPenceresi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel sonucLabel = new JLabel("Tebrikler! Tum karakterleri buldunuz! Toplam puaniniz: " + puan);
            sonucLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JButton devamButton = new JButton("Oyuna Devam Et");
            devamButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sonucPenceresi.dispose(); // Sonuç penceresini kapat
                    ilkPencere.setVisible(true); // Yeni bir oyun başlatmak için ilk pencereyi göster
                }
            });

            JButton cikButton = new JButton("Çık");
            cikButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); // Programı sonlandır
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1, 2)); // İki butonu yatay düzende göstermek için

            buttonPanel.add(devamButton);
            buttonPanel.add(cikButton);

            sonucPenceresi.setLayout(new BorderLayout()); // BorderLayout kullanarak bileşenleri üstten alta yerleştirir
            sonucPenceresi.add(sonucLabel, BorderLayout.CENTER); // Sonuç mesajını ortalar
            sonucPenceresi.add(buttonPanel, BorderLayout.SOUTH); // Buton panelini en alta yerleştirir

            sonucPenceresi.setVisible(true);
        }
    }

    // Main metodu
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HafizaOyunu::new); //Swing kutuphanesinin Event Dispatch Thread'ini (EDT) kullanarak bir Swing uygulamasini baslatir.
        //"::" operatoru, Java'da bir yontemi veya yapiyi referans olarak belirtmek icin kullanilir.
    }
}
