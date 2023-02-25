import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747",
            980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        Assert.assertEquals(transportMilitaryPlanes.toString(), "[Plane{model='C-130 Hercules', maxSpeed=650, " +
                "maxFlightDistance=5000, maxLoadCapacity=110000, type=TRANSPORT}]");
    }

    @Test
    public void testGetMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> militaryPlanes = airport.getMilitaryPlanes();
        Assert.assertEquals(militaryPlanes.toString(),"[Plane{model='B-1B Lancer', maxSpeed=1050, " +
                "maxFlightDistance=21000, maxLoadCapacity=80000, type=BOMBER}, Plane{model='B-2 Spirit', " +
                "maxSpeed=1030, maxFlightDistance=22000, maxLoadCapacity=70000, type=BOMBER}, Plane{model='B-52 " +
                "Stratofortress', maxSpeed=1000, maxFlightDistance=20000, maxLoadCapacity=80000, type=BOMBER}, " +
                "Plane{model='F-15', maxSpeed=1500, maxFlightDistance=12000, maxLoadCapacity=10000, type=FIGHTER}, " +
                "Plane{model='F-22', maxSpeed=1550, maxFlightDistance=13000, maxLoadCapacity=11000, type=FIGHTER}, " +
                "Plane{model='C-130 Hercules', maxSpeed=650, maxFlightDistance=5000, maxLoadCapacity=110000, " +
                "type=TRANSPORT}]");
    }

    @Test
    public void testGetPassengerPlanes() {
        Airport airport = new Airport(planes);
        List<PassengerPlane> passengerPlanes = airport.getPassengerPlanes();
        Assert.assertEquals(passengerPlanes.toString(),"[Plane{model='Boeing-737', maxSpeed=900, " +
                "maxFlightDistance=12000, maxLoadCapacity=60500, passengersCapacity=164}, " +
                "Plane{model='Boeing-737-800', maxSpeed=940, maxFlightDistance=12300, maxLoadCapacity=63870, " +
                "passengersCapacity=192}, Plane{model='Boeing-747', maxSpeed=980, maxFlightDistance=16100, " +
                "maxLoadCapacity=70500, passengersCapacity=242}, Plane{model='Airbus A320', maxSpeed=930, " +
                "maxFlightDistance=11800, maxLoadCapacity=65500, passengersCapacity=188}, Plane{model='Airbus A330', " +
                "maxSpeed=990, maxFlightDistance=14800, maxLoadCapacity=80500, passengersCapacity=222}, " +
                "Plane{model='Embraer 190', maxSpeed=870, maxFlightDistance=8100, maxLoadCapacity=30800, " +
                "passengersCapacity=64}, Plane{model='Sukhoi Superjet 100', maxSpeed=870, maxFlightDistance=11500, " +
                "maxLoadCapacity=50500, passengersCapacity=140}, Plane{model='Bombardier CS300', maxSpeed=920, " +
                "maxFlightDistance=11000, maxLoadCapacity=60700, passengersCapacity=196}]");
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertEquals(bomberMilitaryPlanes.toString(),"[Plane{model='B-1B Lancer', maxSpeed=1050, " +
                "maxFlightDistance=21000, maxLoadCapacity=80000, type=BOMBER}, Plane{model='B-2 Spirit', " +
                "maxSpeed=1030, maxFlightDistance=22000, maxLoadCapacity=70000, type=BOMBER}, " +
                "Plane{model='B-52 Stratofortress', maxSpeed=1000, maxFlightDistance=20000, " +
                "maxLoadCapacity=80000, type=BOMBER}]");
    }

    @Test
    public void testGetExperimentalPlanes(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertEquals(experimentalPlanes.toString(),"[experimentalPlane{model='Bell X-14'}, " +
                "experimentalPlane{model='Ryan X-13 Vertijet'}]");
    }

    @Test
    public void testSortByMaxSpeed() {
        Airport airport = new Airport(planes);
        airport.sortByMaxSpeed();
        List<? extends Plane> planesSortedByMaxSpeed = airport.getPlanes();
        Assert.assertEquals(new int[]{planesSortedByMaxSpeed.get(0).getMaxSpeed(),
                planesSortedByMaxSpeed.get(1).getMaxSpeed(),
                planesSortedByMaxSpeed.get(2).getMaxSpeed(),
                planesSortedByMaxSpeed.get(3).getMaxSpeed(),
                planesSortedByMaxSpeed.get(4).getMaxSpeed(),
                planesSortedByMaxSpeed.get(5).getMaxSpeed(),
                planesSortedByMaxSpeed.get(6).getMaxSpeed(),
                planesSortedByMaxSpeed.get(7).getMaxSpeed(),
                planesSortedByMaxSpeed.get(8).getMaxSpeed(),
                planesSortedByMaxSpeed.get(9).getMaxSpeed(),
                planesSortedByMaxSpeed.get(10).getMaxSpeed(),
                planesSortedByMaxSpeed.get(11).getMaxSpeed(),
                planesSortedByMaxSpeed.get(12).getMaxSpeed(),
                planesSortedByMaxSpeed.get(13).getMaxSpeed(),
                planesSortedByMaxSpeed.get(14).getMaxSpeed(),
                planesSortedByMaxSpeed.get(15).getMaxSpeed()},new int[]{277, 560, 650, 870, 870, 900, 920, 930, 940,
                980, 990, 1000, 1030, 1050, 1500, 1550});
    }

    @Test
    public void testSortByMaxDistance() {
        Airport airport = new Airport(planes);
        airport.sortByMaxDistance();
        List<? extends Plane> planesSortedByMaxDistance = airport.getPlanes();
        Assert.assertEquals(new int[]{planesSortedByMaxDistance.get(0).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(1).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(2).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(3).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(4).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(5).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(6).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(7).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(8).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(9).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(10).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(11).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(12).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(13).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(14).getMaxFlightDistance(),
                planesSortedByMaxDistance.get(15).getMaxFlightDistance()},new int[]{307, 482, 5000, 8100, 11000,
                11500, 11800, 12000, 12000, 12300, 13000, 14800, 16100, 20000, 21000, 22000});
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        Assert.assertEquals(new int[]{
                        planesSortedByMaxLoadCapacity.get(0).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(1).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(2).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(3).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(4).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(5).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(6).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(7).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(8).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(9).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(10).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(11).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(12).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(13).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(14).getMaxLoadCapacity(),
                        planesSortedByMaxLoadCapacity.get(15).getMaxLoadCapacity()},
                        new int[]{500, 500, 10000, 11000, 30800, 50500, 60500, 60700, 63870, 65500, 70000, 70500,
                        80000, 80000, 80500, 110000});
    }
}
