
package fixedslidingwindow;

import java.util.*;

public class MaximumSubArraySum {
    
    public static int maxSumSubarray(int[] numbers, int k){
        if(numbers.length<k){
            System.out.println("Array too small");
            return -1;
        }
        int windowSum = 0;
        for(int i=0;i<k;i++){
            windowSum +=numbers[i];
        }
        int maxSum = windowSum;
        
        for(int i=k;i<numbers.length;i++){
            windowSum -= numbers[i-k];
            
            windowSum +=numbers[i];
            
            maxSum = Math.max(maxSum, windowSum);
            
            System.out.println("Window ["+(i-k+1)+"-"+i+"] ="+windowSum);
        }
        return maxSum;
        
    }

    public static void main(String[] args) {
        MaximumSubArraySum msas = new MaximumSubArraySum();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = scan.nextInt();
        int[] numbers = new int[size];
        
        System.out.println("Enter the elements of the array : ");
        for(int i=0;i<size;i++){
            numbers[i] = scan.nextInt();
        }
        System.out.println("Enter the size of the sub-array : ");
        int k = scan.nextInt();
        int result = msas.maxSumSubarray(numbers,k);
        System.out.println("Maximum SubArray Sum :  "+result);
    }
    
}
