package petAdoption;
import java.util.Scanner;

public class Animal {

    // Scanner scnr = new Scanner(System.in);
    private static int numAnimals;
    protected int id;
    protected int age;
    protected double weight;
    protected String species;
    protected int price;

    public Animal(){
        id = numAnimals;
        age = 0;
        weight = 0.0;
        species = "TBD";
        numAnimals++;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public static int getNumAnimals(){
        return numAnimals;
    }
    public static void setNumAnimals(int numAnimals){
        Animal.numAnimals = numAnimals;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species){
        this.species = species;
    }
    public Animal(String s, int a, double w){
        id = numAnimals;
        species = s;
        age = a;
        weight = w;
        numAnimals++;
    }
    public void printInfo(Object Animal){
        System.out.println("ID: " + this.getId());
        System.out.println("Species: " + this.getSpecies());
        System.out.println("Age: " + this.getAge());
        System.out.println("Weight: " + this.getWeight());
        System.out.println("Price: " + this.getPrice());
    }
}