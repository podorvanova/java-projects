import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    RouteCalculator myRouteCalculator;
    StationIndex myStationIndex;

    @Override
    protected void setUp() throws Exception {
        myStationIndex = new StationIndex();
        myRouteCalculator = new RouteCalculator(myStationIndex);

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        myStationIndex.addLine(line1);
        myStationIndex.addLine(line2);
        myStationIndex.addLine(line3);

        Station station1 = new Station("Петроградская", line2);
        Station station2 = new Station("Горьковская", line2);
        Station station3 = new Station("Невский Проспект", line2);
        Station station4 = new Station("Гостиный Двор", line3);
        Station station5 = new Station("Маяковская", line3);
        Station station6 = new Station("Площадь Александра Невского 1", line3);
        Station station7 = new Station("Площадь Восстания", line1);
        Station station8 = new Station("Чернышевская", line1);

        line1.addStation(station7);
        line1.addStation(station8);

        line2.addStation(station1);
        line2.addStation(station2);
        line2.addStation(station3);

        line3.addStation(station4);
        line3.addStation(station5);
        line3.addStation(station6);

        myStationIndex.addStation(station1);
        myStationIndex.addStation(station2);
        myStationIndex.addStation(station3);
        myStationIndex.addStation(station4);
        myStationIndex.addStation(station5);
        myStationIndex.addStation(station6);
        myStationIndex.addStation(station7);
        myStationIndex.addStation(station8);

        myStationIndex.addConnection(new ArrayList<Station>() {{
            add(station3);
            add(station4);
        }});
        myStationIndex.addConnection(new ArrayList<Station>() {{
            add(station5);
            add(station7);
        }});
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(new ArrayList<Station>() {{
                add(myStationIndex.getStation("Петроградская"));
                add(myStationIndex.getStation("Горьковская"));
                add(myStationIndex.getStation("Невский Проспект"));
                add(myStationIndex.getStation("Гостиный Двор"));
                add(myStationIndex.getStation("Маяковская"));
            }});
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute_OnTheLine() {
        List<Station> actual = myRouteCalculator.getShortestRoute(
                myStationIndex.getStation("Петроградская"),
                myStationIndex.getStation("Невский Проспект")
        );
        List<Station> expected = new ArrayList<>();
        expected.add(myStationIndex.getStation("Петроградская"));
        expected.add(myStationIndex.getStation("Горьковская"));
        expected.add(myStationIndex.getStation("Невский Проспект"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute_OneConnection() {
        List<Station> actual = myRouteCalculator.getShortestRoute(
                myStationIndex.getStation("Петроградская"),
                myStationIndex.getStation("Площадь Александра Невского 1")
        );
        List<Station> expected = new ArrayList<>();
        expected.add(myStationIndex.getStation("Петроградская"));
        expected.add(myStationIndex.getStation("Горьковская"));
        expected.add(myStationIndex.getStation("Невский Проспект"));
        expected.add(myStationIndex.getStation("Гостиный Двор"));
        expected.add(myStationIndex.getStation("Маяковская"));
        expected.add(myStationIndex.getStation("Площадь Александра Невского 1"));
        assertEquals(expected, actual);
    }

     public void testGetShortestRoute_TwoConnections() {
        List<Station> actual = myRouteCalculator.getShortestRoute(
                myStationIndex.getStation("Петроградская"),
                myStationIndex.getStation("Чернышевская")
        );
        List<Station> expected = new ArrayList<>();
        expected.add(myStationIndex.getStation("Петроградская"));
        expected.add(myStationIndex.getStation("Горьковская"));
        expected.add(myStationIndex.getStation("Невский Проспект"));
        expected.add(myStationIndex.getStation("Гостиный Двор"));
        expected.add(myStationIndex.getStation("Маяковская"));
        expected.add(myStationIndex.getStation("Площадь Восстания"));
        expected.add(myStationIndex.getStation("Чернышевская"));
        assertEquals(expected, actual);
     }

     public void testGetShortestRoute_ReverseMoving() {
        List<Station> actual = myRouteCalculator.getShortestRoute(
                myStationIndex.getStation("Площадь Александра Невского 1"),
                myStationIndex.getStation("Гостиный Двор")
        );
        List<Station> expected = new ArrayList<>();
        expected.add(myStationIndex.getStation("Площадь Александра Невского 1"));
        expected.add(myStationIndex.getStation("Маяковская"));
        expected.add(myStationIndex.getStation("Гостиный Двор"));
        assertEquals(expected, actual);
     }
}