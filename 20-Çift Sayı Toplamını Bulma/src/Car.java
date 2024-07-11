class Car {
    String type;
    String model;
    String color;
    int speed;
    int speedLimit;

    void increaseSpeed(int increment){
        if(speed+increment<speedLimit) {
            speed += increment;
        }
    }
    void decreaseSpeed(int decrase){
        if(speed>0){
            speed-=decrase;
        }
    }
    void printSpeed(){
        System.out.println(" Hiziniz:"+speed);
    }

}
