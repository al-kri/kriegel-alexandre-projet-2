package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
* {@link AnalyticsCounter} class will count the number of symptoms
* in a list of symptoms.
* 
*/

public class AnalyticsCounter {
	
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;

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
    for(String symptom : symptoms) {
      if(symptomInFile.containsKey(symptom)) {
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

	/*public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("com/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0; // counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
        System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("dilated pupils")) {
				pupilCount++;
			}
      
			line = reader.readLine();	// get another symptom
		}
		headacheCount = headCount;
    reader.close();

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
    System.out.println(headacheCount);
    System.out.println(rashCount);
    System.out.println(pupilCount);
		writer.close();
	}*/
}