class Solution {
    public int maximizeSum(int[] nums, int k) {
       int max = java.util.Arrays.stream(nums).max().getAsInt();
       return k * max + k * (k-1) / 2; 
    }
}
