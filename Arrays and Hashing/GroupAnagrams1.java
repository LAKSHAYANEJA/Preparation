class Solution {
    public String getFrequencyKey(String word) {
        int[] freq = new int[26];
        String key = "";

        for(int i=0;i<word.length();i++) {
            freq[word.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++) {
            key += freq[i] + "#";
        }
        return key;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            String word = strs[i];
            String key = getFrequencyKey(word);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
