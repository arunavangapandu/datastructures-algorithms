public class TextJustification {
    public static String justifyText(String text, int maxWidth) {
        StringBuilder justifiedText = new StringBuilder();
        String[] words = text.split(" ");

        int currentLineLength = 0;
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            int wordLength = word.length();

            // If adding the current word exceeds the maxWidth, justify the current line
            if (currentLineLength + wordLength + 1 > maxWidth) {
                justifiedText.append(justifyLine(currentLine.toString(), maxWidth));
                currentLine = new StringBuilder();
                currentLineLength = 0;
            }

            currentLine.append(word).append(" ");
            currentLineLength += wordLength + 1;
        }

        // Justify the last line (left-justified)
        justifiedText.append(currentLine.toString().trim());

        return justifiedText.toString();
    }

    private static String justifyLine(String line, int maxWidth) {
        String[] words = line.split(" ");
        int numWords = words.length;
        int totalSpaces = maxWidth - line.length() + numWords - 1;
        int spacesPerGap = totalSpaces / (numWords - 1);
        int extraSpaces = totalSpaces % (numWords - 1);

        StringBuilder justifiedLine = new StringBuilder();
        for (int i = 0; i < numWords; i++) {
            justifiedLine.append(words[i]);
            if (i < numWords - 1) {
                int numSpaces = spacesPerGap;
                if (extraSpaces > 0) {
                    numSpaces++;
                    extraSpaces--;
                }
                for (int j = 0; j < numSpaces; j++) {
                    justifiedLine.append(" ");
                }
            }
        }

        return justifiedLine.toString();
    }

    public static void main(String[] args) {
        String text = "This is an example of text justification.";
        int maxWidth = 20;
        String justifiedText = justifyText(text, maxWidth);
        System.out.println(justifiedText);
    }
}