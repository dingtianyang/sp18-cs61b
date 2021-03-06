public class Palindrome {

    /**
     * Return a Deque where the characters appear in the same
     * order as in the String
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /**
     * Test if a word is palindrome or not.
     */
    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
        return false;
    }

    /**
     * Test if a word is an OffByOne palindrome or not.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (cc.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
            return isPalindrome(word.substring(1, word.length() - 1), cc);
        }
        return false;
    }

}
