package api.ObjectRepo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class keyvalue {

    public String readdatafromkeyvalue(String key) throws IOException {

        FileInputStream fis=new FileInputStream("C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\data.properties");


        Properties prp=new Properties();
        prp.load(fis);
        return prp.getProperty(key,"Incorrectkey");

    }


}
