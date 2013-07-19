package com.autodesk.agiledemo;

import java.util.HashMap;
import java.util.Map;

public class Weather {
	private String city;
	private String region;
	private String country;
	private double temperature;
	private String condition;
	private String humidity;
	private String windSpeed;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWearingAdvice() {
		
		Map <String,String> map = new HashMap<>();
		
		map.put("truetrue", "Umbrella, T-shirt");
		map.put("falsetrue", "Raincoat");
		map.put("truefalse", "T-shirt");
		map.put("falsefalse", "Shirts");
		
		if (isConditionUndefined() || isTemperatureOutOfScope())
			return "No Wearing Advice";
		return map.get(String.valueOf(isHot())+String.valueOf(isRaining()));
	}

	private boolean isConditionUndefined() {
		return !this.condition.equals("Raining") && !this.condition.equals("Sunny");
	}

	private boolean isTemperatureOutOfScope() {
		return this.temperature>79d || this.temperature<60d;
	}

	private boolean isRaining() {
		return this.condition.equals("Raining");
	}

	private boolean isHot() {
		return this.temperature>=70d;
	}	
}