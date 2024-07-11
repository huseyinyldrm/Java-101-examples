import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    int cols,rows,mayinSayisi;//cols=sutun,rows=satir
    String[][] oyunTahtasi;
    String[][] mayinlarinKonumu;
    Scanner input=new Scanner(System.in);
    Random rand =new Random();

    MineSweeper(int cols,int rows){
        this.rows=rows;
        this.cols=cols;
        this.oyunTahtasi=new String[rows][cols];
        this.mayinlarinKonumu=new String[rows][cols];
        this.mayinSayisi=((rows*cols)/4); // mayin sayisi elemanin 4'te biridir.
    }
    public void run(){//oyun baslama metodu
        oyunTahtasiHazirlama();
        mayinlariYerlestir();

       // System.out.println("\n****Mayin Konumu****\n");
       // printArr(mayinlarinKonumu); //bunu cagirarak mayin konumunu gorursunuz

        int satir,sutun;
        System.out.println("\n--->Oyun Basladi<---\n");

        int mayinSayisi;
        while (true){
            printArr(oyunTahtasi);

            System.out.print("\nSatir Giriniz:");
            satir=input.nextInt();
            System.out.print("Sutun Giriniz:");
            sutun=input.nextInt();

            if(satir>=0 && sutun>=0 && satir<=rows && sutun<=cols){
                if(oyunTahtasi[satir][sutun].equals(" -")){
                    continue;
                }
                if(!" *".equals(mayinlarinKonumu[satir][sutun])){
                    mayinSayisi=mayinlariKontrolEt(satir,sutun);
                    oyunTahtasi[satir][sutun]=" "+mayinSayisi+ String.valueOf("");
                } else if (mayinlarinKonumu[satir][sutun].equals(" *")){
                    System.out.println("\nKaybettiniz.");
                    printArr(mayinlarinKonumu);
                    break;
                }
                if(this.mayinSayisi==kazandiMi()){
                    System.out.println("Tebrikler Kazandiniz.");
                    printArr(oyunTahtasi);
                    break;
                }
            }else{
                System.out.println("Hatali satir veya sutun girisi yaptiniz.Tekrar deneyin.");
            }
        }
    }
    public int kazandiMi(){
        int acilanHucreSayisi=0;

        for (String[] strings : oyunTahtasi) {
            for (int j = 0; j < oyunTahtasi[0].length; j++) {
                if (strings[j].equals(" X")){
                    acilanHucreSayisi++;
                }
            }
        }
        return acilanHucreSayisi;
    }
    public void mayinlariYerlestir(){
        int satir,sutun,count=0;

        while (count!=mayinSayisi){
            satir=rand.nextInt(rows);
            sutun=rand.nextInt(cols);

            if(!mayinlarinKonumu[satir][sutun].equals(" *")){
                mayinlarinKonumu[satir][sutun]=" *";
                count++;
            }
        }
    }

    //bu alttki metot oyun tahtasını hazırlamaya yarar.
    public void printArr(String[][] arr){
        System.out.print("     ");
        for (int colNumber=0; colNumber<arr.length;colNumber++){
            if(colNumber>10){
                System.out.print(" "+colNumber);
            }else{
                System.out.print("  "+colNumber);
            }
        }
        System.out.println();
        System.out.print("      ");
        for(int i=0; i<arr.length; i++){
            System.out.print(" _ ");
        }
        System.out.println();
        for(int i=0; i<arr.length; i++){
            if(i>=10){
                System.out.print(i + " -|");
            }
            else{
                System.out.print(i + " - |");
            }
            for(int j=0; j<arr[0].length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println("  |");
            System.out.println();
        }

    }
    // buradaki metot oyun tahtasi icine X yerlestirir.
    public void oyunTahtasiHazirlama(){
        for(int i=0; i< oyunTahtasi.length; i++){
            for(int j=0;j<oyunTahtasi[0].length; j++){
                oyunTahtasi[i][j]=" X";
                mayinlarinKonumu[i][j]=" X";
            }
        }
    }
    public int mayinlariKontrolEt(int satir,int sutun){
        int count=0;
        int tempRow ,tempCol;

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                tempRow=satir+i;
                tempCol=sutun+j;

                if(tempCol>=0 &&tempRow>=0 && tempRow<rows && tempCol<cols){
                    if(mayinlarinKonumu[tempRow][tempCol].equals(" *")){
                        continue;
                    }
                    if (!mayinlarinKonumu[tempRow][tempCol].equals(" *") && !oyunTahtasi[tempRow][tempCol].equals(" -")){
                        String eleman=oyunTahtasi[tempRow][tempCol];
                        try {
                            Integer.parseInt(eleman);
                        }catch (NumberFormatException e){
                            oyunTahtasi[tempRow][tempCol]=" -";
                        }
                    }
                }
            }
        }
        return count;
    }

}
