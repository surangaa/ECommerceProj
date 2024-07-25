import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesConfig {

    public static String projLocation = System.getProperty("user.dir");
    static Properties prop = new Properties();

    public static void getBrowser(){
        try{

            InputStream input = new FileInputStream(projLocation + "/src/main/resources/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            Setup.browserName = browser;
//            System.out.println(Setup.browserName);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        }
    }

    public static void getURL(){
        try{

            InputStream input = new FileInputStream(projLocation + "/src/main/resources/config.properties");
            prop.load(input);
            String url = prop.getProperty("url");
            Setup.Url = url;
//            System.out.println(Home.Url);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        }
    }

    public static void setBrowser(){
        try{
            OutputStream output = new FileOutputStream(projLocation + "/src/main/resources/config.properties");
            prop.setProperty("browser","chrome");
            prop.store(output,"");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        }
    }
}
