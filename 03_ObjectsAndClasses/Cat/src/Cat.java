
public class Cat
{
    public static int count = 0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

    }

    public void meow()
    {
        if (weight >= minWeight && weight <= maxWeight) {
            weight = weight - 1;
            System.out.println("Meow");
        }
            if (weight < minWeight) {
            count--;
        }
    }

    public void feed(Double amount)
    {
        if (weight >= minWeight && weight <= maxWeight) {
            weight = weight + amount;
        }
        if (weight > maxWeight) {
            count--;
        }
    }

    public void drink(Double amount)
    {
        if (weight >= minWeight && weight <= maxWeight) {
            weight = weight + amount;
        }
        if (weight > maxWeight) {
            count--;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
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
        double foodAmount = weight - originWeight;
        return foodAmount;
    }
    public void pee() {
        if (weight >= minWeight && weight <= maxWeight) {
            weight = weight - 0.6;
            System.out.println("Clean up after yourself");
        }
        if (weight < minWeight) {
            count--;
        }
    }
    public static int getCount() {
        return count;
    }
}