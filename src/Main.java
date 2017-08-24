import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<LetterSet> letterSets = Arrays.asList(
            new LetterSet(1, "aeinorswz"),
            new LetterSet(2, "cdklmpty"),
            new LetterSet(3, "bghjłu"),
            new LetterSet(5, "ąęfóśż"),
            new LetterSet(6, "ć"),
            new LetterSet(7, "ń"),
            new LetterSet(9, "ź")
    );;

    public static void main(String[] args) {




    }

    /**
     * Metoda zwracająca końcową wartość punktów dla całego słowa
     * @param word
     * @return
     */
    public static int calcPoints(String word) {
        int finalScore = 0;
        for (char letter : word.toCharArray()) {
            finalScore += getLetterScore(letter);
        }
        return finalScore;
    }

    /**
     * Metoda zwracająca wartość punktów dla pojedynczej litery
     * @param letter
     * @return
     */
    public static int getLetterScore(char letter) {
        int score = 0;
        for (LetterSet letterSet : letterSets) {
            if (letterSet.containsLetter(letter)) {
                score =  letterSet.getScore();
            }
        }
        return score;
    }

    /**
     * Klasa wewnętrzna LetterSet
     */
    public static final class LetterSet {

        private int score;
        private List<Character> letters;

        public LetterSet(int score, String letters) {
            this.score = score;
            this.letters = new ArrayList<Character>(letters.length());
            for (char letter : letters.toCharArray()) {
                this.letters.add(letter);
            }
        }

        public int getScore() {
            return score;
        }

        public boolean containsLetter(Character letter) {
            return letters.contains(letter);
        }
    }
}
