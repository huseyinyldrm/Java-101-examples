
public class Main {
    public static void main(String[] args) {
        Fighter f1=new Fighter("Drago",15,100,90,50);
        Fighter f2=new Fighter("Helyos",10,95,100,50);
        Ring area=new Ring(f1,f2,90,100);
        area.run();

    }
}