class Solution {
    public int minimumOperations(int[] nums) {
        return (int) java.util.Arrays.stream(nums).filter(x -> x % 3 != 0).count();
    }
}
