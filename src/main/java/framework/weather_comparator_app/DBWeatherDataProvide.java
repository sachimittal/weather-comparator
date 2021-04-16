package framework.weather_comparator_app;

import framework.test_comparator.TempUnit;
import framework.test_comparator.WeatherDataProvider;

public class DBWeatherDataProvide implements WeatherDataProvider {

	@Override
	public float getTemperature(String location, TempUnit unit) {
		
		return 35.6f;
	}

}
