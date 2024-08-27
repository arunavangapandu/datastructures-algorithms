package com.sorting;

public class StringTransformer {

    public static String rearrangeString(String s) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        
        // Process each chunk of 3 characters
        for (int i = 0; i <= length - 3; i += 3) {
            String chunk = s.substring(i, i + 3);
            // Move the first character to the end
            result.append(chunk.substring(1))
                    .append(chunk.charAt(0));
        }
        
        // Append any remaining characters (less than 3)
        if (length % 3 != 0) {
            result.append(s.substring(length - (length % 3)));
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(rearrangeString("abcdef")); // Output: "bcaefd"
        System.out.println(rearrangeString("abc"));    // Output: "bca"
        System.out.println(rearrangeString("abcdefgh")); // Output: "bcaefgh"
        System.out.println(rearrangeString("abcdefg"));  // Output: "bcaefg"
    }
}
