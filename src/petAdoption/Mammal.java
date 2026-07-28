package petAdoption;
import java.util.HashSet;

public class Mammal extends Animal {

    private String mammalType;
    private String furColor;

    public Mammal(){
        super();
        species = "Mammal";
        mammalType = "TBD";
        furColor = "blank";
        price = 100;
    }
    @Override
    public int getPrice(){
        return price;
    }
    @Override
    public void setPrice(int price){
        this.price = price;
    }
    public String getMammalType(){
        return mammalType;
    }
    public void setMammalType(String mammalType){
        this.mammalType = mammalType;
    }
    public String getFurColor(){
        return furColor;
    }
    public void setFurColor(String furColor){
        this.furColor = furColor;
    }
    public Mammal(String mt, int a, double w, String fc){
        mammalType = mt;
        age = a;
        weight = w;
        furColor = fc;
        species = "Mammal";
        price = 100;
    }
    public static void mammalBuy(HashSet<Mammal> mammalStock){
        System.out.println("Here is our list of Mammals:");
        for (Mammal m : mammalStock){
            m.printInfo(m);
        }
        System.out.println("What Mammal type would you like to purchase?");
    }
    public static void mammalPrint(HashSet<Mammal> mammalStock){
        System.out.println("Here is our list of Mammals:");
        for (Mammal m : mammalStock){
            m.printInfo(m);
        }
    }
    @Override 
    public void printInfo(Object Mammal){
        System.out.println("Type: " + this.getMammalType());
        super.printInfo(Mammal);
        System.out.println("Fur color: " + this.getFurColor());
    }
}
