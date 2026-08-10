
// package stacks;


import java.io.*;
import java.util.*;

public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int arr[]) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pse[] = new int[arr.length];
        int nse[] = new int[arr.length];
        long sum = 0;
        
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = arr.length;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        
        for(int i=0;i<arr.length;i++){
            int leftChoice = i - pse[i];
            int rightChoice = nse[i] - i;
            
            long numOfSubarrays = (long) leftChoice * rightChoice;
            
            long contribution = (long) arr[i] * numOfSubarrays;
            
            sum = (sum+contribution) % 1000000007;
        }
        
        return (int) sum;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("--- Sum of Subarray Minimums ---");
            System.out.print("\n\tEnter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int arr[] = new int[size];
            
            System.out.print("\n\t Enter the array elements : ");
            for(int i=0;i<size;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            int result = sumSubarrayMins(arr);
            System.out.print("\n\t The sum of all minimum elements from each subarray : "+result);
            System.out.print("\n\t It has been solved using Monotonic Stacks under O(n) Time Complexity and Space Complexity.\n\t");
        }
        catch(IOException error){
            System.out.print("\n\t Error Triggered : ");
        }
    }
}
