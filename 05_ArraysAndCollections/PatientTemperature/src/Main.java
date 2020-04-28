import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] patientsTemperature = new double[30];

        DecimalFormat df = new DecimalFormat("#.#");

        for (int i = 0; i < patientsTemperature.length; i++) {
            patientsTemperature[i] = Double.parseDouble(df.format(32 + (double) 8 * Math.random()));
        }

        System.out.println(Arrays.toString(patientsTemperature));

        System.out.println("Средняя температура: " + df.format(averageTemperature(patientsTemperature)));

        System.out.println("Количество здоровых пациентов: " + numOfHealthyPatients(patientsTemperature));
    }

    public static double averageTemperature(double[] arrayOfTemperature) {
        double sumTemperature = 0.0;
        for (double patient : arrayOfTemperature) {
            sumTemperature += patient;
        }
        return sumTemperature / arrayOfTemperature.length;
    }

    public static int numOfHealthyPatients(double[] arrayOfTemperature) {
        int count = 0;
        for (double patient : arrayOfTemperature) {
            if (patient >= 36.2 && patient <= 36.9) {
                count++;
            }
        }
        return count;
    }
}