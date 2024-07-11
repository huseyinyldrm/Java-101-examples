import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int secim;
        String userName,password,yeniSifre;

        System.out.print("Kullanici adinizi giriniz:");
        userName=input.nextLine();

        System.out.print("sifreniz:");
        password=input.nextLine();

        if(userName.equals("patika") && password.equals("java1234")){
            System.out.println("Giris basarili");
        }
        else{
            System.out.println("Bilgileriniz hatali");
            System.out.println("Sifrenizi sifirlamak ister misiniz?");
            System.out.println("1-Evet\n2-Hayır");
            secim= input.nextInt();

            if(secim==1){

                input.nextLine(); // buffer temizleme yapar çok önemli
                System.out.println("Yeni sifre giriniz:");
                yeniSifre= input.nextLine();

                // yeni şifre ile eski şifre aynı mı kontrolü
                if(!yeniSifre.equals(password)){
                    System.out.println("Sifre olusturuldu.");
                }
                else{
                    System.out.println("Sifre olusturulamadı.Lütfen baska bir sifre giriniz:");
                }
            }
            else{
                System.out.println("Islem iptal edildi.");
            }


        }


    }
}