import java.util.*;
import java.io.*;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[nums1.length];
        
        for(int i=nums2.length-1;i>=0;i--){
            int current = nums2[i];
            
            while(!stack.isEmpty() && current >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(current, -1);
            }
            else{
                map.put(current, stack.peek());
            }
            stack.push(current);
        }
        for(int i=0;i<nums1.length;i++){
            answer[i] = map.get(nums1[i]);
        }
        return answer;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("NEXT GREATER ELEMENT I");
        try{
            System.out.print("\n\t Enter the 1st array length : ");
            int len1 = Integer.parseInt(br.readLine());
            
            System.out.print("\n\t Enter the 2nd array length : ");
            int len2 = Integer.parseInt(br.readLine());
            
            int[] nums1 = new int[len1];
            int[] nums2 = new int[len2];
            
            System.out.print("Enter the array1 elements : ");
            for(int i=0;i<len1;i++){
                nums1[i] = Integer.parseInt(br.readLine());
            }
            System.out.print("Enter the array2 elements : ");
            for(int i=0;i<len2;i++){
                nums2[i] = Integer.parseInt(br.readLine());
            }
            
            int[] result = nextGreaterElement(nums1, nums2);
            
            for(int num : result){
                System.out.print(num+" ");
            }
            
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}
