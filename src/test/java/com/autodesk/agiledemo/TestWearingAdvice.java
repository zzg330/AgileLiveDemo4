package com.autodesk.agiledemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWearingAdvice {
	
	private Weather weather = new Weather();

	@Test
	public void expected_shirts_when_temperature_60_and_condition_sunny(){
		
		assertExpectedAndReturned("Sunny", 60d, "Shirts");
	}

	@Test
	public void expected_shirts_when_temperature_70_and_condition_sunny(){
		assertExpectedAndReturned("Sunny", 70d, "T-shirt");
	}
	
	@Test
	public void expected_raincoat_when_temperature_60_and_condition_raining()
	{
		assertExpectedAndReturned("Raining", 60d, "Raincoat");
	}
	
	@Test	
	public void expected_umbrella_and_tshirt_when_temperature_70_and_condition_raining()
	{
		assertExpectedAndReturned("Raining", 70d, "Umbrella, T-shirt");
	}
	
	@Test
	public void no_wearining_advice_when_temperature_out_of_scope_or_condition_undefined()
	{
		assertExpectedAndReturned("Sunny", 80d, "No Wearing Advice");
		assertExpectedAndReturned("Sunny", 59d, "No Wearing Advice");	
		assertExpectedAndReturned("Cloudy", 60d, "No Wearing Advice");
	}
	
	private void assertExpectedAndReturned(String condition, double temperature, String expectedWearingAdvice) {
		weather.setCondition(condition);
		weather.setTemperature(temperature);
		assertEquals(expectedWearingAdvice, weather.getWearingAdvice());
	}
}
