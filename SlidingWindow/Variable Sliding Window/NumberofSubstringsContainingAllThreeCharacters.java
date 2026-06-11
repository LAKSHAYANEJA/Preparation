
import java.io.*;
//import java.util.*;

public class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfStrings_BF(String s){
        int count = 0;
        int n = s.length();
//        char[] s1 = s.toCharArray();
        for(int i=0;i<n;i++){
            int[] hash = new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a'] = 1;
                if(hash[0]+hash[1]+hash[2] == 3){
                    count+=(n-j);
                    break;
                }
            }
        }
        return count;
    }
    
    public int numberOfStrings_OA(String s){
        int count = 0;
        int[] lastSeen = new int[3];
        lastSeen[0] = -1;
        lastSeen[1] = -1;
        lastSeen[2] = -1;
        
        
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a'] = i;
            
            if(lastSeen[0]!=-1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count=count+1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            }
        }
        
        return count;
    }
    
    public static void main(String[] args){
        NumberofSubstringsContainingAllThreeCharacters nos = new NumberofSubstringsContainingAllThreeCharacters();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("----- Number of Substrings Containing All Three Characters-----\n\n");
            
            System.out.print("\t Enter the string : ");
            String s = br.readLine();
            
            System.out.println("\n\tYour entered string was : "+s);
            
            int result_BF = nos.numberOfStrings_BF(s);
            System.out.println("\n\n\t ---BRUTE FORCE---\n");
            System.out.println("\t Number of substrings possible are : "+result_BF);
            System.out.println("\t Time Complexity : O(n*n) \n\t Space Complexity : O(1) \n ");
            
            int result_OA = nos.numberOfStrings_OA(s);
            System.out.println("\n\t ---OPTIMAL APPROACH---\n");
            System.out.println("\t Number of substrings possible are : "+result_OA);
            System.out.println("\t Time Complexity : O(n) \n\t Space Complexity : O(1) \n\n ");
            
        }
        catch(IOException e){
            System.out.println("Invalid Input...");
        }
    }
}
