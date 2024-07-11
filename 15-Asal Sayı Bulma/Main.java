public class Main {
    public static void main(String[] args) {
        System.out.println("1 ile 100 arasindaki asal sayilar:");
        for(int i=2; i<=100; i++) {
            if (isAsal(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isAsal(int sayi){
        for (int i=2; i<=Math.sqrt(sayi); i++){
            if(sayi%i==0){
                return false;
            }
        }
        return true;
    }
}