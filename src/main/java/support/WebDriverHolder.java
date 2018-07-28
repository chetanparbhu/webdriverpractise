package support;

//import com.google.common.base.Preconditions;
//import org.openqa.selenium.WebDriver;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private static WebDriver driver;

    public static WebDriver get() {
        Preconditions.checkNotNull(driver, "Calling WebDriverHolder.get before driver has been set.");
        return driver;
    }

    public static void set(WebDriver driver) {
        WebDriverHolder.driver = driver;
    }

    public static void clear() {
        WebDriverHolder.driver = null;
    }

    public static void closeup(){
        WebDriverHolder.driver.quit();
    }

    public static boolean isDriverSet() {
        try {
            if (driver != null) {
                return true;
            }

        } catch (NullPointerException e) {
            System.out.println("I guess there is no driver set");
            return false;
        }
        return false;
    }

}