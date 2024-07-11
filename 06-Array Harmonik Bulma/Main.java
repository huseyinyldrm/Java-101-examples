
public class Main {
    public static void main(String[] args) {
        int[] liste={1,2,3,4,5,6};
        double total=0;
        double harmonik;

        for (int i=0; i< liste.length; i++){
            total+=(1.0/liste[i]);
        }

        /*
         * forEach ile g&ouml;sterimi:
         * for(int i:liste){
         *     total+=(1.0/i)
         * }
         * */

        harmonik=liste.length/total;
        System.out.println("Dizinin harmonik ortalamasi:"+harmonik);


    }
}