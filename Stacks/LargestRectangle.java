
import java.util.*;
import java.io.*;

public class LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int maximum = 0;
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];
        
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
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
        
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = heights.length;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        
        for(int i=0;i<heights.length;i++)
        {
            int height = heights[i];
            int width = nse[i] - pse[i] -1;
            int area = height * width;
            
            maximum = Math.max(maximum, area);
        }
        return maximum;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("Largest Rectangle in a Histogram");
            
            System.out.print("\n \t Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            int[] heights = new int[size];
            
            System.out.print("\n\t Enter the array element : ");
            for(int i=0;i<size;i++){
               heights[i] = Integer.parseInt(br.readLine());
            }
            
            int result = largestRectangleArea(heights);
            
            System.out.println("The area of largest rectangle : "+result);
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}
