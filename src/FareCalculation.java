/**
 * Created by paragchatterjee on 01/03/2017.
 */

import java.util.*;

public class FareCalculation {


    private String fareDetails[]=  new String[]{"2.50","2.00","3.00","2.25","3.20","1.80"};
    private Map<String, Integer> fromMap = new HashMap<>();
    private Map<String, Integer> toMap = new HashMap<>();
    private int busJourneys =0;
    private double totalFare =0;
    private double trainFare;
    private int zoneOneCount=0;
    private int zoneTwoCount=0;
    private int zoneThreeCount=0;

    public double calculateFare(ArrayList<Journey> myJourneys){

        totalFare= multipleJourneyCalculator(myJourneys) + getTrainFares();

        return totalFare;
    }

    private double getTrainFares(){

        if(((zoneOneCount+zoneTwoCount+zoneThreeCount)==2)){


            trainFare =
                    (zoneOneCount==2)? Double.parseDouble(fareDetails[0]): (zoneOneCount==1)? Double.parseDouble(fareDetails[1]):Double.parseDouble(fareDetails[3]);

            return trainFare;

        }

        if((zoneTwoCount>0)&&(zoneThreeCount>0))
        {
            if(zoneOneCount>0)
            {
                trainFare =  Double.parseDouble(fareDetails[4]);
            }
            else
            {
                trainFare = Double.parseDouble(fareDetails[3]);
            }
            return trainFare;
        }


        if((zoneOneCount>0)&&((zoneTwoCount>0)||(zoneThreeCount>0))){

            trainFare= Double.parseDouble(fareDetails[2]);
            return trainFare;
        }

        return trainFare;

    }

    private Zone getZone(Station myStation)
    {
        int zoneNumber =myStation.getZones().size();
        return myStation.getZones().get(zoneNumber-1);
    }




    private double multipleJourneyCalculator(ArrayList<Journey> myJourneys) {

        double totalFare=0;
        int fromCount=0;

        myJourneys.forEach(myJourney->{
            if (myJourney.getJourneyType().equals(JourneyType.BUS)) {
                busJourneys++;

            }

            if(!myJourney.getJourneyType().equals(JourneyType.BUS)) {

                Station journeyStation = myJourney.getFromStation();
                filterStationCount(journeyStation);

            }

        });

        myJourneys.forEach(myJourney->{

            if(!myJourney.getJourneyType().equals(JourneyType.BUS)) {

                Station journeyStation = myJourney.getToStation();

                filterStationCount(journeyStation);


            }

        });

        if(busJourneys>0){
            double value = Double.parseDouble(fareDetails[5]);
            totalFare = totalFare + busJourneys*value;
        }

        return totalFare;

    }

    private void filterStationCount(Station journeyStation)
    {

        for (Zone z : Zone.values()) {


            if (z.equals(getZone(journeyStation))) {

                if (getZone(journeyStation).equals(Zone.ONE)) {
                    zoneOneCount++;
                }
                if (getZone(journeyStation).equals(Zone.TWO)) {
                    zoneTwoCount++;
                }
                if (getZone(journeyStation).equals(Zone.THREE)) {
                    zoneThreeCount++;
                }
            }

        }
    }

}
