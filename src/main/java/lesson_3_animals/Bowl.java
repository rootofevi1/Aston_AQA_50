package lesson_3_animals;

public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        if (initialFood < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = initialFood;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Added to the bowl " + amount + " food. Now in bowl " + foodAmount + " food");
        } else {
            System.out.println("You cannot add a negative amount of food.");
        }
    }

    public void decreaseFood(int amount) {
        if (amount > 0 && amount <= foodAmount) {
            foodAmount -= amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void displayFoodAmount() {
        System.out.println("In bowl " + foodAmount + " food");
    }
}
