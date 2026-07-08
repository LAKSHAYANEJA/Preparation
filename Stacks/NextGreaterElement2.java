
import java.util.*;
import java.io.*;

public class NextGreaterElement2 {
    
    public static int[] nextGreaterElements2(int[] nums){
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] answer = new int[n];
        
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%n]){
                stack.pop();
            }
            
            if(n>i){
                if(stack.isEmpty()){
                    answer[i] = -1;
                }
                else{
                    answer[i] = nums[stack.peek()];
                }
            }
            stack.push(i%n);
        }
        
        return answer;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("NEXT GREATER ELEMENT II");
            System.out.print("Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            int[] nums = new int[size];
            System.out.print("Enter the array elements : ");
            
            for(int i=0;i<size;i++){
                nums[i] = Integer.parseInt(br.readLine());
            }
            int[] result = nextGreaterElements2(nums);
            
            for(int num:result){
                System.out.print(num+" ");
            }
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}
