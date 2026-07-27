package petAdoption;
import java.util.ArrayList;

public class Bird extends Animal {

    private String birdType;
    private String feathColor;

    public Bird(){
        super();
        species = "Bird";
        birdType = "TBD";
        feathColor = "blank";
        price = 25;
    }
    @Override
    public int getPrice(){
        return price;
    }
    @Override
    public void setPrice(int price){
        this.price = price;
    }
    public String getBirdType(){
        return birdType;
    }
    public void setBirdType(String birdType){
        this.birdType = birdType;
    }
    public String getFeathColor(){
        return feathColor;
    }
    public void setFeathColor(String feathColor){
        this.feathColor = feathColor;
    }
    public Bird(int a, double w){
        age = a;
        weight = w;
    }
    public Bird(String bt, int a, double w, String fc){
        birdType = bt;
        age = a;
        weight = w;
        feathColor = fc;
        species = "Bird";
        price = 25;
    }
    public static void birdBuy(ArrayList<Bird> birdStock){
        System.out.println("Here is our list of Birds:");
        for (Bird b : birdStock){
            b.printInfo(b);
        }
        System.out.println("What Bird type would you like to purchase?");
    }
    public static void birdPrint(ArrayList<Bird> birdStock){
        System.out.println("Here is our list of Birds:");
        for (Bird b : birdStock){
            b.printInfo(b);
        }
    }
    @Override 
    public void printInfo(Object Bird){
        System.out.println("Type: " + this.getBirdType());
        super.printInfo(Bird);
        System.out.println("Feather color: " + this.getFeathColor());
    }
}
