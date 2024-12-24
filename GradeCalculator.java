import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();

        // If the number of subjects is less than or equal to 0, ask for a valid number
        while (n <= 0) {
            System.out.print("Please enter a valid number of subjects: ");
            n = scanner.nextInt();
        }

        double[] marks = new double[n];
        double totalMarks = 0;

        // Loop to input marks for each subject
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();

            // Validate that marks are within the correct range
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Enter marks between 0 and 100: ");
                marks[i] = scanner.nextDouble();
            }

            totalMarks += marks[i];
        }

        // Calculate the average percentage
        double averagePercentage = totalMarks / n;

        // Determine the grade based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Displaying the results
        System.out.println("\n--- Results ---");
        System.out.printf("Total Marks: %.2f\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}