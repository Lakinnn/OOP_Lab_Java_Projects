final class StringUtil {
    private StringUtil() {
        // Prevent object creation.
    }

    static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiou";

        for (char character : text.toLowerCase().toCharArray()) {
            if (vowels.indexOf(character) >= 0) {
                count++;
            }
        }

        return count;
    }

    static boolean isPalindrome(String text) {
        String cleaned = text
                .replaceAll("\\s+", "")
                .toLowerCase();

        String reversed = reverse(cleaned);

        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.reverse("hello"));
        System.out.println(StringUtil.countVowels("education"));
        System.out.println(StringUtil.isPalindrome("level"));

        // StringUtil utility = new StringUtil(); // Not allowed
    }
}
