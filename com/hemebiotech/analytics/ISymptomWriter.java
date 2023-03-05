package com.hemebiotech.analytics;

import java.util.Map;

/**
* This functional interface represents a writer for symptom data.
*/
public interface ISymptomWriter {
  /**
  * Writes the symptom data to the output.
  */
  public void writeSymptoms(Map<String, Integer> symptoms);
}