import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReadPropertiesFile {


    public Map<String, ArrayList<Zone>> readFile(){

        Map<String, ArrayList<Zone>> map = new HashMap<String, ArrayList<Zone>>();
        try {

            File file = new File("src/StationsAndZones.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                StringTokenizer tokens= new StringTokenizer(value,",");
                int counter = tokens.countTokens();
                if(counter > 1)
                {
                    ArrayList<Zone> locallist = new ArrayList<Zone>();

                    for(int i=0;i<counter;i++)
                    {
                        String element = tokens.nextToken();
                        addToListConverter(element,locallist);

                    }
                    map.put(key,locallist);
                }

                if(counter == 1)
                {
                    ArrayList<Zone> locallist1 = new ArrayList<>();
                    addToListConverter(value,locallist1);

                    map.put(key,locallist1);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    private void addToListConverter(String propValue,ArrayList<Zone> locallist){

        if(propValue.equals("1")){
            locallist.add(Zone.ONE);
        }
        if(propValue.equals("2")){
            locallist.add(Zone.TWO);
        }
        if(propValue.equals("3")){
            locallist.add(Zone.THREE);
        }


    }


}