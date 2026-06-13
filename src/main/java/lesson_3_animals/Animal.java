package lesson_3_animals;

public abstract class Animal {

    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " run " + distance + " м.");
        } else {
            System.out.println(name + " can't run " + distance + " m. (max " + runLimit + " m.)");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " can't swim");
        } else if (distance <= swimLimit) {
            System.out.println(name + " swim " + distance + " м.");
        } else {
            System.out.println(name + " can't swim " + distance + " m. (max " + swimLimit + " m.)");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}
