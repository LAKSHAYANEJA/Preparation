class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[nums.length];

        return java.util.Arrays.stream(nums).filter(x -> ++freq[x] == 2).toArray();
    }
}
