class Solution {
    public int sumOfMultiples(int n) {
        return java.util.stream.IntStream.rangeClosed(1,n).
               filter(i -> i%3 == 0 || i%5 == 0 || i%7 == 0).sum();
    }
}
