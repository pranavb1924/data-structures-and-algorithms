import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 02 - Strings
 *
 * A String is a read-only sequence of chars. You can't change one in place.
 *   - s.length() is the number of chars; s.charAt(i) reads one char in O(1).
 *   - Building a string with += in a loop copies it every time (O(n^2) overall).
 *     Use a StringBuilder instead: sb.append(c), then sb.toString().
 *   - A char is a small number: 'c' - 'a' == 2. That's handy for counting letters
 *     with an int[26].
 *
 * Run:  java 02-strings/StringBasics.java
 */
public class StringBasics {

    /**
     * Return s backwards.
     *   reverse("hello") -> "olleh"
     *   reverse("")      -> ""
     */
    public static String reverse(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return true if s reads the same forwards and backwards (exact chars, case matters).
     *   isPalindrome("racecar") -> true
     *   isPalindrome("hello")   -> false
     * Challenge: don't build a reversed copy. Compare from both ends instead.
     */
    public static boolean isPalindrome(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Count the vowels (a, e, i, o, u), ignoring case.
     *   countVowels("hello world") -> 3
     *   countVowels("AEIOU")       -> 5
     */
    public static int countVowels(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Count the words. Words are separated by one or more spaces.
     *   countWords("hello world")              -> 2
     *   countWords("  leading and trailing  ") -> 3
     *   countWords("   ")                      -> 0
     */
    public static int countWords(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return true if a and b use exactly the same letters the same number of times.
     * Assume only lowercase letters a-z.
     *   isAnagram("listen", "silent") -> true
     *   isAnagram("rat", "car")       -> false
     * Hint: an int[26] of letter counts.
     */
    public static boolean isAnagram(String a, String b) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the index of the first char that appears only once, or -1 if there isn't one.
     * Assume only lowercase letters a-z.
     *   firstUniqueChar("leetcode")     -> 0
     *   firstUniqueChar("loveleetcode") -> 2
     *   firstUniqueChar("aabb")         -> -1
     * Hint: two passes. Count first, then look.
     */
    public static int firstUniqueChar(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 02 - Strings\n");

        check("reverse(\"hello\")", () -> reverse("hello"), "olleh");
        check("reverse(\"a\")", () -> reverse("a"), "a");
        check("reverse(\"\")", () -> reverse(""), "");

        check("isPalindrome(\"racecar\")", () -> isPalindrome("racecar"), true);
        check("isPalindrome(\"abba\")", () -> isPalindrome("abba"), true);
        check("isPalindrome(\"hello\")", () -> isPalindrome("hello"), false);
        check("isPalindrome(\"\")", () -> isPalindrome(""), true);

        check("countVowels(\"hello world\")", () -> countVowels("hello world"), 3);
        check("countVowels(\"rhythm\")", () -> countVowels("rhythm"), 0);
        check("countVowels(\"AEIOU\")", () -> countVowels("AEIOU"), 5);

        check("countWords(\"hello world\")", () -> countWords("hello world"), 2);
        check("countWords(\"  leading and trailing  \")", () -> countWords("  leading and trailing  "), 3);
        check("countWords(\"one\")", () -> countWords("one"), 1);
        check("countWords(\"   \")", () -> countWords("   "), 0);
        check("countWords(\"\")", () -> countWords(""), 0);

        check("isAnagram(\"listen\", \"silent\")", () -> isAnagram("listen", "silent"), true);
        check("isAnagram(\"rat\", \"car\")", () -> isAnagram("rat", "car"), false);
        check("isAnagram(\"aab\", \"abb\")", () -> isAnagram("aab", "abb"), false);
        check("isAnagram(\"abc\", \"ab\")", () -> isAnagram("abc", "ab"), false);

        check("firstUniqueChar(\"leetcode\")", () -> firstUniqueChar("leetcode"), 0);
        check("firstUniqueChar(\"loveleetcode\")", () -> firstUniqueChar("loveleetcode"), 2);
        check("firstUniqueChar(\"aabb\")", () -> firstUniqueChar("aabb"), -1);

        summary();
    }

    private static int passed, failed, todo;

    private static void check(String name, Supplier<Object> actual, Object expected) {
        try {
            Object got = actual.get();
            if (Objects.deepEquals(got, expected)) {
                passed++;
                System.out.println("  PASS  " + name);
            } else {
                failed++;
                System.out.println("  FAIL  " + name + "  expected " + show(expected) + ", got " + show(got));
            }
        } catch (UnsupportedOperationException e) {
            todo++;
            System.out.println("  TODO  " + name);
        } catch (Exception | StackOverflowError e) {
            failed++;
            System.out.println("  FAIL  " + name + "  threw " + e);
        }
    }

    private static String show(Object o) {
        if (o instanceof int[] a) return Arrays.toString(a);
        if (o instanceof String s) return "\"" + s + "\"";
        return String.valueOf(o);
    }

    private static void summary() {
        System.out.printf("%n%d passed, %d failed, %d todo%n", passed, failed, todo);
    }
}
