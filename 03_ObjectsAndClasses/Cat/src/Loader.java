
public class Loader
{
    public static void main(String[] args)
    {
        //Создание семи кошек
        Cat[] cat = new Cat[7];
        for (int i = 0; i <=6; i++) {
            cat[i] = new Cat();
            //Вес семи кошек
            System.out.print("Cat " + (i + 1) + " weight is ");
            System.out.println(cat[i].getWeight());
        }
        System.out.println("----------------------------------");

        //Эксперименты с разными методами
        System.out.print("Status Cat 1 is ");
        System.out.println(cat[0].getStatus());
        System.out.print("Cat 2 says ");
        cat[1].meow();
        cat[2].drink(20.0);
        System.out.println("Cat 3 is drinking");
        System.out.print("Cat 3 weight is ");
        System.out.println(cat[2].getWeight());
        System.out.println("----------------------------------");

        //Кормление двух кошек и проверка изменения их весов
        for (int i = 3; i < 5; i++) {
            System.out.print("Cat " + (i + 1) + " weight is ");
            System.out.println(cat[i].getWeight());
            cat[i].feed(50.0);
            System.out.print("Cat " + (i + 1) + " weight is ");
            System.out.println(cat[i].getWeight());
        }
        System.out.println("----------------------------------");

        //Перекормленная кошка
        System.out.print("Cat 6 weight is ");
        System.out.println(cat[5].getWeight());
        for (int i = 0; ; i++) {
            cat[5].feed(1.0);
            if (cat[5].getStatus().equals("Exploded")) {
                break;
            }
        }
        System.out.print("Cat 6 weight is ");
        System.out.println(cat[5].getWeight());
        System.out.print("Status Cat 6 is ");
        System.out.println(cat[5].getStatus());
        System.out.println("----------------------------------");

        //Кошка, замяуканная до смерти
        System.out.print("Cat 7 weight is ");
        System.out.println(cat[6].getWeight());
        for (int i = 1; ; i++) {
            cat[6].meow();
            if (cat[6].getStatus().equals("Dead")) {
                break;
            }
        }
        System.out.print("Cat 7 weight is ");
        System.out.println(cat[6].getWeight());
        System.out.print("Status Cat 7 is ");
        System.out.println(cat[6].getStatus());
    }
}