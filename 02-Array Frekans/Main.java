import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        HashMap<Integer,Integer> frekanslar = new HashMap<>();

        int[] dizi=new int[10];
        int[] uye=new int[dizi.length];

        for(int i=0; i< dizi.length; i++){
            System.out.print("Dizi Elemanini giriniz:");
            uye[i]=input.nextInt();
        }
        System.out.println("Dizinin siralanmis hali:\n");
        Arrays.sort(uye);
        System.out.println(Arrays.toString(uye));
        System.out.println("Dizinin frekanslari:\n");

        // dizideki elemanların frekanslarını hesapla
        for(int eleman: uye){
            if(frekanslar.containsKey(eleman)){
                frekanslar.put(eleman, frekanslar.get(eleman)+1);
            }else{
                frekanslar.put(eleman,1);
            }
        }

        // sonuçları ekrana yazdır

        for(int eleman: frekanslar.keySet()){
            System.out.println(eleman+" sayisi "+ frekanslar.get(eleman)+" kez tekrar edildi.");
        }


    }
}