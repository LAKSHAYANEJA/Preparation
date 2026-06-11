import java.util.*;

public class TraverseEveryWindow {
    public static void slidingWindow(int[] nums , int k){
        int left=0;
        int right=0;
        int max_element = 0;
        ArrayList<Integer> nums1 = new ArrayList<>();
        while(right<nums.length){
           int windowSize = right-left+1;
           
            if(windowSize < k){
               right++;               
            }
            else if(windowSize == k){
                System.out.println("Window : ");
                for(int i=left;i<=right;i++){
                    System.out.print(nums[i]+" ");
                    
                }
                max_element = nums[left];
                System.out.println("\n The maximum element in this window is : ");

                max_element = Math.max(max_element, nums[right]);
                    System.out.print(max_element);
                    nums1.add(max_element);
                     
               System.out.println();
            
            left++;
            right++;
        }
        }
        
    }
    
   
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int k = 3;
        
        for(int i=0;i<nums.length;i++){
        System.out.print(nums[i] + " ");
        }
        System.out.println("k = "+k);
        
        TraverseEveryWindow tew = new TraverseEveryWindow();
        
        tew.slidingWindow(nums, k);
    }
}
