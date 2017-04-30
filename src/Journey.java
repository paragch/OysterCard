/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class Journey {


    private Station fromStation;
    private Station toStation;
    private JourneyType journeyType;


    public Station getFromStation() {
        return fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }


    public Journey(Station fromStation,Station toStation,JourneyType journeyType)
    {
        this.fromStation= fromStation;
        this.toStation= toStation;
        this.journeyType= journeyType;

    }

}
