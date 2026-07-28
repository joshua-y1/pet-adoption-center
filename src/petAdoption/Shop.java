package petAdoption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Shop {
    Scanner scnr = new Scanner(System.in);
    ArrayList<Bird> birdStock = new ArrayList<>();
    HashSet<Mammal> mammalStock = new HashSet<>();
    ArrayList<Reptile> reptileStock = new ArrayList<>();
    HashMap<Integer, Animal> animalCount = new HashMap<>();
    public int credit = 0;

    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public void populateBird() {
        Bird bird1 = new Bird("Parrot", 4, .88, "orange");
        Bird bird2 = new Bird("Parakeet", 2, 1.81, "yellow");
        Bird bird3 = new Bird("Bluejay", 1, 2.31, "blue");
        Bird bird4 = new Bird("Cardinal", 3, .66, "red");
        birdStock.add(bird1);
        birdStock.add(bird2);
        birdStock.add(bird3);
        birdStock.add(bird4);
        animalCount.put(bird1.getId(), bird1);
        animalCount.put(bird2.getId(), bird2);
        animalCount.put(bird3.getId(), bird3);
        animalCount.put(bird4.getId(), bird4);
    }

    public void populateMammal() {
        Mammal mammal1 = new Mammal("Dog", 4, 23, "White");
        Mammal mammal2 = new Mammal("Cat", 3, 11.3, "Orange");
        Mammal mammal3 = new Mammal("Gerbil", 1, 6.8, "Black");
        Mammal mammal4 = new Mammal("Hamster", 4, 9.4, "Brown");
        mammalStock.add(mammal1);
        mammalStock.add(mammal2);
        mammalStock.add(mammal3);
        mammalStock.add(mammal4);
        animalCount.put(mammal1.getId(), mammal1);
        animalCount.put(mammal2.getId(), mammal2);
        animalCount.put(mammal3.getId(), mammal3);
        animalCount.put(mammal4.getId(), mammal4);
    }

    public void populateReptile() {
        Reptile reptile1 = new Reptile("Gecko", 1, .45, "tan");
        Reptile reptile2 = new Reptile("Komodo", 6, 183, "dark green");
        Reptile reptile3 = new Reptile("Lizard", 2, .45, "blue");
        Reptile reptile4 = new Reptile("Snake", 3, 15.3, "tan");
        reptileStock.add(reptile1);
        reptileStock.add(reptile2);
        reptileStock.add(reptile3);
        reptileStock.add(reptile4);
        animalCount.put(reptile1.getId(), reptile1);
        animalCount.put(reptile2.getId(), reptile2);
        animalCount.put(reptile3.getId(), reptile3);
        animalCount.put(reptile4.getId(), reptile4);
    }

    public void initiateAdopt(Scanner scnr){
        System.out.println("Choose a pet type:");
        System.out.println("1. Reptile");
        System.out.println("2. Bird");
        System.out.println("3. Mammal");
        int choice = scnr.nextInt();
        if (choice == 3){
            Mammal.mammalBuy(mammalStock);
            String chosenMammal = scnr.next().trim();
            Iterator<Mammal> itr = mammalStock.iterator();
            while (itr.hasNext()){
                Mammal tempMam = itr.next();
                if (tempMam.getMammalType().equalsIgnoreCase(chosenMammal)){
                    System.out.println("The price of this mammal is $" + tempMam.getPrice());
                    System.out.println("Do you wish to purchase?");
                    String response = scnr.next();
                    if (!response.equalsIgnoreCase("yes")){
                        System.out.println("Sorry, please come again");
                        break;
                    } else {
                        itr.remove();
                        animalCount.remove(tempMam.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business");
                    }
                }
            }
        } else if (choice == 2){
            Bird.birdBuy(birdStock);
            String chosenBird = scnr.next().trim();
            Iterator<Bird> itr = birdStock.iterator();
            while (itr.hasNext()){
                Bird tempBird = itr.next();
                if (tempBird.getBirdType().equalsIgnoreCase(chosenBird)){
                    System.out.println("The price of this Bird is $" + tempBird.getPrice());
                    System.out.println("Do you wish to purchase?");
                    String response = scnr.next();
                    if (!response.equalsIgnoreCase("yes")){
                        System.out.println("Sorry, please come again");
                        break;
                    } else {
                        itr.remove();
                        animalCount.remove(tempBird.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business");
                    }
                }
            }
        } else if (choice == 1){
            Reptile.reptileBuy(reptileStock);
            String chosenReptile = scnr.next().trim();
            Iterator<Reptile> itr = reptileStock.iterator();
            while (itr.hasNext()){
                Reptile tempReptile = itr.next();
                if (tempReptile.getReptileType().equalsIgnoreCase(chosenReptile)){
                    System.out.println("The price of this Reptile is $" + tempReptile.getPrice());
                    System.out.println("Do you wish to purchase?");
                    String response = scnr.next();
                    if (!response.equalsIgnoreCase("yes")){
                        System.out.println("Sorry, please come again");
                        break;
                    } else {
                        itr.remove();
                        animalCount.remove(tempReptile.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business");
                    }
                }
            }
        }
    } // inititateAdopt()
    public void initiateSell(Scanner scnr){
        System.out.println("What animal would you like to sell?");
        System.out.println("1. Reptile");
        System.out.println("2. Bird");
        System.out.println("3. Mammal");
        int choice = scnr.nextInt();
        if (choice == 3){
            System.out.println("What type of mammal are you bringing in?");
            String mamType = scnr.next();
            System.out.println("We can offer you the price of $100");
            System.out.println("Accept of Deny:");
            String response = scnr.next();
            if (!response.equalsIgnoreCase("accept")){
                System.out.println("Sorry, please come again");
            } else {
                Mammal mammal5 = new Mammal();
                System.out.println("What is the age, weight, and color of your mammal?");
                int mAge = scnr.nextInt();
                int mWeight = scnr.nextInt();
                String mColor = scnr.next();
                mammal5.setMammalType(mamType);
                mammal5.setAge(mAge);
                mammal5.setWeight(mWeight);
                mammal5.setFurColor(mColor);
                mammal5.setPrice(100);
                mammal5.setId(Animal.getNumAnimals());
                mammalStock.add(mammal5);
                animalCount.put(mammal5.getId(), mammal5);
                System.out.println("Thank you for your business!");
            } 
        } else if (choice == 2){
            System.out.println("What type of bird are you bringing in?");
            String bType = scnr.next();
            System.out.println("We can offer you the price of $25");
            System.out.println("Accept of Deny:");
            String response = scnr.next();
            if (!response.equalsIgnoreCase("accept")){
                System.out.println("Sorry, please come again");
            } else {
                Bird bird5 = new Bird();
                System.out.println("What is the age, weight, and color of your bird?");
                int bAge = scnr.nextInt();
                int bWeight = scnr.nextInt();
                String bColor = scnr.next();
                bird5.setBirdType(bType);
                bird5.setAge(bAge);
                bird5.setWeight(bWeight);
                bird5.setFeatherColor(bColor);
                bird5.setPrice(25);
                bird5.setId(Animal.getNumAnimals());
                birdStock.add(bird5);
                animalCount.put(bird5.getId(), bird5);
                System.out.println("Thank you for your business!");
            } 
        } else if (choice == 1){
            System.out.println("What type of reptile are you bringing in?");
            String repType = scnr.next();
            System.out.println("We can offer you the price of $50");
            System.out.println("Accept of Deny:");
            String response = scnr.next();
            if (!response.equalsIgnoreCase("accept")){
                System.out.println("Sorry, please come again");
            } else {
                Reptile reptile5 = new Reptile();
                System.out.println("What is the age, weight, and color of your bird?");
                int rAge = scnr.nextInt();
                int rWeight = scnr.nextInt();
                String rColor = scnr.next();
                reptile5.setReptileType(repType);
                reptile5.setAge(rAge);
                reptile5.setWeight(rWeight);
                reptile5.setScalesColor(rColor);
                reptile5.setPrice(50);
                reptile5.setId(Animal.getNumAnimals());
                reptileStock.add(reptile5);
                animalCount.put(reptile5.getId(), reptile5);
                System.out.println("Thank you for your business!");
            } 
        } 
    } // inititateSell()
    public void initiateExchange(Scanner scnr){
        System.out.println("What type of animal are you bringing in?");
        String animalTypes[] = {"Reptile", "Bird", "Mammal"};
        for (String animal : animalTypes){
            System.out.println(animal);
        }
        String response = scnr.next();
        if (response.equalsIgnoreCase("Mammal")){
            System.out.println("What type of mammal are you bringing?");
            String mamType = scnr.next();
            Mammal mammal5 = new Mammal();
            System.out.println("What is the age, weight, and color of your mammal?");
            int mAge = scnr.nextInt();
            double mWeight = scnr.nextDouble();
            String mColor = scnr.next();
            mammal5.setMammalType(mamType);
            mammal5.setAge(mAge);
            mammal5.setWeight(mWeight);
            mammal5.setFurColor(mColor);
            mammal5.setPrice(100);
            mammal5.setId(Animal.getNumAnimals());
            mammalStock.add(mammal5);
            animalCount.put(mammal5.getId(), mammal5);
            System.out.println("Mammals are worth $100");;
            System.out.println("Would you like to exchange for:");
            System.out.println("1. Mammal and no credit");
            System.out.println("2. Reptile and $50 credit");
            System.out.println("3. Bird and $75 credit");
            int response2 = scnr.nextInt();
            if (response2 == 1){
                Mammal.mammalBuy(mammalStock);
                String chosenMammal = scnr.next().trim();
                Iterator<Mammal> itr = mammalStock.iterator();
                while (itr.hasNext()){
                    Mammal tempMam = itr.next();
                    if (tempMam.getMammalType().equalsIgnoreCase(chosenMammal)){
                        itr.remove();
                        animalCount.remove(tempMam.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business!");
                    }
                }
            } else if (response2 == 3){
                Bird.birdBuy(birdStock)  ;
                String chosenBird = scnr.next().trim();
                Iterator<Bird> itr = birdStock.iterator();
                while (itr.hasNext()){
                    Bird tempBird = itr.next();
                    if (tempBird.getBirdType().equalsIgnoreCase(chosenBird)){
                        itr.remove();
                        animalCount.remove(tempBird.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(75);
                        System.out.println("You now have a $" + getCredit() + " credit");
                        System.out.println("Thank you for your business!");
                    }
                }
            } else if (response2 == 2){
                Reptile.reptileBuy(reptileStock);
                String chosenReptile = scnr.next().trim();
                Iterator<Reptile> itr = reptileStock.iterator();
                while (itr.hasNext())  {
                    Reptile tempReptile = itr.next();
                    if (tempReptile.getReptileType().equalsIgnoreCase(chosenReptile)){
                        itr.remove();
                        animalCount.remove(tempReptile.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(50);
                        System.out.println("You now have a $" + getCredit() + " credit");
                        System.out.println("Thank you for your business!");
                    }
                }
            } 
        } else if (response.equalsIgnoreCase("Bird")){
            System.out.println("What type of bird are you bringing in?");   
            String birdType = scnr.next();
            Bird bird5 = new Bird();
            System.out.println("What is the age, weight, and color of your bird?");
            int bAge = scnr.nextInt();
            double bWeight = scnr.nextDouble();
            String bColor = scnr.next();
            bird5.setBirdType(birdType);
            bird5.setAge(bAge);
            bird5.setWeight(bWeight);
            bird5.setFeatherColor(bColor);
            bird5.setPrice(25);
            bird5.setId(Animal.getNumAnimals());
            birdStock.add(bird5);
            animalCount.put(bird5.getId(), bird5);
            System.out.println("Birds are worth $25");
            System.out.println("Would you like to exchange for:");
            System.out.println("1. Mammal and pay $75");
            System.out.println("2. Reptile and pay $25");
            System.out.println("3. Bird and pay/receive no credit");
            int response2 = scnr.nextInt();
            if (response2 == 1){
                Mammal.mammalBuy(mammalStock);
                String chosenMammal = scnr.next().trim();
                Iterator<Mammal> itr = mammalStock.iterator();
                while (itr.hasNext()){
                    Mammal tempMam = itr.next();
                    if (tempMam.getMammalType().equalsIgnoreCase(chosenMammal)){
                        itr.remove();
                        animalCount.remove(tempMam.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(getCredit() - 75);
                        System.out.println("A " + getCredit() + " charge is added to your account. Thank you for your business!");
                    }
                }
            } else if (response2 == 3){
                Bird.birdBuy(birdStock) ;
                String chosenBird = scnr.next().trim();
                Iterator<Bird> itr = birdStock.iterator();
                while (itr.hasNext())  {
                    Bird tempBird = itr.next();
                    if (tempBird.getBirdType().equalsIgnoreCase(chosenBird)){
                        itr.remove();
                        animalCount.remove(tempBird.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business!");
                    }
                }
            } else if (response2 == 2){
                Reptile.reptileBuy(reptileStock) ;
                String chosenReptile = scnr.next().trim();
                Iterator<Reptile> itr = reptileStock.iterator();
                while (itr.hasNext())  {
                    Reptile tempReptile = itr.next();
                    if (tempReptile.getReptileType().equalsIgnoreCase(chosenReptile)){
                        itr.remove();
                        animalCount.remove(tempReptile.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(getCredit() - 25);
                        System.out.println("You now have a $" + getCredit() + " charge to your account");
                        System.out.println("Thank you for your business!");
                    }
                }
            } 
        } else if (response.equalsIgnoreCase("Reptile")){
            System.out.println("What type of reptile are you bringing in?");   
            String reptileType = scnr.next();
            Reptile reptile5 = new Reptile();
            System.out.println("What is the age, weight, and color of your reptile?");
            int rAge = scnr.nextInt();
            double rWeight = scnr.nextDouble();
            String rColor = scnr.next();
            reptile5.setReptileType(reptileType);
            reptile5.setAge(rAge);
            reptile5.setWeight(rWeight);
            reptile5.setScalesColor(rColor);
            reptile5.setPrice(50);
            reptile5.setId(Animal.getNumAnimals());
            reptileStock.add(reptile5);
            animalCount.put(reptile5.getId(), reptile5);
            System.out.println("Reptiles are woth $50");
            System.out.println("Would you like to exchange for:");
            System.out.println("1. Mammal and pay $50");
            System.out.println("2. Reptile and pay/receive no credit");
            System.out.println("3. Bird and receive $25");
            int response3 = scnr.nextInt();
            if (response3 == 1){
                Mammal.mammalBuy(mammalStock);
                String chosenMammal = scnr.next().trim();
                Iterator<Mammal> itr = mammalStock.iterator();
                while (itr.hasNext()){
                    Mammal tempMam = itr.next();
                    if (tempMam.getMammalType().equalsIgnoreCase(chosenMammal)){
                        itr.remove();
                        animalCount.remove(tempMam.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(getCredit() - 50);
                        System.out.println("A " + getCredit() + " charge is added to your account. Thank you for your business!");
                    }
                }
            } else if (response3 == 3){
                Bird.birdBuy(birdStock) ;
                String chosenBird = scnr.next().trim();
                Iterator<Bird> itr = birdStock.iterator();
                while (itr.hasNext())  {
                    Bird tempBird = itr.next();
                    if (tempBird.getBirdType().equalsIgnoreCase(chosenBird)){
                        itr.remove();
                        animalCount.remove(tempBird.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        setCredit(25);
                        System.out.println("You have received a $" + getCredit() + " credit to your account");
                        System.out.println("Thank you for your business!");
                    }
                }
            } else if (response3 == 2){
                Reptile.reptileBuy(reptileStock) ;
                String chosenReptile = scnr.next().trim();
                Iterator<Reptile> itr = reptileStock.iterator();
                while (itr.hasNext())  {
                    Reptile tempReptile = itr.next();
                    if (tempReptile.getReptileType().equalsIgnoreCase(chosenReptile)){
                        itr.remove();
                        animalCount.remove(tempReptile.getId());
                        Animal.setNumAnimals(Animal.getNumAnimals() - 1);
                        System.out.println("Thank you for your business!");
                    }
                }
            } 
        }
    } // initiateExchange()

    public void welcome() {
        System.out.println("Welcome to the Pet Shop! Are you here to: ");
        System.out.println("1. Adopt");
        System.out.println("2. Sell");
        System.out.println("3. Exchange");
        int choice = scnr.nextInt();
        if (choice == 1) {
            initiateAdopt(scnr);
        } else if (choice == 2) {
            initiateSell(scnr);
        } else if (choice == 3) {
            initiateExchange(scnr);
        } else {
            System.out.println("thanks for stopping by!");
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.populateMammal();
        shop.populateBird();
        shop.populateReptile();
        shop.welcome();
        System.out.println(Animal.getNumAnimals());
    }
} // The end
