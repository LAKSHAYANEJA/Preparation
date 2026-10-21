class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor=0;
        boolean[] seen = new boolean[51];
        for(int x : nums) if(seen[x]) xor^=x; else seen[x] = true;
        return xor;
    }
}
