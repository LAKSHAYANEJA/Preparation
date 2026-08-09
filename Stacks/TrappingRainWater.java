
// package stacks;

import java.util.*;
import java.io.*;


public class TrappingRainWater {
    public static int trapRainWater_usingDP(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int water = 0;
        
        leftMax[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        for(int i=0;i<height.length;i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return water;
    }
    
    public static int trapRainWater_MS(int[] height){
        Deque<Integer> stack = new ArrayDeque<>();
        int water=0;
        
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                
                if(stack.isEmpty()) break;
                
                int width = i-stack.peek()-1;
                int trappedHeight = Math.min(height[i], height[stack.peek()])- height[bottom];
                water += trappedHeight * width;
            }
            stack.push(i);
        }
        return water;
    }
    
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("TRAPPING RAIN WATER \n\n\t");
            System.out.print("\n\t Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] height = new int[size];
            
            System.out.print("\n\t Enter the array elements : ");
            for(int i=0;i<size;i++){
                height[i] = Integer.parseInt(br.readLine());
            }
            int result_DP = trapRainWater_usingDP(height);
            System.out.print("\n\t Using Dynamic Programming");
            System.out.print("\n\t The maximum water can be trapped is : "+result_DP+" units \n\t");
            System.out.print("\n\t Time Complexity : O(n) \n\t Space Complexity : O(n)  \n\t");
            
            int result_MS = trapRainWater_MS(height);
            System.out.print("\n\t Monotonic Stack");
            System.out.print("\n\t The maximum water can be trapped is : "+result_MS+" units \n\t");
            System.out.print("\n\t Time Complexity : O(n) \n\t Space Complexity : O(n)  \n\t");
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}
