import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] list={11,44,78,88,65,43,66,34,23,32,21};

        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));


        System.out.print("Bir sayi giriniz:");
        int sayi= input.nextInt();

        int buyukDeger=findNearNumber(list,sayi);
        int kucukDeger=findNearSmall(list,sayi);

        System.out.println("Girilen sayidan kucuk en yakin:"+kucukDeger);
        System.out.println("Girilen sayidan buyuk en yakin:"+buyukDeger);
    }
    public static int findNearSmall(int[] list,int sayi){
        Arrays.sort(list);

        for (int i=list.length-1; i>=0; i--){
            if(list[i]<sayi){
                return list[i];
            }
        }
        return -1; //bulunamadı
    }

    //  Girilen sayıdan büyük en yakın sayıyı bulan fonksiyon
    public  static int findNearNumber(int[] list,int sayi){
        Arrays.sort(list);

        for (int j : list) {
            if (j > sayi) {
                return j;
            }
        }
        return  -1; // bulunamadı
    }
}