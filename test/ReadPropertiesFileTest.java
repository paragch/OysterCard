import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by paragchatterjee on 01/03/2017.
 */
public class ReadPropertiesFileTest {

    private Map<String, ArrayList<Zone>> map;
    private ReadPropertiesFile fileLoader;
    @Before
    public void setUp() throws Exception {

        ReadPropertiesFile fileLoader= new ReadPropertiesFile();
        map = fileLoader.readFile();
    }

    @Test
    public void testReadFile() throws Exception {

        assertEquals(map.get("Holborn").get(0),Zone.ONE);
        assertNotEquals(map.get("Holborn").get(0),"Kings Cross");

    }
}