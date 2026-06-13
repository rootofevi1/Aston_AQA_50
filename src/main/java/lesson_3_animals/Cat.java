package lesson_3_animals;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.swimLimit = 0;
        this.isFull = false;
        catCount++;
    }

    public void eatFromBowl(Bowl bowl, int amount) {
        if (!isFull && bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " ate " + amount + " food and now well-fed");
        } else if (isFull) {
            System.out.println(name + " already well-fed");
        } else {
            System.out.println(name + " didn't eat because there wasn't enough food in the bowl (needed " + amount + ", have " + bowl.getFoodAmount() + ")");
        }
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isFull() {
        return isFull;
    }
}
