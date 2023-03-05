package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* {@link AnalyticsCounter} class will count the number of symptoms
* in a list of symptoms.
*/
public class AnalyticsCounter {
  
  private ISymptomReader reader;
  private ISymptomWriter writer;

  /**
  * This is the constructor of the class {@link AnalyticsCounter}.
  * @param reader object will read the list of symptoms.
  * @param writer object will write the list of symptoms.
  */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
  * This method will recover the list of symptoms from the object reader.
  * @return the list of symptoms.
  */
  public List<String> getSymptoms() {
    return reader.getSymptoms(); 
  }

  /**
  * This method will count the number of occurrences a symptom is in the list of symptoms.
  * @param symptoms is the list of symptoms.
  * @return return a {@link Map} with the number of occurrences for each symptom.
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> symptomInFile = new HashMap<>();
    for (String symptom : symptoms) {
      if (symptomInFile.containsKey(symptom)) {
        symptomInFile.put(symptom, symptomInFile.get(symptom) + 1);
      } else {
        symptomInFile.put(symptom, 1);
      }
    }
    return symptomInFile;
  }

  /**
  * This method will sort the list of symptoms in alphabetical order.
  * @return will generate a {@link TreeMap} in alphabetical order.
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  /**
  * This method will write the symptoms in the {@link Map} symptoms from the object writer.
  * @param symptoms will contain the number of occurrences for each symptoms.
  */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}