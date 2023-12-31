import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HogwartsPractice {

	public static void main(String[] args) {
		// Header
		try {
		    BufferedReader input = new BufferedReader(new FileReader(fileName1));
		    String line;

		    while ((line = input.readLine()) != null) { // Read the file line-by-line
		        System.out.println(line);               // Print each line
		    }

		    input.close();                              // Close the BufferedReader
		} catch (FileNotFoundException ex2) {
		    ex2.printStackTrace();
		    System.exit(1);
		} catch (IOException ex3) {                     // Catch potential IOException
		    ex3.printStackTrace();
		    System.exit(1);
		}
		// Declare Variables
		String fileName = "hogwarts_classes.txt";
		Scanner inData = null;
		String courseName = "", professorName = "", dayOfWeek, startTime,
				endTime, openClasses, seeker, classTaught;
		int currentStudents = 0, maxStudents = 0, remainingSeats = 0;

		// Import file
		try {
			inData = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File not found!");
			System.exit(1);
		}
		// Use loop to read data
		for (int i = 0; inData.hasNext() && i <= Integer.MAX_VALUE; i++) {
			courseName = inData.next();
			courseName = courseName.replace('_', ' ');
			professorName = inData.next();
			dayOfWeek = inData.next();
			startTime = inData.next();
			endTime = inData.next();
			maxStudents = inData.nextInt();
			currentStudents = inData.nextInt();

			// Output as human readable format
			System.out.print(dayOfWeek + ": " + courseName + " with Professor "
					+ professorName + " from " + startTime + " to " + endTime
					+ ". Max Students: " + maxStudents + ", Current Students: "
					+ currentStudents + "\n");

			// Determine which classes have availability
			if (maxStudents - currentStudents > 0) {
				remainingSeats = (maxStudents - currentStudents);
				openClasses = courseName;
				System.out.println(openClasses + " has " + remainingSeats
						+ " seat(s) remaining\n");
			} else {
				System.out.println("This class is FULL\n");
			}
		}
		inData.close(); // Close the file

		// Reopen the file
		try {
			inData = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File not found!");
			System.exit(1);
		}
		// Prompt user to enter professor name
		Scanner input = new Scanner(System.in);
		System.out.print("Enter professor name to find class: ");
		seeker = input.next();
		input.close();

		// Use loop again to read data
		while (inData.hasNext()) {
			courseName = inData.next();
			courseName = courseName.replace('_', ' ');
			professorName = inData.next();
			dayOfWeek = inData.next();
			startTime = inData.next();
			endTime = inData.next();
			maxStudents = inData.nextInt();
			currentStudents = inData.nextInt();

			// Check if input matches professor name
			if (seeker.equals(professorName)) {
				seeker = professorName;
				classTaught = courseName;
				System.out.println("Professor " + seeker + " teaches "
						+ classTaught + " class.");
				break;
		}
		inData.close();
	}
}
// franyatta
