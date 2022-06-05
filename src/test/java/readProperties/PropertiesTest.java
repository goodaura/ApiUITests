package readProperties;

import base.BaseTest;
import org.junit.Test;

import java.io.IOException;

public class PropertiesTest extends BaseTest {
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);
    }

    @Test
    public void readFromConf(){
        String urlFromConfig = ConfigProvider.URL;
        System.out.println(urlFromConfig);
        Boolean isDemoAdmin = ConfigProvider.IS_DEMO_ADMIN;
        System.out.println(isDemoAdmin);
        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")){
            System.out.println("Admin is admin");
        } else {
            System.out.println("Error");
        }
    }
}
