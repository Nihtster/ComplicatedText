import java.util.Random;

/**
 * ComplicatedHello generates a collection of random characters, in an attempt
 * to match the given word or sentence.
 * After each matched letter, it keeps that in "memory" and attempts to match
 * the rest of the word.
 * 
 * @author Christian "Nihtster" Ilog
 * @version 1.0
 */
public class ComplicatedText {

    static Random rnd = new Random();

    static String subject = "sussy baka";
    static String testStr = "";
    static String finalStr = "";

    static int strLen = subject.length();
    static int spaceLoc = subject.indexOf(" ");
    static int attemptCnt = 0;

    static boolean match = false;
    static boolean partialMatch = false;
    static int identicalEnd = 0;

    /**
     * This function generates a random string with a specified length and a
     * possible space character
     * at a specified location.
     * 
     * @return The method `attemptGen()` is returning a `String` value.
     */
    public static String attemptGen() {
        for (int i = identicalEnd; i < strLen; i++) {
            if (partialMatch) {
                testStr = finalStr;
                partialMatch = false;
            }

            char c = (char) ('a' + rnd.nextInt(26));
            if (i == spaceLoc) {
                testStr = testStr + " ";
            }
            testStr = testStr + c;
        }
        attemptCnt++;
        return testStr;
    }

    /**
     * The function compares two strings character by character and sets a flag if
     * there is a partial
     * or full match.
     */
    public static void compareAttempt() {
        for (int i = 0; i < strLen; i++) {
            if (subject.charAt(i) == (testStr.charAt(i))) {
                identicalEnd = i + 1;
                finalStr = testStr.substring(0, identicalEnd);
                partialMatch = true;
            } else {
                testStr = "";
                break;
            }
        }
        if (finalStr.equals(subject)) {
            match = true;
        }
    }

    // This is the main method of the `ComplicatedHello` class. It takes an array of
    // strings `args` as
    // a parameter and throws an `InterruptedException`. It generates random strings
    // using the
    // `attemptGen()` method and compares them to the `subject` string using the
    // `compareAttempt()`
    // method. It continues to generate and compare strings until a match is found.
    // The number of
    // attempts made is printed to the console.
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // attempt generation;
        do {
            System.out.println(attemptGen());
            compareAttempt();
            Thread.sleep(20);
        } while (match != true);

        System.out.println();
        System.out.println("Attempt count: " + attemptCnt);
    }
}
