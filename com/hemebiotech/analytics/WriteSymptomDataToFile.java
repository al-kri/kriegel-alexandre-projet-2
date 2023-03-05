package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
  
  private final String fileName;

  public WriteSymptomDataToFile(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try (FileWriter writer = new FileWriter(fileName)) {
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
      }
    } catch (IOException e) {
      System.err.println("Opération impossible");
      e.printStackTrace();
    }
  }
}