/**
 * The DriverExamWeinstein class allows you to input a students exam answers, and checks them with the answer key and displays whether the student passes, how many correct, how many incorrect, and which questions were missed.
 * 
 * Author: David Weinstein
 * Date: 3/22/20
 * Program file: DriverExamWeinstein.java
 * 
 * Pseudocode:
 * 1. Set up class field variables for countCorrect, countWrong, two missed arrays, array for correctAnswers, array for userAnswers, and char for each user answer. 
 * 2. Set up Scanner object to collect users answers.
 * 3. Only add user answer to array if it is an A, B, C or D.
 * 4. Call displayResults() method to begin calculating and displaying results.
 * 5. displayResults() method calls each helper method as needed to display the results of driver exam.
 */
import java.util.*;

public class DriverExamWeinstein {
    // set up class field variables
    static int countCorrect = 0;
    static int countWrong = 0;
    static ArrayList<Integer> missed = new ArrayList<>();
    static int[] miss = new int[10];
    static char[] correctAnswers = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D'};
    static char[] userAnswers = new char[10];
    static char userAns;
    public static void main(String[] args) {
        // Scaner object for input, for loop to loop through questions and input answers, converts input to uppercase, and checks if the character is an A, B, C, or D and adds the answer to userAnswers array
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < correctAnswers.length; ++i){
            System.out.print("Enter answer for question " + (i+1) + ": ");
            userAns = input.next().charAt(0);
            userAns = Character.toUpperCase(userAns);
            if (userAns == 'A' || userAns == 'B' || userAns == 'C' || userAns == 'D') {
                userAnswers[i] = userAns;
            } else {
                System.out.println("Incorrect option.");
                --i;
            }
        }
        displayResults();
    }
    
    /**
     * The displayResults method calls and prints out the results of each method.
     */
    private static void displayResults() {
        if(passed()){
            System.out.println("The student has passed.");
        } else {
            System.out.println("The student has failed");
        }
        System.out.println("The student got " + getTotalCorrect() + " questions correct");
        System.out.println("The student got " + totalIncorrect() + " questions incorrect");
        System.out.println("The student got the following questions incorrect " + Arrays.toString(questionsMissed()));
    }
    
    /**
     * totalCorrect method compares userAnswers to correct answers to calculate correct answers.
     * @return countCorrect which is the total number correct
     */
    public static int totalCorrect(){
        for(int i = 0; i<userAnswers.length;++i){
            if(correctAnswers[i] == userAnswers[i]){
                ++countCorrect;
            }
        }
        return countCorrect;
    }

    /**
     * getTotalCorrect method gets the total of countCorrect calculated in totalCorrect method
     * @return countCorrect
     */
    public static int getTotalCorrect(){
        return countCorrect;
    }

    /**
     * totalIncorrect method calculates the questions answered incorrectly and returns that amount
     * @return countWrong
     */
    public static int totalIncorrect() {
        for(int i =0; i<userAnswers.length;++i){
            if(correctAnswers[i] != userAnswers[i]){
                ++countWrong;
            }
        }
        return countWrong;
    }

    /**
     * passed method compares totalCorrect to 7, which is the aount needed to pass
     * @return true or false 
     */
    private static boolean passed() {
        if(totalCorrect() >= 7){
            return true;
        } else {
            return false;
        }
    }

    /**
     * questionsMissed method adds the question number of the missed question to an array, and then populates another int array to return
     * @return miss array, which is an array of all the question numbers which were incorrect
     */
    public static int[] questionsMissed() {
        for(int i = 0; i<correctAnswers.length; ++i) {
            if(correctAnswers[i] != userAnswers[i]){
                missed.add(i+1);
            }
        }
        int[] miss = new int[missed.size()];
        for(int j = 0; j<miss.length; ++j){
            miss[j] = (int) missed.get(j);
        }
        return miss;
    }
}
