
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input

        System.out.println("=================================================");
        System.out.println("                GUESS THE NUMBER GAME            ");
        System.out.println("=================================================\n");

        System.out.println("Choose Difficulty Level :");    // Asking user to choose difficulty
        System.out.println("[1] Easy (3 elements)");
        System.out.println("[2] Medium (5 elements)");
        System.out.println("[3] Hard (10 elements)");
        System.out.print("Enter your choice (1-3): ");

        int choice = sc.nextInt();   // get choice
        int size = 0;

        if (choice == 1) 
            size = 3;
        else if (choice == 2) 
            size = 5;
        else if (choice == 3) 
            size = 10;
        else {
            System.out.println("Invalid choice!!! Start again...");   // if user enters invalid number 
            return;
        }

        int[] arr = new int[size];
        System.out.println("\nEnter " + size + " numbers for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nYour Array:");
        display(arr);     // display array 

        Random rand = new Random();
        int randomNumber = rand.nextInt(size);  // generate random number 

        int ch;
        do {                                   // loop for multiple rounds 
            System.out.println("\n---------------- NEW ROUND ----------------"); // start new round 
            System.out.print("Guess any number from the array: ");
            int guess = sc.nextInt();

            if (guess == arr[randomNumber]) {
                System.out.println("\n Correct! You guessed the hidden number :)"); // for right guess 
                System.out.println("Actual Number was: " + arr[randomNumber]);
            } else {
                System.out.println("\n Wrong guess!");          // for wrong guess
                System.out.println("Actual Number was: " + arr[randomNumber]);
            }

            System.out.println("-------------------------------------------");
            System.out.print(" Do You Want To Play again...? ( Yes = 0, No = 1): ");
            ch = sc.nextInt();

            if (ch == 0) {
                randomNumber = rand.nextInt(size); // change the random number each round 
            }
        } while (ch == 0);

        System.out.println("\n============= GAME ENDED =============");  // end the game 
    }

    public static void display(int[] arr) {   // method to display array 
        for (int num : arr) {
            System.out.print(num + "  "); // print each element
        }
        System.out.println();
    }
}