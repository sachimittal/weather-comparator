package framework.weather_comparator_app;

import org.apache.log4j.Logger;
import org.comparator.framework.Comparator;
import org.comparator.framework.Result;

import framework.common.WeatherProperties;
import framework.test_comparator.APIWeatherDataProvider;
import framework.test_comparator.NDTVWeatherDataProvider;
import framework.test_comparator.TempUnit;
import framework.test_comparator.WeatherDataProvider;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class); 
    public static void main( String[] args )
    {		
	   System.setProperty("property_file", "config.properties");
       System.setProperty("webdriver.chrome.driver", WeatherProperties.getInstance().getProperty("chrome.webdriver.path"));
       Comparator comp = new Comparator();
       WeatherDataProvider ndtv = new NDTVWeatherDataProvider();
       WeatherDataProvider api = new APIWeatherDataProvider();
       WeatherDataProvider db = new DBWeatherDataProvide();
       
       Result result = comp.compareTempData(api, db, "Pune", TempUnit.DEGREE);
       logger.info("Temperature from both sources are same: " + result.isMatch() + ", Difference is " + result.getDifference());
    }
}
