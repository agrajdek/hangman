package futureprogrammer.sengitaa.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String testWord = "hangman";
        int index = 0;
        int usersLife = 10;

        char [] lettersHit = "_______".toCharArray(); //bo java nie lubi a trzeba inicjalizancję przeprowadzić

        Scanner input = new Scanner(System.in);

        char userChoice; // będzie przechow znak wpisany

        while (usersLife > 0) {
            if (testWord.equalsIgnoreCase(String.copyValueOf(lettersHit))) {
                System.out.println("You won the game!");
                break;
            }
            userChoice = input.next().charAt(index);
//            if (userChoice == testWord.charAt(index)) {
            if (testWord.contains(userChoice + "")) {
                System.out.println("You picked the correct word! \n You undercovered a letter.");
                for (int i = 0; i < testWord.length(); i++) {
                    if (testWord.charAt(i) == userChoice){
                        lettersHit[i] = testWord.charAt(i);
                        System.out.println("The letters are: " + String.copyValueOf(lettersHit));
                    }
                }

//                TODO przechow trafionych liter, wyświetlanie ich userowi, no i sprawdzanie czy jeszcze są
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


        // String[] wordSplitted = testWord.split(""); pomysł by tak rozbić słowo miast charAt / String.valueOf(myString.charAt(index))

        /** String s = "Strings are immutable";
         char result = s.charAt(8);
         System.out.println(result);
         } **/

    }
}
