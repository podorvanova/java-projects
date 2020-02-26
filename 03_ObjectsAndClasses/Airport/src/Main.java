import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> aircrafts = airport.getAllAircrafts();
        Terminal firstTerminal = airport.getTerminals().get(0);

        System.out.println(aircrafts);
        System.out.println("Число самолетов в аэропорту: " + aircrafts.size());
        System.out.println(airport.getTerminals().size());
        System.out.println("Первый терминал: " + firstTerminal.getName());
        System.out.println("Вылеты в первом терминале: " + firstTerminal.getFlights());
    }
}
