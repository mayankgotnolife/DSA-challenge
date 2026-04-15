class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int lineLen = 0;

        for (String word : words) {
            if (lineLen + word.length() + currLine.size() > maxWidth) {
                res.add(justify(currLine, lineLen, maxWidth, false));
                currLine = new ArrayList<>();
                lineLen = 0;
            }
            currLine.add(word);
            lineLen += word.length();
        }
        res.add(justify(currLine, lineLen, maxWidth, true));

        return res;
    }

    private String justify(List<String> words, int lineLen, int maxWidth, boolean isLastLine) {
        int totalSpaces = maxWidth - lineLen;
        int gaps = words.size() - 1;

        if (gaps == 0 || isLastLine) {
            String line = String.join(" ", words);
            while (line.length() < maxWidth) line += " ";
            return line;
        }

        int baseSpaces = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < gaps) {
                int spaces = baseSpaces + (i < extraSpaces ? 1 : 0);
                sb.append(" ".repeat(spaces));
            }
        }
        return sb.toString(); 
    }               
}                   