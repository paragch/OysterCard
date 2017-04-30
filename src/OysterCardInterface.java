import java.util.*;
import java.io.*;
import java.nio.*;

/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class OysterCardInterface {



    public static void main(String args[])
    {

        Map<String, ArrayList<Zone>> map = new HashMap<String, ArrayList<Zone>>();

        ReadPropertiesFile fileLoader= new ReadPropertiesFile();
        map = fileLoader.readFile();

        int count = args.length;
        ArrayList<Journey> journeyWrapper = new ArrayList<>();
        FareCalculation fareCalc = new FareCalculation();


            for(int i=0;i<args.length;i=i+3)
            {

                String journeyType = args[i];
                String fromJourney = args[i+1];
                String toJourney = args[i+2];

                Station fromStation = new Station(fromJourney,map.get(fromJourney));
                Station toStation = new Station(toJourney,map.get(toJourney));


                Journey myJourney ;
                if(journeyType.equals("B")) {
                    myJourney = new Journey(fromStation, toStation, JourneyType.BUS);
                }
                else{
                    myJourney = new Journey(fromStation, toStation, JourneyType.TRAIN);
                }

                journeyWrapper.add(myJourney);
            }




        System.out.println("The fare for the journey is....£" + fareCalc.calculateFare(journeyWrapper));
    }


}
