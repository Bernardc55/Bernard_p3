import java.util.*;

public class Survey {

	public static void main(String[] args) {
		//creates all variables needed
		Scanner scnr = new Scanner(System.in);
		String[] topics = {"BC", "WotLK", "Cata", "MoP", "Legion"};
		int[][] responses = new int[5][11];
		int i, j, numOfResponses = 0, highestTotalIndex = -1, lowestTotalIndex = -1, highestTotal = 0, lowestTotal = Integer.MAX_VALUE, total = 0;
		double avg = 0;
		String userInput = "Y";
		int userRating;
		//initializes all values of responses to be 0
		for(i = 0; i < 5; i++) {
			for(j = 0; j < 11; j++) {
				responses[i][j] = 0;
			}
		}
		//loops as long as the user wants to continue inputting data
		while(userInput.compareTo("N") != 0){
			//asks teh user if they want to input another survey or leave
			System.out.println("Would you like to input a survey of the importance of WoW expansions on lore?\n(Y)es or (N)o (Prints results on No)");
			userInput = scnr.nextLine();
			//if they do, it gives them the survey
			if(userInput.compareTo("Y") == 0) {
				for(i = 0; i < 5; i++) {
					//asks the user to rate the given expansion out from 0 to 10
					System.out.println("Rate " + topics[i] + " from 0 to 10.");
					//reads in the user's response and adds it to the responses array
					userRating = scnr.nextInt();
					responses[i][userRating]++;
				}
				//increments the number of surveys completed
				numOfResponses++;
			}
			//this is if the user wants to end entering surveys and print the data
			if(userInput.compareTo("N") == 0) {
				//prints the header for the table
				System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAvg");
				//loops through each topic
				for(i = 0; i < 5; i++) {
					//prints the topic and resets the average
					System.out.print(topics[i]);
					avg = 0.0;
					//prints a row of response data for the given topic
					for(j = 0; j < 11; j++) {
						System.out.print("\t" + responses[i][j]);
						//adds the number times the amount of responses for that number to average
						avg = avg + (responses[i][j] * j);
					}
					//sets the total number of points the topic earned
					total = (int)avg;
					//finds the average by dividing by the number of surveys responded to
					avg = avg / (double)numOfResponses;
					//prints another tab before printing the average out to 2 decimal places
					System.out.print("\t");
					System.out.printf("%.2f", avg);
					//checks to see if this is the highest or lowest total and records the index of the topic and the total respectively
					if(total > highestTotal) {
						highestTotal = total;
						highestTotalIndex = i;
					}
					if(total < lowestTotal) {
						lowestTotal = total;
						lowestTotalIndex = i;
					}
					//creates a new line for the next topic
					System.out.print("\n");
				}
				//prints out the highest and lowest total topics along with their respective total points
				System.out.println("The Expansion with the highest point total was " + topics[highestTotalIndex] + " with " + highestTotal + " points!");
				System.out.println("The Expansion with the lowest point total was " + topics[lowestTotalIndex] + " with " + lowestTotal + " points!");
			}
		}
		scnr.close();
	}

}
