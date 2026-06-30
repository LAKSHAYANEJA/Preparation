
package dsa;

import java.io.*;
import java.util.Arrays;

public class LongestConsectuiveSequence {
    public static int longSeq(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int maxCount = 1, count =1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    count++;
                }
                else{
                    maxCount = Math.max(maxCount, count);
                    count = 1; // reset count
                }
                
            }
        }
        
        return Math.max(maxCount, count);
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Longest Consecutive Sequence \n\t");
            System.out.print("Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] nums = new int[size];
            
            for(int i=0;i<size;i++){
                System.out.print("\n\t Enter the element "+(i+1)+" : ");
                nums[i] = Integer.parseInt(br.readLine());
            }
        int result = longSeq(nums);
        
        System.out.print("\n\t Maximum length of longest consecutive elements array :  "+result+"\n\n");
        }
        catch(IOException e){
            System.out.println("Error Triggered : "+e);
        }
    }
}
