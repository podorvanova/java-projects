
public class Cat
{
    public static int count = 0;

    private double originWeight;
    private double weight;

    public static final int EYES_COUNT = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;
    private double foodAmount = 0.0;

    private CatColor catColor;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;

    }

    //Конструктор копирования
    public Cat(Cat other) {
        this.weight = other.weight;
        this.originWeight = other.originWeight;
        this.catColor = other.catColor;
        if (isAlive()) {
            count++;
        }
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        this.originWeight = weight;
    }

    public Cat(double weight, double originWeight, CatColor catColor) {
        this.weight = weight;
        this.originWeight = weight;
        this.catColor = catColor;
        if (isAlive()) {
            count++;
        }
    }

    //Метод копирования
    public Cat copy() {
        return new Cat(this.getWeight(), this.originWeight, this.getColor());
    }

    private boolean isAlive() {
        return weight >= MIN_WEIGHT && weight <= MAX_WEIGHT;
    }

    public void meow()
    {
        if (isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
            if (weight < MIN_WEIGHT) {
                count--;
            }
        }
    }

    public void feed(Double amount)
    {
        if (isAlive()) {
            weight = weight + amount;
            foodAmount += amount;
        }
        if (weight > MAX_WEIGHT) {
            count--;
        }
    }

    public void drink(Double amount)
    {
        if (isAlive()) {
            weight = weight + amount;
        }
        if (weight > MAX_WEIGHT) {
            count--;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public double getFoodAmount() {
        return foodAmount;
    }
    public void pee() {
        if (isAlive()) {
            weight = weight - 0.6;
            System.out.println("Clean up after yourself");
        }
        if (weight < MIN_WEIGHT) {
            count--;
        }
    }
    public static int getCount() {
        return count;
    }
    public void setColor(CatColor catColor) {
        this.catColor = catColor;
    }
    public CatColor getColor() {
        return catColor;
    }
}