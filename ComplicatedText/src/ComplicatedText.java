import java.util.Random;

/**
 * ComplicatedHello generates a collection of random characters, in an attempt
 * to match the given word or sentence.
 * After each matched letter, it keeps that in "memory" and attempts to match
 * the rest of the word.
 * 
 * @author Christian "Nihtster" Ilog
 * @version 0.3
 */
public class ComplicatedText {
    Random rcg;

    String ogStr;
    String temp;
    String finalStr;

    int strLen;
    int attemptCnt;

    boolean match;
    int identicalEnd;

    public ComplicatedText(String givenStr) {
        rcg = new Random();

        temp = "";
        ogStr = givenStr;

        strLen = ogStr.length();
        attemptCnt = 0;

        match = false;
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
     * This function generates a random string and checks if it matches a given
     * original string, with a
     * limit on the number of attempts.
     */
    public void attemptGen() {
        finalStr = temp;
        for (int i = identicalEnd; i < strLen; i++) {
            char c = (char) (rcg.nextInt(32, 126));
            finalStr = finalStr + c;
        }
        for (int i = 0; i < strLen; i++) {
            if (ogStr.charAt(i) == (finalStr.charAt(i))) {
                identicalEnd = i + 1;
                temp = finalStr.substring(0, identicalEnd);
            } else {
                System.out.println(finalStr);
                finalStr = "";
                break;
            }
        }
        if (finalStr.equals(ogStr)) {
            System.out.println(finalStr);
            match = true;
        }

        attemptCnt++;
    }

    public static void main(String[] args) throws InterruptedException {
        // attempt generation;

        ComplicatedText instance = new ComplicatedText("Wanna Get Jamba Juice??");

        do {
            instance.attemptGen();
            Thread.sleep(2);
        } while (instance.getMatch() != true);

        System.out.println();
        System.out.println("Attempt count: " + instance.getAttemptCnt());
    }
}
