public class Main {
    public static void main(String[] args) {
        int[] list={23,65,87,90,34,12,54,80};
        int min=list[0];
        int max=list[0];

        for(int i:list){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }

        System.out.println("Minimum deger:"+min);
        System.out.println("Maksimum deger:"+max);
    }
}