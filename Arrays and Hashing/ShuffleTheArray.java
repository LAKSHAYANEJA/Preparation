class Solution {
    public int[] shuffle(int[] nums, int n) {
        int answer[] = new int[nums.length];

        for(int i=0;i<n;i++) {
            answer[2*i] = nums[i];
            answer[2*i+1] = nums[i+n];
        }

        return answer;
    }
}
