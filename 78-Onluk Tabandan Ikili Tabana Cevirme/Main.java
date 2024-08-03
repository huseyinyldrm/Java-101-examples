import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayi,s=0,i=0,basamak; // degiskenlerin tanimlanmasi
        System.out.print("Bir sayi giriniz:");
        sayi= input.nextInt(); //sayinin girilmesi

        while (sayi>0){
            //Cevirme isleminin yapilmasi
            basamak=(int) ((sayi%2)*Math.pow(10,i));
            i++;
            sayi=sayi/2;
            s=s+basamak;
        }

        System.out.println(s);
        input.close();


    }
}