import java.util.Random;

/**
 * ComplicatedHello generates a collection of random characters, in an attempt
 * to match the given word or sentence.
 * After each matched letter, it keeps that in "memory" and attempts to match
 * the rest of the word.
 * 
 * @author Christian "Nihtster" Ilog
 * @version 0.2
 */
public class ComplicatedText {

    Random rcg;
    Random rcgCap;
    Random rng;

    String ogStr;
    String testStr;
    String finalStr;

    int strLen;
    int attemptCnt;

    boolean match;
    boolean partialMatch;
    int identicalEnd;

    public ComplicatedText() {
        rcg = new Random();
        rcgCap = new Random();
        rng = new Random();

        ogStr = "hello world i now can handle longer strings";
        testStr = "";
        finalStr = "";

        strLen = ogStr.length();
        attemptCnt = 0;

        match = false;
        partialMatch = false;
        identicalEnd = 0;

    }

    public ComplicatedText(String givenStr) {
        rcg = new Random();
        rcgCap = new Random();
        rng = new Random();

        ogStr = givenStr;
        testStr = "";
        finalStr = "";

        strLen = ogStr.length();
        attemptCnt = 0;

        match = false;
        partialMatch = false;
        identicalEnd = 0;
    }

    // This is a getter method for the private boolean variable `match`. It returns
    // the value of `match`
    // to the caller.
    /**
     * @return boolean
     */
    public boolean getMatch() {
        return match;
    }

    /**
     * This Java function returns the value of the variable "attemptCnt".
     * 
     * @return The method is returning the value of the variable `attemptCnt`.
     */
    public int getAttemptCnt() {
        return attemptCnt;
    }

    /**
     * This function generates a random string with a specified length and a
     * possible space character
     * at a specified location.
     * 
     * @return The method `attemptGen()` is returning a `String` value.
     */
    public String attemptGen() {
        for (int i = identicalEnd; i < strLen; i++) {
            if (partialMatch) {
                testStr = finalStr;
                partialMatch = false;
            }

            if (rng.nextInt(2) == 0) {
                if (rng.nextInt(2) == 1) {
                    char cCap = (char) (rcg.nextInt(65, 90));
                    if (ogStr.charAt(i) == ' ') {
                        testStr = testStr + " ";
                    }
                    testStr = testStr + cCap;
                } else {
                    char c = (char) (rcg.nextInt(97, 122));
                    if (ogStr.charAt(i) == ' ') {
                        testStr = testStr + " ";
                    }
                    testStr = testStr + c;
                }

            } else {
                char s = (char) (rcg.nextInt(33, 64));
                if (ogStr.charAt(i) == ' ') {
                    testStr = testStr + " ";
                }
                testStr = testStr + s;
            }
        }
        attemptCnt++;
        return testStr;
    }

    /*
     * All inclusive of ascii table vs version above where each one is separated.
     * char c = (char) (rcg.nextInt(33, 126));
     * if (ogStr.charAt(i) == ' ') {
     * testStr = testStr + " ";
     * }
     * testStr = testStr + c;
     */

    /**
     * The function compares two strings character by character and sets a flag if
     * there is a partial
     * or full match.
     */
    public void compareAttempt() {
        for (int i = 0; i < strLen; i++) {
            if (ogStr.charAt(i) == (testStr.charAt(i))) {
                identicalEnd = i + 1;
                finalStr = testStr.substring(0, identicalEnd);
                partialMatch = true;
            } else {
                testStr = "";
                break;
            }
        }
        if (finalStr.equals(ogStr)) {
            match = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // attempt generation;

        ComplicatedText instance = new ComplicatedText("What is my purpose?");

        do {
            System.out.println(instance.attemptGen());
            instance.compareAttempt();
            Thread.sleep(40);
        } while (instance.getMatch() != true);

        System.out.println();
        System.out.println("Attempt count: " + instance.getAttemptCnt());
    }
}
