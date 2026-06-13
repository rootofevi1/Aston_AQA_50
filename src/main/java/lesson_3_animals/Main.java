package lesson_3_animals;

public class Main {
    public static void main(String[] args) {

        System.out.println("Running and swimming demonstration");

        Dog dogBobik = new Dog("Ponchik");
        Cat catMurzik = new Cat("Kuzya");

        dogBobik.run(150);
        dogBobik.run(550);
        dogBobik.swim(5);
        dogBobik.swim(15);

        catMurzik.run(150);
        catMurzik.run(250);
        catMurzik.swim(5);


        System.out.println("\nCounting animals");
        System.out.println("All animals: " + Animal.getAnimalCount());
        System.out.println("Dogs: " + Dog.getDogCount());
        System.out.println("Cats: " + Cat.getCatCount());

        System.out.println("\nCat feeding demonstration");

        Cat[] cats = {
                new Cat("Barsik"),
                new Cat("Boris"),
                new Cat("Tungus"),
                new Cat("Murka"),
                new Cat("Vasya")
        };

        Bowl bowl = new Bowl(30);
        bowl.displayFoodAmount();

        System.out.println("\nThe feeding process");

        int[] eatAmounts = {10, 15, 5, 20, 8};

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " trying to eat " + eatAmounts[i] + " food");
            cats[i].eatFromBowl(bowl, eatAmounts[i]);
            bowl.displayFoodAmount();
        }

        System.out.println("\nInformation about cat satiety");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + (cat.isFull() ? " well-fed" : " hungry"));
        }

        System.out.println("\nAdding food to the bowl");
        bowl.addFood(20);
        bowl.displayFoodAmount();

        System.out.println("\nFinal counting animals");
        System.out.println("All animals: " + Animal.getAnimalCount());
        System.out.println("Dogs: " + Dog.getDogCount());
        System.out.println("Cats: " + Cat.getCatCount());
    }
}
