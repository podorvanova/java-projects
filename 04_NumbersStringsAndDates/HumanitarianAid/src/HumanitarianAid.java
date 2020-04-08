import static java.lang.Math.*;

public class HumanitarianAid {
    //Количество коробок в одном грузовике
    private static final int BOXES_IN_ONE_TRUCK = 27 * 12;
    //Количество коробок в одном контейнере
    private static final int BOXES_IN_ONE_CONTAINER = 27;

    public static int divideAndRoundUp(int dividend, int divider) {
        if (dividend % divider != 0) {
            return dividend / divider + 1;
        } else {
            return dividend / divider;
        }
    }

    public static void main(String[] args) {
        //Количество коробок
        int xBox = 325;
        //Номер текущей коробки
        int boxIndex = 1;
        //Номер текущего контейнера
        int containerIndex = 1;

        int truckAmount = (int) Math.ceil((double) xBox / BOXES_IN_ONE_TRUCK);
        System.out.println("Необходимое количество грузовиков " + truckAmount);

        int containerAmount = (int) Math.ceil((double) xBox / BOXES_IN_ONE_CONTAINER);
        System.out.println("Необходимое количество контейнеров " + containerAmount);

        for (int truck = 1; truck <= truckAmount; truck++) {
            System.out.println("Грузовик: " + truck + ':');

            for (int container = 1; container <= 12; container++) {
                System.out.println('\t' + "Контейнер " + containerIndex + ':');

                for (int box = 1; box <= 27; box++) {
                    System.out.println("\t\t" + "Ящик " + boxIndex);
                    if (boxIndex == xBox) {
                        break;
                    }
                    boxIndex++;
                }
                if (containerIndex == containerAmount) {
                    break;
                }
                containerIndex++;
            }
        }
    }
}
