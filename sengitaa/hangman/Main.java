package futureprogrammer.sengitaa.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String testWord = "hangman";
        int index = 0;
        int usersLife = 10;

        // declaration of array that will store and show chars undecovered by user
        char [] lettersHit = "_______".toCharArray();

        Scanner input = new Scanner(System.in);

        //declaration of char that will store the letter entered by user
        char userChoice;

        while (usersLife > 0) {
            /**checks if undercovered letters are equal to the word
            String.copyValueOf returns a String that represents the character sequence in the array specified.**/
            if (testWord.equalsIgnoreCase(String.copyValueOf(lettersHit))) {
                System.out.println("You won the game!");
                break;
            }
            //Scanner reading the user's input which is char
            userChoice = input.next().charAt(index);
//            contains require the char sequence - that is reason for adding ""
            if (testWord.contains(userChoice + "")) {
                System.out.println("You picked the correct word! \n You undercovered a letter.");
                for (int i = 0; i < testWord.length(); i++) {
                    // checking if the word contains picked char
                    if (testWord.charAt(i) == userChoice){
                        // undercovering picked char/-s
                        lettersHit[i] = testWord.charAt(i);
                        System.out.println("The letters are: " + String.copyValueOf(lettersHit));
                    }
                }

            } else {
                usersLife--;

                if (usersLife == 1) {
                    System.out.println("You are wrong and you loose one life. You have one life left");
                }
                System.out.println("You are wrong and you loose one life. You have " + usersLife + " lives left");
            }
        }
        if (usersLife == 0) {
            System.out.println("You have lost!");
        }

    }
}
