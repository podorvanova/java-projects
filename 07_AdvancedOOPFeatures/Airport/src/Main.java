import com.skillbox.airport.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 2);
        System.out.println("Время в данный момент " + formatter.format(startTime.getTime()));

        Airport airport = Airport.getInstance();
        List<Terminal> terminals = airport.getTerminals();
        terminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL) && flight.getDate().after(startTime.getTime()) && flight.getDate().before(endTime.getTime()))
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(flight -> System.out.println(flight.getAircraft() + " вылетает в " + formatter.format(flight.getDate())));
    }
}
