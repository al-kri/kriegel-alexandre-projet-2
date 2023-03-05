package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
  
  /**
  * Entry point of the program.
  * All methods from {@link AnalyticsCounter} will be called here.
  * @param args is an Array of String.
  */
  public static void main(String[] args) {
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile("results.out");
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
    List<String> symptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
    Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
    
    analyticsCounter.writeSymptoms(sortSymptoms);
  }
}