class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        for( String word : text.split(" ")) {
            if(word.chars().noneMatch(c -> brokenLetters.indexOf(c) != -1)) count++;
        }
        return count;
    }
}
