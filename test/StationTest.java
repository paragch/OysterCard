import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static junit.framework.Assert.*;
import static org.junit.Assert.*;

/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class StationTest {

    private List<Zone> zoneList;
    private String stationName;
    private Station testStation;

    @Before
    public void setUp() throws Exception {
        zoneList = new ArrayList();
        zoneList.add(Zone.ONE);
        zoneList.add(Zone.TWO);
        stationName = "Victoria";
        testStation= new Station(stationName,zoneList);

    }



    @Test
    public void testGetStationName() throws Exception {

        assertEquals(stationName,"Victoria");
        assertNotEquals(stationName,"Kings Cross");
    }

    @Test
    public void testGetZones() throws Exception {

        List<Zone> categories = new ArrayList();
        categories.add(Zone.ONE);
        categories.add(Zone.TWO);
        assertArrayEquals(zoneList.toArray(), categories.toArray());
        categories.add(Zone.THREE);
        assertNotEquals(zoneList,categories);

    }
}