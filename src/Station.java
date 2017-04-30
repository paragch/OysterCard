/**
 * Created by paragchatterjee on 01/03/2017.
 */

import java.util.*;

public class Station {

    private final String stationName;

    private List<Zone> zones = new ArrayList<Zone>();


    public String getStationName() {
        return stationName;
    }

    public Station(String stationName, List zoneList)
    {
        this.stationName = stationName;
        this.zones = zoneList;
    }

    public List<Zone> getZones() {return zones;};


}
