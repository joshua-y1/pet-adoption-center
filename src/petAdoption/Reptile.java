package petAdoption;
import java.util.ArrayList;

public class Reptile extends Animal {

    private String reptileType;
    private String scalesColor;

    public Reptile(){
        super();
        species = "Reptile";
        reptileType = "TBD";
        furColor = "blank";
        price = 50;
    }
    @Override
    public int getPrice(){
        return price;
    }
    @Override
    public void setPrice(int price){
        this.price = price;
    }
    public String getReptileType(){
        return reptileType;
    }
    public void setReptileType(String reptileType){
        this.reptileType = reptileType;
    }
    public String getScalesColor(){
        return scalesColor;
    }
    public void setScalesColor(String scalesColor){
        this.scalesColor = scalesColor;
    }
    public Reptile(String rt, int a, double w, String sc){
        reptileType = rt;
        age = a;
        weight = w;
        furColor = sc;
        species = "Reptile";
        price = 50;
    }
    public static void reptileBuy(ArrayList<Reptile> reptileStock){
        System.out.println("Here is our list of Reptiles:");
        for (Reptile r : reptileStock){
            r.printInfo(r);
        }
        System.out.println("What Reptile type would you like to purchase?");
    }
    public static void reptilePrint(ArrayList<Reptile> reptileStock){
        System.out.println("Here is our list of Reptiles:");
        for (Reptile r : reptileStock){
            r.printInfo(r);
        }
    }
    @Override 
    public void printInfo(Object Reptile){
        System.out.println("Type: " + this.getReptileType());
        super.printInfo(Reptile);
        System.out.println("Scales: " + this.getFurColor());
    }
}
