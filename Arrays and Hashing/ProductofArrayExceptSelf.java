
package dsa;

import java.util.*;
import java.io.*;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf_BF(int[] nums){
        int n = nums.length;
        
        int[] res = new int[n];
        
        for(int i=0;i<n;i++){
            int prod = 1;
            for(int j=0;j<n;j++){
                if(i!=j) {prod *= nums[j];}
            }
            res[i] = prod;
        }
        return res;
    }
    
    public int[] productExceptSelf_OA(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        
        for(int i=1;i<n;i++){
            res[i] = res[i-1] * nums[i-1];
        }
        
        int postfix = 1;
        
        for(int i=n-1;i>=0;i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
    
    public static void main(String[] args){
        ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("Product of Array Except Self");
            System.out.print("\n\t Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] nums = new int[size];
            System.out.print("\n\t Enter the array elements : ");
            for(int i=0;i<size;i++){
                nums[i] = Integer.parseInt(br.readLine());
            }
            
            int[] result_BF = obj.productExceptSelf_BF(nums);
            int[] result_OA = obj.productExceptSelf_OA(nums);
            
            System.out.print("\n\n\t ----- BRUTE FORCE ----- \n\t");
            for(int numBF : result_BF){System.out.print(numBF+" ");}
            System.out.print("\n\t Time Complexity : O(n*n) \n\t Space Complexity : O(1) extra space \n\t O(n) space for the output array");
            
            System.out.print("\n\n\t ----- OPTIMAL APPROACH USING PREFIX & SUFFIX ----- \n\t");
            for(int numOA : result_OA){System.out.print(numOA+" ");}
            System.out.print("\n\t Time Complexity : O(n) \n\t Space Complexity : O(1) extra space \n\t O(n) space for the output array");

            
        }
        catch(IOException e) {
            System.out.println("Error Triggered : "+e);
        }
    }
}
