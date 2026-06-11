
package variableslidingwindow;

import java.util.*;

public class VariableSlidingWindow {
        
    public int maxLenSubArray(int[] nums){
        int i=0;
        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int j=0;j<nums.length;j++){
          
            while(set.contains(nums[j])){
                set.remove(nums[j]);
                i++;
            }
            
            set.add(nums[j]);
            maxLen = Math.max(maxLen, j-i+1);
//            return maxLen;
        }
        
        return maxLen;
    }
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of your array : ");
        int size = scan.nextInt();
        
        int[] nums = new int[size];
        System.out.println("Enter the elements of your array : ");
        for(int i=0;i<size;i++){
            nums[i] = scan.nextInt();
        }
       
        VariableSlidingWindow mlsa = new VariableSlidingWindow();
        
        int result = mlsa.maxLenSubArray(nums);
        
        System.out.println(result);
        
        
    }
    
}
