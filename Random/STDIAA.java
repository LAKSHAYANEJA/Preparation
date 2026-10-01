class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int n : nums) {
            sb.append(n);
        }
        return sb.chars().map(c -> c - '0').toArray();
    }
}
