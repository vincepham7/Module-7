//Vincent Pham 03/27/2023

package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class WordOccurance extends Application implements EventHandler<ActionEvent> {

	Button button;

	@Override
	public void start(Stage primaryStage) throws IOException {

		primaryStage.setTitle("Word Count of The Raven");
		button = new Button();
		button.setText("Click Me");

		button.setOnAction(this);

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void handle(ActionEvent event) {
		if (event.getSource() == button)
			;
		System.out.println("Hi There! This works!!!");
	}

	{// This is used to read the file
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
					new FileReader("C:\\Users\\Vince\\Desktop\\School\\Software Development I\\The Raven.txt")); // Change
																													// Location
																													// of
																													// Raven
																													// txt
																													// if
																													// needed.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creating map to store words and word frequencies of all words in the file
		Map<String, Integer> word_count = new HashMap<>();

		String line;

		// Creating while loop (also add throw IOException)
		try {
			while ((line = bufferedReader.readLine()) != null) {

				// splitting line by use regular expression
				String[] words = line.split("[\\s.;,?:!()\"]+");

				// Reads each word repeatedly
				for (String word : words) {

					word = word.trim();

					if (word.length() > 0) {

						if (word_count.containsKey(word)) {
							word_count.put(word, word_count.get(word) + 1);
						}

						else {
							word_count.put(word, 1);
						}
					}

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sort words to highest frequency
		Map<String, Integer> sortWordMap = word_count.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// printing word and frequencies of all words
		System.out.printf("%-20s%15s\n", "WORD", "TIMES OCCURRED");

		System.out.printf("%-20s%15s\n", "", "");

		for (Map.Entry<String, Integer> entry : sortWordMap.entrySet()) {

			System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
		}

		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}