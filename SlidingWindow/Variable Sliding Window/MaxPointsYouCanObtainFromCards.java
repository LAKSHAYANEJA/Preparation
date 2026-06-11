
package variableslidingwindow;

import java.util.*;
import java.io.*;

public class MaxPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k){
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<=k-1;i++){
            lsum+=cardPoints[i];
            maxSum = lsum;
        }
        int rindex = cardPoints.length-1;
        
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex--;
            
            maxSum = Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
    
    public static void main(String args[]){
        MaxPointsYouCanObtainFromCards mpycofc = new MaxPointsYouCanObtainFromCards();
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        try{
        System.out.println("Enter the array's length : ");
        
        int size = Integer.parseInt(br.readLine());
        int[] cardPoints = new int[size];
        System.out.println("Enter the array elements : ");
        for(int i=0;i<size;i++){
            cardPoints[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the subarray's length : ");
        int k = Integer.parseInt(br.readLine());
        
        int result = mpycofc.maxScore(cardPoints,k);
        System.out.println("The maximum score is : "+result);
        
        }
        catch(Exception IO){
            System.out.println("Error Input");
        }
    }
}
