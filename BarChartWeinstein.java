/**
 The BarChartWeinstein class asks for total sales amount input for five stores, and then displays a bar chart for each store where one asterisk '*' is equal to $100.

 Author: David Weinstein
 Date: 3/20/20
 Program file: BarChartWeinstein.java

 Pseudocode:
 1. Initialize an array with 5 empty integer elements to store daily sales amount.
 2. Initialize scanner object which will take the input of user.
 3. For loop to loop through each store and input daily sales into array.
 4. Use another for loop to display bar chart for each store using helper method displayStore()
 5. displayStore method converts each $100 in sales to an asterisk using a for loop.
 */
import java.util.Scanner;

public class BarChartWeinstein {

    public static void main(String[] args) {
        // create array to hold daily sales values for each store
        int[] sales = new int[5];
        Scanner input = new Scanner(System.in);
        // for loop to recieve input for each store and store itinto array
        for (int idx = 0; idx <5; idx++) {
            System.out.print("Enter today's sales for store " + (idx+1) + ": ");
            sales[idx] = input.nextInt();
        }
        System.out.println("Sales bar chart");
        // for loop to send each stores data to helper method which will display asterisks
        for (int idx = 0; idx < 5; idx++) {
            displayStore(idx, sales[idx]);
        }
    }

    /**
     * The displayStore method displays a storesdaily sales where one asterisk = $100
     * @param store store number
     * @param sales total daily sales in dollars
     */
    private static void displayStore(int store, int sales) {
        System.out.print("Store " + (store+1) + ": ");
        // for loop which divides sales by 100 and prints an asterisk for each $100
        for(int idx=0; idx < sales / 100; idx++){
            System.out.print("*");
        }
        System.out.println();
    }
}
