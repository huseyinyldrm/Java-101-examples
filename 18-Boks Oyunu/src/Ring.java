public class Ring {
    Fighter f1;
    Fighter f2;

    int minWeight;
    int maxWeight;

    Ring(Fighter f1,Fighter f2,int minWeight,int maxWeight){
        this.f1=f1;
        this.f2=f2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
    }

    public void run(){
        if(checkWeight()){
            boolean isFirstFighterTurn=Math.random()<=0.5;
            //0 - 1 arasında rastgele değer üretilecek eğer değer 0.5 ten küçükse ilk vuruşu f1 yapacak
            //eğer 0.5 te büyükse ilk vuruşu f2 yapcak

            while (f1.health>0 && f2.health>0){
                System.out.println("======= YENİ ROUND=======");
                if(isFirstFighterTurn){
                    this.f2.health=this.f1.hit(this.f2);
                }else{
                    this.f1.health=this.f2.hit(this.f1);
                }
                if(isWin()){
                    break;
                }

                printScore();
                isFirstFighterTurn=!isFirstFighterTurn;
            }
        }else{
            System.out.println("Sporcularin skletleri uyusmuyor.");
        }

    }
    public boolean checkWeight(){
        return (f1.weight>=minWeight && f1.weight<=maxWeight) &&
                (f2.weight>=minWeight && f2.weight<=maxWeight);
    }
    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maci kazanan:" + f2.name);
            return true;
        } else if (f2.health == 0) {
            System.out.println("Maci kazanan:" + f1.name);
            return true;
        }
        return false;
    }
    public  void printScore(){
        System.out.println("----------------");
        System.out.println(f1.name+" Kalan Can:"+f1.health);
        System.out.println(f2.name+" Kalan Can:"+f2.health);

    }
}

