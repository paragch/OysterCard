import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class FareCalculationTest {


    private Station fromStation;
    private Station toStation;
    private Station fromStation1;
    private Station toStation1;
    private List<Zone> zoneList;
    private List<Zone> zoneList1;
    private List<Zone> zoneList2;
    private Journey testJourney;
    private Journey testJourney1;
    private JourneyType journeyType;
    private JourneyType journeyType1;
    private ArrayList<Journey> myJourneys;
    private FareCalculation fareCalc ;

    @Before
    public void setUp() throws Exception {
        zoneList = new ArrayList();
        zoneList1 = new ArrayList();
        zoneList2 = new ArrayList();
        zoneList.add(Zone.ONE);
        zoneList1.add(Zone.TWO);
        zoneList2.add(Zone.THREE);
        fromStation = new Station("Hammersmith",zoneList1);
        toStation = new Station("Holborn",zoneList);
        toStation1 = new Station("Wimbledon",zoneList2);
        fromStation1 = new Station("Holborn",zoneList);
        journeyType = JourneyType.BUS;
        journeyType1= JourneyType.TRAIN;
        testJourney = new Journey(fromStation,toStation,journeyType);
        testJourney1 = new Journey(fromStation1,toStation1,journeyType1);
        myJourneys = new ArrayList();
        myJourneys.add(testJourney);
        myJourneys.add(testJourney1);

        fareCalc = new FareCalculation();

    }

    @Test
    public void testCalculateFare() throws Exception {

        assertEquals(fareCalc.calculateFare(myJourneys),3.8);
        assertNotEquals(fareCalc.calculateFare(myJourneys),1.8);

    }
}