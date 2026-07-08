
import java.io.*;
import java.util.*;

public class DailyTemperatures {
    
    public static int[] dailyTemp(int[] temperatures){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        int n = temperatures.length-1;
        
        for(int i=n;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = 0;
            }
            else{
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return answer;
    }
    
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
           System.out.println("DAILY TEMPERATURES");
           System.out.print("Enter the array size : ");
           int size = Integer.parseInt(br.readLine());
           
           int[] temperatures = new int[size];
           System.out.print("Enter the array element : ");
           for(int i=0;i<size;i++){
               temperatures[i] = Integer.parseInt(br.readLine());
           }
           int[] result = dailyTemp(temperatures);
           
           for(int num : result){
               System.out.print(num + " ");
           }
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}
