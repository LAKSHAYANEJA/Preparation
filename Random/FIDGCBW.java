class Solution {
    public boolean canAliceWin(int[] nums) {
        int diff = 0;
        for(int x : nums) diff += (x<10) ? x : -x;
        return diff != 0;
    }
}
