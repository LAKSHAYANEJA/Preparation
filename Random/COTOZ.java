class Solution {
    public int countOperations(int num1, int num2) {
        int c = 0;
        for (; num1 > 0 && num2 > 0; c++) if (num1 >= num2) num1 -= num2; else num2 -= num1;
        return c;
    }
}
