
public class Main {
    public static void main(String[] args) {
        Car audi=new Car();
        audi.model ="Audi rs7";
        audi.type="Sedan";
        audi.color="Black";
        audi.speedLimit=340;
        audi.speed=10;
        audi.increaseSpeed(30);
        audi.printSpeed();

        System.out.println(" Marka:"+audi.model+"\n Type: "+audi.type+"\n Renk: "+audi.color);
        System.out.println(" Hiz Limiti: "+audi.speedLimit+"\n Su anki Hizi:"+audi.speed);
        System.out.println("================================");

        Car bmw = new Car();

        bmw.model="BMW M8";
        bmw.type="Coupe Sedan";
        bmw.color="Black";
        bmw.speedLimit=340;
        bmw.speed=10;
        bmw.increaseSpeed(50);
        bmw.printSpeed();

        System.out.println(" Marka:"+bmw.model+"\n Type: "+bmw.type+"\n Renk: "+bmw.color);
        System.out.println(" Hiz Limiti: "+bmw.speedLimit+"\n Su anki Hizi:"+bmw.speed);
        System.out.println("================================");

        Car mercedes=new Car();

        mercedes.model="Mecedes S Class";
        mercedes.type="Sedan";
        mercedes.color="Black";
        mercedes.speedLimit=320;
        mercedes.speed=10;
        mercedes.increaseSpeed(50);
        mercedes.printSpeed();

        System.out.println(" Marka:"+mercedes.model+"\n Type: "+mercedes.type+"\n Renk: "+mercedes.color);
        System.out.println(" Hiz Limiti: "+mercedes.speedLimit+"\n Su anki Hizi:"+mercedes.speed);
        System.out.println("================================");
    }
}