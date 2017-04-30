import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class JourneyTest {

    private Station fromStation;
    private Station toStation;
    private List<Zone> zoneList;
    private Journey testJourney;
    private JourneyType journeyType;

    @Before
    public void setUp() throws Exception {
        zoneList = new ArrayList();
        zoneList.add(Zone.ONE);
        zoneList.add(Zone.TWO);
        fromStation = new Station("Victoria",zoneList);
        toStation = new Station("Holborn",zoneList);
        journeyType = JourneyType.BUS;
        testJourney = new Journey(fromStation,toStation,journeyType);
    }

    @Test
    public void testGetFromStation() throws Exception {
        assertEquals(fromStation.getStationName(),"Victoria");
        assertNotEquals(fromStation.getStationName(),"Kings Cross");

    }

    @Test
    public void testGetToStation() throws Exception {
        assertEquals(toStation.getStationName(),"Holborn");
        assertNotEquals(toStation.getStationName(),"Kings Cross");
    }

    @Test
    public void testGetJourneyType() throws Exception {
        assertEquals(journeyType,JourneyType.BUS);
        assertNotEquals(journeyType,JourneyType.TRAIN);
    }
}