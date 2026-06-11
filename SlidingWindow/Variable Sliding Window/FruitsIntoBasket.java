
package variableslidingwindow;

import java.util.*;
import java.io.*;

public class FruitsIntoBasket {
    public static int basket(int[] fruits){
        int l=0,r=0,maxlen=0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(r=0;r<fruits.length;r++){
            int currentCount = map.getOrDefault(fruits[r], 0);
            map.put(fruits[r], currentCount+1);
            
            if(map.size()>2){
                int fruitCount = map.get(fruits[l]);
                
                if(fruitCount==1){
                    map.remove(fruits[l]);
                }
                else{
                    map.put(fruits[l],fruitCount-1);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
        }
        
        return maxlen;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        
        FruitsIntoBasket fib = new FruitsIntoBasket();
        
        
        try{
            System.out.println("------------- FRUITS INTO BASKET ------------- \n\n");
            System.out.println("Enter the size of your array : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] fruits = new int[size];
            
            System.out.println("Enter the array elements : ");
            for(int i=0;i<size;i++){
                fruits[i] = Integer.parseInt(br.readLine());
            }
            
            int result = fib.basket(fruits);
            
            System.out.println("Maximum fruits in basket are : "+result);
        }
        catch(Exception IO){
            System.out.println("Invalid Input");
        }
    }
}
