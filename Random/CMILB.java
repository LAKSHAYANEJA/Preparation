class Solution {
    public int totalMoney(int n) {
        int w = n/7, r = n%7;
        return 28*w+7*w*(w-1) / 2 + (2*w + r+1) * r/2;
    }
}
