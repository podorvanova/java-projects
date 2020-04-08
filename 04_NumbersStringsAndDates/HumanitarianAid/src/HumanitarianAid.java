public class HumanitarianAid {
    //Количество коробок в одном грузовике
    private static final int BOXES_IN_ONE_TRUCK = 27 * 12;

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

        int truckAmount = divideAndRoundUp(xBox, BOXES_IN_ONE_TRUCK);
        System.out.println("Необходимое количество грузовиков " + truckAmount);

        int containerAmount = divideAndRoundUp(xBox, 27);
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
