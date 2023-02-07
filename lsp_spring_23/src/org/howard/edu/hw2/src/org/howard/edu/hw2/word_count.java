package org.howard.edu.hw2;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class word_count {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		try {
			String s = fr.readToString("main/java/resources/words.txt");
			String[] words = s.toLowerCase().split(" ");
			Map<String, Integer> wordCounts = new HashMap<>();
		    for (String word : words) {
		      if (word.length() < 4 || word.matches("\\d+")) {
		        continue;
		      } else {
		        if (wordCounts.containsKey(word)) {
		          wordCounts.put(word, wordCounts.get(word) + 1);
		        } else {
		          wordCounts.put(word, 1);
		        }
		      }
		    }
		    System.out.println(wordCounts);
		} catch (FileNotFoundException e1) {
			System.out.println("Unable to open resource");
		}
	}
}
