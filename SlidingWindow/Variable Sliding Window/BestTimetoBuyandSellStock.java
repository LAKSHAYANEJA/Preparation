
import java.io.*;
import java.util.*;
public class BestTimetoBuyandSellStock {
    
    // BRUTE FORCE
    public static int maxProfit_bf(int[] prices){
        int maxProfit = 0;
        // Step 1
        // Choose each element as buying price
        
        for(int i=0;i<prices.length;i++){
            int minPrice = prices[i];
            
            // Step 2
            // Search only future elements for selling 
            
            for(int j=i+1;j<prices.length;j++){
                int maxPrice = prices[j];
                
                // Step 3
                // Calculate profit within this window
                
                int profit = maxPrice - minPrice;
                
                // Step 4
                // Store maximum profit found so far
                
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    // OPTIMIZED APPROACH
    public static int maxProfit_OA(int[] prices){
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i=1;i<prices.length;i++){
            int cost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    
    public static void main(String[] args){
        BestTimetoBuyandSellStock stock = new BestTimetoBuyandSellStock();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try{
           
           
           System.out.println("Enter the size of your array : ");
           int size = Integer.parseInt(reader.readLine());
           int[] prices = new int[size];
           System.out.println("Enter the array elements : ");
           for(int i=0;i<size;i++){
               prices[i] = Integer.parseInt(reader.readLine());
           }
           
           System.out.print("Prices = ");
           for(int i=0;i<size;i++){
               System.out.print(prices[i]+" ");
           }
           System.out.println("\n\n\n----- BEST TIME TO BUY AND SELL STOCK -----\n");
           int result_bf = stock.maxProfit_bf(prices);
           System.out.println("\n----- BRUTE FORCE -----\n");
           System.out.println("\n\t The profit earnable is : "+result_bf);
           System.out.println("\n\t Time Complexity : O(n*n)");
           System.out.println("\n\t Space Complexity : O(1)");
           
           int result_OA = stock.maxProfit_OA(prices);
           System.out.println("\n ----- Optimal Approach -----\n");
           System.out.println("\n\t The profit earnable is : "+result_OA);
           System.out.println("\n\t Time Complexity : O(n)");
           System.out.println("\n\t Space Complexity : O(1)");
        }
        catch(Exception IO){
            System.out.println("Invalid Input...");
        }
    }
}
